
/**
 * validators, return true for success, false for failure, and string result for
 * reason.
 * 
 */
var validator = function() {

	function getLenb(s1) {
		var len = 0, c;
		for (var i = 0; c = s1.charCodeAt(i); i++)
			len += (c > 255) ? 2 : 1;

		return len;
	}

	/**
	 * field {:0} must >= {:1} and <= {:2}
	 */
	function formatMsg(s1, reps) {
		return s1.replace(/\{:(.*?)\}/ig, function(a1, field) {
			return reps[field] != undefined ? reps[field] : '';
		});
	}

	var fields = [];
	var fns = [];

	return {
		msgs : {
			notnull : "不能为空.",
			notnum : "不是数字.",
			notint : "不是整数.",
			notlt : "数字不能小于",
			notgt : "数字不能大于",
			lenbngt : "长度不能大于",
			notdate : "不是日期 格式",
			nottime : "不是时间格式",
			notemail : "不是邮箱格式.",
			validkey : "无效输入."
		},
		/**
		 * 注册一个字段为待验证字段,一般可以这样写: //
		 * empId字段,注册三个规则:不能为空;只能包含keys规则包含的内容;长度不能超过100字节.
		 * validator.regist({id: 'empId', name: '员工号'}, 'notnull', 'keys', {type :
		 * 'lenb', length : 100}) // empName字段,注册为不能为空. validator.regist({id:
		 * 'empName', name: '员工姓名'})
		 * 
		 * @param {String/Object}field,
		 *            标准写法是Object { id:要验证的域的id
		 *            name:要验证域的显示名称,当这个域值校验失败后会提示类似这样,"用户姓名 不能为空",如果该参数为空,使用id }
		 *            非标准写法: 如果是字符串,字段的id
		 * 
		 * @param {String/Object}ops
		 *            从第二个参数开始,都是此类参数,一次定义多个. 标准写法是Object { type:使用系统内置验证,验证类型.
		 *            name:当前域的名称,信息提示给用户看的,如果没,则使用field id
		 *            fn:直接作为验证函数(这个函数将作为反调函数使用,第一个参数是value,第二个参数是op)fn返回true,则成功,否则失败,如果返回非boolean,则当作错误提示.
		 *            msg:验证失败后的返回信息 } 非标准写法: 如果是字符串,相当于{type:}
		 *            如果是一个function,相当于{fn:}
		 * 
		 */
		regist : function(field, ops) {
			ops = $A(arguments).slice(1);
			if (ops.length == 0)
				ops = [{
					type : "notnull"
				}];

			for (var i = 0, l = ops.length; i < l; i++) {
				if (typeof ops[i] == "string")
					ops[i] = {
						type : ops[i]
					};
				else if (typeof ops[i] == "function")
					ops[i] = {
						fn : ops[i]
					};

				if (ops[i].type && typeof(this[ops[i].type]) != "function")
					throw new Error("Not a registed type : " + ops[i].type);

				if (!ops[i].type && typeof(ops[i].fn) != "function")
					throw new Error("If not any parameter named 'type', you must specify 'fn' parameter for a function.");
			}

			if (typeof(field) == 'string')
				field = {
					id : field
				};

			var pos = 0;
			l = fields.length;
			for (; pos < l; pos++)
				if (fields[pos].id == field.id)
					break;

			if (pos == l)
				fields.push({
					id : field.id,
					name : field.name,
					ops : ops
				});
			else
				fields[pos].ops = fields[pos].ops.concat(ops);
		},
		unregist : function(field) {
			if (typeof(field) == 'string')
				field = {
					id : field
				};
			var pos = 0;
			l = fields.length;
			for (; pos < l; pos++) {
				if (fields[pos].id == field.id) {
					fields.removeAt(pos,1);
					break;
				}
			}
		},
		/**
		 * 注册全局校验函数.
		 * 
		 * @param fns,
		 *            若干个函数,函数返回结果true表示验证通过,验证不通过返回字符串,表示错误信息.
		 */
		registGlobal : function() {
			fns = fns.concat.apply(fns, $A(arguments));
		},

		/**
		 * 在第一个异常就停下.
		 */
		ACTION_ONFIRST : 1,
		/**
		 * 校验全部的.
		 */
		ACTION_SILENCE : 2,
		actionType : 0,
		setActionType : function(atype) {
			this.actionType = atype;
		},

		validate : function() {
			var ers = [];
			var efs = [];
			fields.gofor((function(stopflag, field) {
				var ops = field.ops;

				// 获得当前域值.
				var ovalue = document.getElementById(field.id);
				var fvalue = ovalue && ovalue.value;
				ops.gofor((function(stflag, op) {
					var fn = this[op.type] || op.fn;
					var ret = fn.apply(this, [fvalue].concat(op));

					if (ret === true)
						return;
					var reps = {
						field : (field.name || field.id),
						value : fvalue
					}

					if (op.msg !== undefined){
						if((op.useSelfMsg !==undefined)&&(typeof(op.useSelfMsg) == "boolean")&&op.useSelfMsg){
							ers.push(op.msg);
						}else{
							ers.push((field.name || field.id) + " " + op.msg);
						}
					}
					else if (typeof(ret) == "boolean")
						ers.push((field.name || field.id));
					else if (typeof(ret) == "string")
						ers.push((field.name || field.id) + " " + ret);

					efs.push(field.id);
					return stflag;
				}).bind(this));

				if (ers.length > 0 && (this.ACTION_ONFIRST & this.actionType))
					return stopflag;
			}).bind(this));

			fns.gofor(function(stopflag, fn) {
				var ret = fn();
				if (ret === true)
					return;

				ers.push(ret);

				if (ers.length > 0 && (this.ACTION_ONFIRST & this.actionType))
					return stopflag;
			})

			if (ers.length == 0)
				return true;

			ers.splice(0, 0, this.msgs.validkey + '　　　　　　　　　　　\n');

			if (!(this.ACTION_SILENCE & this.actionType))
				alert(ers.join("\n"));

			this.focus(efs[0]);

			return false;
		},

		focus : function(f) {
			try {
				document.getElementById(f).focus()
			} catch (e) {
			}
		},

		/**
		 * bind validator to the form onsubmit event
		 */
		bindForm : function(form) {
			var onsub = this.validate;
			var _this = this;
			if (document.body)
				document.getElementById(form).onsubmit = onsub.bind(_this);
			else
				JGAP.on(window, "load", function() {
					_this.bindForm(form);
				});
		},

		registType : function(type, fn) {
			this[type] = fn;
		},

		//
		// /////////////////////////////////////
		//

		// 验证函数,特征为,验证结束后,返回true,表示成功;返回字符串,表示失败,并且有信息提示;返回其它,失败,系统尝试获取错误提示;
		/**
		 * 空检测,包括null/undefined,和空字符串.
		 */
		notnull : function(val) {
			return (val !== null && val !== undefined && val != "")
					? true
					: this.msgs.notnull;
		},

		/**
		 * 一个简单的email检测.
		 */
		email : function(val) {
			return (!val || new RegExp("[^@]+@[^\\.@]+(\\.[^\\.@]+)+")
					.test(val))
					|| this.msgs.notemail;
		},

		/**
		 * 数字检测,是否是一个数字,如果是,是否在指定区段范围内.
		 */
		number : function(val, op) {
			if (val == undefined || isNaN(val))
				return this.msgs.notnum;

			op = op || {};
			if (op.start !== undefined && val < op.start)
				return this.msgs.notlt + " '" + op.start + "'";
			if (op.end !== undefined && val > op.end)
				return this.msgs.notgt + " '" + op.end + "'";

			return true;
		},

		/**
		 * byte长度检测,不要超过指定length. 注意:如果是null,当前检测是认为通过.
		 */
		lenb : function(val, op) {
			if (this.notnull(val) !== true)
				return true;

			op = op || {};
			return !(op.length !== undefined && getLenb(val) > op.length)
					|| (this.msgs.lenbngt + " '" + op.length + "'");
		},

		/**
		 * 长度检测,不要超过指定length 注意:如果是null,当前检测认为是通过.
		 */
		len : function(val, op) {
			if (this.notnull(val) !== true)
				return true;

			op = op || {};
			return !(op.length !== undefined && val.length > op.length)
					|| (this.msgs.lenbngt + " '" + op.length + "'");
		},

		/**
		 * 数字检测,是否为空/为有效数字/为整数/指定大小范围内.
		 */
		'int' : function(val, op) {
			var isnm = this.number(val);
			if (isnm !== true)
				return isnm;

			if (parseInt(val) != val)
				return this.msgs.notint;

			op = op || {};
			if (op.start !== undefined && val < op.start)
				return this.msgs.notlt + " '" + op.start + "'";
			if (op.end !== undefined && val > op.end)
				return this.msgs.notgt + " '" + op.end + "'";

			return true;

		},

		/**
		 * 日期检测,当前这个函数比较特殊,使用了Ext特性函数.
		 */
		date : function(val, op) {
			if (Date.parseDate)
				return !!Date.parseDate(val, JGAP.userDf) || this.msgs.notdate;

			op = op || {};
			var fs = [];
			fs.push(op.format || "^\\d{4}-\\d{1,2}-\\d{1,2}$",
					"\\d{1,2}/\\d{1,2}/\\d{4}");
			for (var i = 0, l = fs.length; i < l; i++)
				if (val == undefined || new RegExp(fs[i]).test(val))
					return true;

			return this.msgs.notdate;
		},

		/**
		 * 数字,有问题......少用.
		 */
		num : function(val) {
			return (val == undefined || new RegExp("^\\d+(\\.\\d+)?$")
					.test(val))
					|| this.msgs.notnum;
		},

		/**
		 * 是否是时间格式.意义不大,以后根据实际情况修改.
		 */
		time : function(val) {
			return (val == undefined || new RegExp("^\\d{1,2}:\\d{1,2}\\d{1,2}$")
					.test(val))
					|| this.msgs.nottime;
		},

		/**
		 * 当前验证值将作为规范代码(code)存入数据库
		 * 
		 * 注意:如果是null,则认为是通过检测(当前做如此规定而已).
		 */
		code : function(val) {
			return (this.notnull(val) !== true || new RegExp(
					"^[\\(\\)\\-\\*a-z0-9/_]+$", 'i').test(val))
					|| this.msgs.validkey;
		},

		/**
		 * 当前验证值将作为key字段存入数据库,只能有0-9 a-z(不分大小写) _ - *@.这些字符.
		 * 注意:如果是null,则认为是通过检测(当前做如此规定而已).
		 */
		keys : function(val) {
			return (this.notnull(val) !== true || new RegExp(
					"^[\\/\\-\\*\\.\\@a-z0-9_]+$", 'i').test(val))
					|| this.msgs.validkey;
		},
		
		identifier : function(val) {
			return (this.notnull(val) !== true || new RegExp(
					"^[a-z0-9_]+$", 'i').test(val))
					|| this.msgs.validkey;
		}
	}
}();