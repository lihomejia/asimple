
package com.company.gap.system.util;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public abstract class GapEncrypter {

	private static final String	algorithm	= "DESede";
	
	private static final String DEFAULT_ENCODING = "utf8";
	
	static final byte[]			key			= getDesKey();
	
	static {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
	}
	
	public static byte[] encrypt(byte[] source){
		try {
			return _encrypt(source);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static byte[] descrypt(byte[] source){
		try {
			return _decrypt(source);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String encrypt(String source) {
		try {
			return source == null ? null : 
				new BASE64Encoder().encode(_encrypt(source.getBytes(DEFAULT_ENCODING)));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String decrypt(String source) {
		
		try {
			return source == null ? null : 
				new String(_decrypt(new BASE64Decoder().decodeBuffer(source)),	DEFAULT_ENCODING);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private static byte[] _encrypt(byte[] source) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		SecretKey deskey = new SecretKeySpec(key, algorithm);
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, deskey);
		return cipher.doFinal(source);
	}

	private static byte[] _decrypt(byte[] source) throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		SecretKey k = new SecretKeySpec(key, algorithm);
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, k);

		return cipher.doFinal(source);

	}

	/**
	 * @return
	 */
	private static byte[] getDesKey()  {
		byte[] key = new byte[24];
		// chars in 127
		//  do not change this msg, never never.
		String norInfo = "nORMING cORPORATION, fzy 2008";

		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("md5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
		for (int i = 0; i < 3; i++) {
			byte[] buf = digest.digest(norInfo.substring(i).getBytes());
			for (int j = 0; j < 8; j++) {
				key[j + i * 8] = buf[j];
			}
		}

		return key;
	}
	
	
	public static void main(String[] args){
		String s = "";
		for (int i = 1; i <= 200; i++){
			s+= "1";
			String es = encrypt(s);
			System.out.println(s.length() + "/" + es.length());
		}
	}
}