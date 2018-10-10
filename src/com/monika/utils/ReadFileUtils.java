package com.monika.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class ReadFileUtils {
	
	public static String readSmallFile(String path) throws IOException {
		File file = new File(path);
		if (!file.exists() || file.isDirectory()) {
			throw new FileNotFoundException();
		}

		BufferedReader br = new BufferedReader(new FileReader(file));
		String temp = null;
		StringBuffer sb = new StringBuffer();
		temp = br.readLine();
		while (temp != null) {
			sb.append(temp);
			temp = br.readLine();
		}
		br.close();
		return new String(sb.toString().getBytes("ascii"),"utf-8");
	}

	/**
	 * 读二进制文件
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static String fileReadBinary(String path) throws IOException{
		FileInputStream fileInputStream = new FileInputStream(new File(path));
		byte[] buffer = new byte[1024];
		int len = 0;
		StringBuilder builder = new StringBuilder();

		while((len=fileInputStream.read(buffer))!=-1) {
			builder.append(new String(buffer,0,len));
		}
		fileInputStream.close();
		return builder.toString();
	}

	/**
	 * 将文件ANSI编码(GBK或GB2312)转换为UTF-8编码
	 */
	public static void GBK2UTF(String path , String newPath){
		File file;
		File newFile;
		InputStreamReader isr;
		OutputStreamWriter osw;
		try {
			file  = new File(path);
			newFile = new File(newPath);
			if (!newFile.exists()){
				newFile.createNewFile();
			}
			isr = new InputStreamReader(new FileInputStream(file), "GBK");//ANSI编码
			osw =  new OutputStreamWriter(new FileOutputStream(newFile), "UTF-8"); //存为UTF-8
			int len = isr.read();
			while(-1 != len)
			{
				osw.write(len);
				len = isr.read();
			}
			//刷新缓冲区的数据，强制写入目标文件
			osw.flush();
			osw.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}