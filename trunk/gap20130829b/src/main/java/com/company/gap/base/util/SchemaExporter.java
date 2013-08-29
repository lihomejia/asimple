package com.company.gap.base.util;

import javax.persistence.Persistence;

public class SchemaExporter {
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("mysql");
	}
}