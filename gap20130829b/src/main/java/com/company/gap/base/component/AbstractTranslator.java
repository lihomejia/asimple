package com.company.gap.base.component;

import java.util.List;

import com.company.util.New;

public abstract class AbstractTranslator<K, V> implements Translator<K, V> {

	@Override
	public List<V> translate(List<K> keys) {
		List<V> ret = New.arrayList();
		for (K k : keys){
			ret.add(translate(k));
		}
		
		return ret;
	}

}
