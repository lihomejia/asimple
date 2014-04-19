package com.company.gap.base.component;

import org.springframework.stereotype.Component;

@Component
public class TranslatorWithCell extends TranslatorImplOnDb {
	
	private TranslatorWithCell() {
		super("t_production_cell", "id", "code");
	}

	private static TranslatorWithCell instance;
	
	public static TranslatorWithCell getInstance() {
		if (instance == null) {
			synchronized (TranslatorWithCell.class) {
				if (instance == null) {
					instance = new TranslatorWithCell();
				}
			}
		}
		return instance;
	}
}