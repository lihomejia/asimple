package com.norming.ess.common.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;


/**
 * 文件处理类.
 * @author lh.jia
 * @2012.09.20
 * @version 1.0
 */
public class FileHelper {

	/**
	 * 读取一个文件内容.
	 * @param file
	 * @return 内容字符串.
	 * 
	 * @author lh.jia
	 * @date 2012.09.20
	 */
	public static String readFile(File file) {
		BufferedReader br = null;
		try {
			StringBuffer sb = new StringBuffer();
			br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			return sb.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 写入一个文件.
	 * @param file the file to be opened for writing.
	 * @param str 
	 * @param append if <code>true</code>, then bytes will be written
     *                   to the end of the file rather than the beginning
	 * 
	 * @author lh.jia
	 * @date 2012.09.20
	 * 
	 */
	public static void writeFile(File file, String str, boolean append) {
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(file, append));
			bos.write(str.getBytes());
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 复制jar文件.
	 * @param inFile
	 * @param outFile
	 * @throws IOException
	 * 
	 * @author lh.jia
	 * @date 2012.09.20
	 */
	public static void copyJarFile(File inFile, File outFile)
			throws IOException {

		final JarInputStream jarInStream = new JarInputStream(
				new BufferedInputStream(new FileInputStream(inFile)));
		final Manifest manifest = jarInStream.getManifest();

		final JarOutputStream jarOutStream = new JarOutputStream(
				new BufferedOutputStream(new FileOutputStream(outFile)),
				manifest);
		try {
			for (;;) {
				JarEntry je = jarInStream.getNextJarEntry();
				if (je == null) {
					break;
				}
				jarOutStream.putNextEntry(je);
				for (;;) {
					int iRead = jarInStream.read();
					if (iRead < 0)
						break;
					jarOutStream.write(iRead);
				}
			}
			jarOutStream.finish();
			jarInStream.closeEntry();
		} finally {
			jarOutStream.close();
			jarInStream.close();
		}
	}

	/**
	 * 以UTF8读取文件.
	 * @param file
	 * @return
	 * 
	 * @author lh.jia
	 * @date 2012.09.20
	 */
	public static String readUTF8File(File file) {
		StringBuffer sb = new StringBuffer();
		BufferedReader reader = null;
		try {
			FileInputStream fis = new FileInputStream(file);
			reader = new BufferedReader(new InputStreamReader(fis, "utf-8"));
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * 以UTF8写入文件.
	 * @param file the file to be opened for writing.
	 * @param str
	 * @param append if <code>true</code>, then bytes will be written
     *                   to the end of the file rather than the beginning
	 * 
	 * @author lh.jia
	 * @date 2012.09.20
	 */
	public static void writeUTF8File(File file, String str, boolean append) {
		BufferedOutputStream bos = null;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(file, append));
			bos.write(str.getBytes("utf-8"));
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
