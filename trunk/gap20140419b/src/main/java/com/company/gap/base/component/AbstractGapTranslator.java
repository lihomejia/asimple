package com.company.gap.base.component;

import java.util.List;

import com.company.util.New;

public abstract class AbstractGapTranslator implements GapTranslator {

	@Override
	public List<String> translate(List<Integer> keys) {
		List<String> ret = New.arrayList();
		for (Integer k : keys){
			ret.add(translate(k));
		}
		return ret;
	}

}
