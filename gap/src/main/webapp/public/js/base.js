JGAP = {
	/**
	 * attach a action to a element on special event
	 * 
	 * @param obj,
	 *            DOMObject: window/document/element/node, and so on
	 * @param ev,
	 *            String: event name
	 * @param fn,
	 *            Function: function to act
	 * @param bol,
	 *            Boolean:
	 * @return, void
	 */
	on : function(obj, ev, fn, bol) {
		if (obj.attachEvent) {
			obj.attachEvent("on" + ev, fn);
		} else {
			obj.addEventListener(ev, fn, bol || false);
		}
	},

	/**
	 * Copy attributes from a object to another if the destination object has no
	 * such attribute
	 * 
	 * @param o,
	 *            Object: the destination object
	 * @param c,
	 *            Object: the source object
	 * @return the destination object
	 */
	applyIf : function(o, c) {
		if (o && c) for (var p in c)
			if (typeof o[p] == "undefined") {
				o[p] = c[p];
			}

		return o;
	},

	/**
	 * Copy attributes from a object to another.
	 * 
	 * @param o,
	 *            Object: the destination object
	 * @param c,
	 *            Object: the source object
	 * @return the destination object
	 */
	apply : function(o, c) {
		if (o && c) for (var p in c)
			o[p] = c[p];

		return o;
	}
}
JGAP.userDf = 'Y-m-d';
JGAP.getBp = function() {
	var bases = document.getElementsByTagName('BASE');
	return bases.length == 0 ? '' : bases[0].href;
}
JGAP.calUrl = function(url) {
	var bp = this.getBp();
	if (!bp) return url;
	var lu = url.toLowerCase();
	if(url.indexOf('/') == 0){
		url = url.substring(1);
	}
	return bp + url;
}
/*
if (!window.$) window.$ = function() {
	var elements = new Array();
	for (var i = 0; i < arguments.length; i++) {
		var element = arguments[i];
		if (typeof element == "string") {
			element = document.getElementById(element);
		}
		if (arguments.length == 1) {
			return element;
		}
		elements.push(element);
	}
	return elements;
}
*/

$A = Array.from = function(iterable) {
	if (!iterable) {
		return [];
	}
	if (iterable.toArray) {
		return iterable.toArray();
	} else {
		var results = [];
		for (var i = 0; i < iterable.length; i++) {
			results.push(iterable[i]);
		}
		return results;
	}
};

JGAP.applyIf(Array.prototype, {
	/**
	 * loop a attry, using callback function for each element,
	 * 
	 * @param fn,
	 *            a callback function
	 */
	each : function(fn) {
		for (var i = 0, l = this.length; i < l; i++)
			fn(this[i], i);
	},

	/**
	 * loop a array, using callback function for each element, but break at the
	 * time callback return a flag means stop
	 * 
	 * @param fn,
	 *            a function to be used as callback, with parameters of
	 *            (stopflag, member, index)
	 */
	gofor : function(fn) {
		var flag = new Object();
		for (var i = 0, l = this.length; i < l; i++)
			if (fn(flag, this[i], i) === flag) break;
	},

	indexOf : function(obj) {
		for (var i = 0, l = this.length; i < l; i++)
			if (this[i] === obj) return i;

		return -1;
	},

	/**
	 * delete element from ..
	 * 
	 * @parem idx, the index of the member
	 * @parem count, the number of memebers to be removed, default is 1
	 * @see Array.prototype.splice
	 * @return: A array contains the members which have been removed.
	 */
	removeAt : function(idx, count) {
		if (idx === undefined || idx == -1) return [];

		count = count || 1;

		return this.splice(idx, count);
	},

	remove : function(obj) {
		return this.removeAt(this.indexOf(obj));
	},

	/**
	 * to find out if arrry contains Object
	 */
	contains : function(obj) {
		return this.indexOf(obj) > -1;
	},

	select : function(fn) {
		var arr = [];
		this.each(function(obj) {
			if (fn(obj) === true) arr.push(obj);
		})

		return arr;
	}
});

JGAP.applyIf(String.prototype, {

	left : function(s, caseless) {
		var pos;
		if (caseless)
			pos = this.toLowerCase().indexOf(s.toLowerCase());
		else
			pos = this.indexOf(s);

		if (s < 0)
			return null;
		else
			return this.substring(0, pos);
	},

	startWith : function(s, caseless) {
		if (caseless)
			return this.toLowerCase().indexOf(s.toLowerCase()) == 0;
		else
			return this.indexOf(s) == 0;
	},

	endWith : function(s, caseless) {
		if (caseless)
			return this.toLowerCase().lastIndexOf(s.toLowerCase()) == this.length - s.length;
		else
			return this.lastIndexOf(s) == this.length - s.length;
	},

	ltrim : function() {
		this.replace(/^(\s)+/i, "");
	},

	rtrim : function() {
		this.replace(/(\s)+$/i, "");
	},
	replaces : function() {
		var tag = /&nbsp;/g;
		return this.replace(tag, "");
	}
});

JGAP.applyIf(Function.prototype, {

	/**
	 * bind a function to a object as the object's method, it means, in the
	 * function, variant will refre to the object
	 * 
	 * <pre>
	 * // Example:
	 * o = new Object();
	 * function m() {
	 * 	alert($A(arguments))
	 * }
	 * o.m1 = m.bind(o, &quot;b1&quot;, &quot;b2&quot;);
	 * o.m1(&quot;a1&quot;, &quot;a2&quot;);
	 * // will alert a msg : &quot;b1, b2, a1, a2&quot;;
	 * </pre>
	 * 
	 * @param obj,
	 *            Object: any variant
	 * @param arg1(..argn),
	 *            Object: any variant, added to the function's arguments
	 * @return the function that has been binded.
	 */
	bind : function(obj, arg1, argn) {
		var method = this;
		var _args = $A(arguments).slice(1);

		return function() {
			return method.apply(obj, _args.concat($A(arguments)));
		}
	},

	/**
	 * bind a function to a Object as a method with specilfied name
	 * 
	 * @param obj,
	 *            Object: any variant
	 * @param mname,
	 *            String: the method name
	 * @param arg1,
	 *            Object, any variant
	 */
	bindAs : function(obj, mname, arg1, argn) {
		var method = this;
		var _args = $A(arguments);
		_args.splice(1, 1);

		return obj[name] = method.bind.apply(method, _args);
	}
});