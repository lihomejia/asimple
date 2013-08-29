package com.company.gap.base.dao.search;

import java.util.ArrayList;
import java.util.List;

public class Ops {
	
	/** 1 */
	public static final int CONTAINS = Op.CONTAINS.code;
	/** 2 */
	public static final int STARTS = Op.STARTSWITH.code;
	/** 4 */
	public static final int ENDS = Op.ENDSWITH.code;
	/** 8 */
	public static final int EQ = Op.EQ.code;
	/** 16 */
	public static final int NE = Op.NE.code;
	/** 32 */
	public static final int LT = Op.LT.code;
	/** 64 */
	public static final int GT = Op.GT.code;
	/** 128 */
	public static final int LE = Op.LE.code;
	/** 256 */
	public static final int GE = Op.GE.code;
	/** 512 */
	public static final int BT = Op.BT.code;
	/** 1024 */
	public static final int IN = Op.IN.code;
	/** ALL Ops */
	public static final int OPS_ALL = Integer.MAX_VALUE;
	
	public static final int OPS_NORMAL = EQ | NE;
	
	public static final int OPS_NUMBER_ALL = EQ | NE | LT | GT | LE | GE | BT;
	
//	public static final int OPS_NUMBER_NORMAL = 
	
	/**
	 * 查看指定的ops代码里面,是否有包括指定的op code
	 */
	public static boolean means(int ops, int op){
		return (ops & op) > 0;
	}
	
	/**
	 * 创建多个op的联合代码
	 * 
	 * @param ops
	 * @return
	 */
	public static int MulOps(int ... ops){
		int x = 0;
		for (int i = 0, l = ops.length; i < l; i++){
			x |= ops[i];
		}
		
		return x;
	}
	
	public static Op[] getOps(int codes){
		List<Op> ops = new ArrayList<Op>();
		for (Op op : Op.ops.values()){
			if (means(codes, op.code)){
				ops.add(op.clone());
			}
		}
		Op[] ret = new Op[ops.size()];
		ops.toArray(ret);
		
		return ret;
		
	}
	
	public static void main(String[] args){
//		System.out.println(means(NORMAL, NE));
//		System.out.println(means(NORMAL, EQ));
//		System.out.println(means(NORMAL, Ops.LE));
		
		for (Op op : getOps(Ops.EQ | Ops.OPS_NORMAL|Ops.BT)){
			System.out.println(op.getName());
		}
		
	}

}
