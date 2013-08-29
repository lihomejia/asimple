package com.company.gap.base.component;

import java.util.Date;

import com.company.gap.base.util.DateUtils;

public class TranslatorWithDate extends AbstractTranslator<Date, String> {

	private TranslatorWithDate() {}
	
	private static TranslatorWithDate instance;
	
	public static TranslatorWithDate getInstance() {
		if (instance == null) {
			synchronized (TranslatorWithDate.class) {
				if (instance == null) {
					instance = new TranslatorWithDate();
				}
			}
		}
		return instance;
	}
	
	@Override
	public String translate(Date key) {
		return DateUtils.format(key);
	}
}