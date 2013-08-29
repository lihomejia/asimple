package com.company.gap.base.component;

import com.company.gap.base.model.Status;

public class TranslatorWithStatus extends AbstractTranslator<Integer, String> implements GapTranslator {

	private TranslatorWithStatus() {}
	
	private static TranslatorWithStatus instance;
	
	public static TranslatorWithStatus getInstance() {
		if (instance == null) {
			synchronized (TranslatorWithStatus.class) {
				if (instance == null) {
					instance = new TranslatorWithStatus();
				}
			}
		}
		return instance;
	}
	
	@Override
	public String translate(Integer key) {
		return Status.valueOf(key).getName();
	}

}


