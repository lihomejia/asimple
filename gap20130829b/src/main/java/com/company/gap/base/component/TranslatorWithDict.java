package com.company.gap.base.component;

import com.company.gap.resource.component.DictHelper;

public class TranslatorWithDict extends AbstractTranslator<Integer, String> implements GapTranslator {

	private TranslatorWithDict() {}
	
	private static TranslatorWithDict instance;
	
	public static TranslatorWithDict getInstance() {
		if (instance == null) {
			synchronized (TranslatorWithDict.class) {
				if (instance == null) {
					instance = new TranslatorWithDict();
				}
			}
		}
		return instance;
	}
	
	@Override
	public String translate(Integer key) {
		return DictHelper.getDict(key).getName();
	}
}