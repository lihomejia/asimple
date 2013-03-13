package com.company.gap.base.dao.search;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Op implements Cloneable, Serializable {

	/**
	 * 获取指定的op.
	 * @param name Op的名称,一般即该运算符,特殊的有四个,startswidth/endswidth/contains/between(不区分大小写).
	 * 
	 * @return
	 */
	public static Op getOp(String name) {
		return name == null ? null : namedOps.get(name.toLowerCase());
	}

	private static void regist(Op[] os) {
		for (Op op : os) {
			ops.put(op.code, op);
			namedOps.put(op.name.toLowerCase(), op);
			op.readonly = true;
		}
	}
	/**
	 * 在sql中的表达式
	 */
	protected String oper;
	/**
	 * 显示给用户的代码信息,比如,like 'aa%',这个表示的是一个以aa字符串开始的查询,StartsWidth
	 *  以后将在这里面加入多语言信息.
	 */
	protected String name;
	/**
	 * code代码,唯一标记了当前Operator,需要是2^n(幂次,0<=n<62)
	 */
	protected int code;

	/**
	 * 为了避免外部代码误操作修改,Op产生后,将用这个固化.
	 */
	protected boolean readonly = false;

	public Op() {}

	public Op(String oper) {
		this.oper = oper;
		this.name = this.oper;
	}

	public Op(String oper, int i) {
		this.oper = oper;
		this.name = oper;
		this.code = i;
	}

	public Op(String oper, String name) {
		this.oper = oper;
		this.name = name;
	}

	public Op(String oper, String name, int code) {
		this(oper, name);
		this.code = code;
	}

	public boolean isMe(Op op) {
		return op != null && this.code == op.code;
	}

	public boolean isMe(String name) {
		return this.name.equalsIgnoreCase(name);
	}

	public boolean isMe(int code) {
		return this.code == code;
	}

	public Op clone() {
		Op op = new Op(this.oper, this.name, this.code);

		return op;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		else if (obj == this) {
			return true;
		}
		else if (!(obj instanceof Op)) {
			return false;
		}
		else if (((Op) obj).name.equalsIgnoreCase(this.name)) {
			return true;
		}

		return false;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getOper() {
		return oper;
	}

	public void setCode(int i) {
		if (readonly) {
			return;
		}
		Op op = ops.get(i);
		if (op != null) {
			copyFrom(op);
			this.code = i;
		}
		else {
			//			throw new RuntimeException("Unknown oper value : " + i);
		}
	}

	public void setName(String name) {
		if (!readonly) {
			this.name = name;
		}
	}

	public void setOper(String op) {
		if (!readonly) {
			this.oper = op;
		}
	}

	public String toString() {
		return new StringBuilder().append("Op:").append(this.name).toString();
	}

	//
	// //////////////////////////////////////////
	//   系统内置Op,最多可扩展至62个
	// 

	private void copyFrom(Op o) {
		if (o == null) {
			return;
		}

		this.name = o.name;
		this.oper = o.oper;
		this.code = o.code;
	}

	public static final Op CONTAINS = new Op("like", "Contains", 1);

	public static final Op STARTSWITH = new Op("like", "StartsWith", 2);

	public static final Op ENDSWITH = new Op("like", "EndsWith", 4);

	public static final Op STARTS = STARTSWITH;
	public static final Op ENDS = ENDSWITH;

	public static final Op EQ = new Op("=", "eq", 8);

	public static final Op NE = new Op("<>", "ne", 16);

	public static final Op LT = new Op("<", "lt", 32);

	public static final Op GT = new Op(">", "gt", 64);

	public static final Op LE = new Op("<=", "le", 128);

	public static final Op GE = new Op(">=", "ge", 256);

	public static final Op BT = new Op("between", 512);

	public static final Op IN = new Op("in", 1024);

	public static final Op UP = new Op("in","up", 1024);
	/**
	 * 系统内部产生的一组常用操作符
	 */
	public static Map<Integer, Op> ops = new HashMap<Integer, Op>();

	private static final long serialVersionUID = -618338871198726633L;
	private static Map<String, Op> namedOps = new HashMap<String, Op>();

	static {
		regist(new Op[]{CONTAINS, STARTSWITH, ENDSWITH, EQ, NE, LT, GT, LE, GE, IN, BT, UP});
		//		ops = Collections.unmodifiableMap(ops);
	}

}
