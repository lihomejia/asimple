package com.company.gap.system.util;

import java.util.ArrayList;
import java.util.List;

public abstract class PwdEncrypter {
	/**
	 * 加密解密器.
	 * 
	 * @author zy.fang
	 */
	public static interface Encrypter {
		/**
		 * 解密一个字符串.
		 * 
		 * @param source
		 * @return
		 */
		public String decrypt(String source);

		/**
		 * 加密一个字符串.
		 * 
		 * @param source
		 * @return
		 */
		public String encrypt(String source);

	}

	private static Encrypter engine;
	private static List<Encrypter> engines = new ArrayList<Encrypter>();

	static {
		registInnerEngines();
		initWithConfig();
	}

	public static String decrypt(String source) {
		return engine.decrypt(source);
	}

	public static String encrypt(String source) {
		return engine.encrypt(source);
	}

	public static void main(String[] args) {
		String source = "1";
		String enc = PwdEncrypter.encrypt(source);
		String dec = PwdEncrypter.decrypt(enc);

		System.out.println(source + "|" + enc + "|" + dec);
	}

	private static void initWithConfig() {
		setEncrypter(1);
	}

	private static void registInnerEngines() {
		// 0 no encrypt
		engines.add(new Encrypter() {
			public String decrypt(String source) {
				return source;
			}

			public String encrypt(String source) {
				return source;
			}
		});

		// 1 普通的加密方案.
		engines.add(new Encrypter() {
			public String decrypt(String source) {
				return GapEncrypter.decrypt(source);
			}

			public String encrypt(String source) {
				return GapEncrypter.encrypt(source);
			}
		});
	}

	private static void setEncrypter(Encrypter encrypter) {
		engine = encrypter;
	}

	private static void setEncrypter(int code) {
		if (code > engines.size()) {
			throw new RuntimeException("Invalible code for inner Encrtpter Engine:" + code);
		}
		setEncrypter(engines.get(code));
	}
}