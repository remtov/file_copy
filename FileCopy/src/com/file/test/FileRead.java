package com.file.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileRead {
	static Map<String,String> prop = new HashMap<String,String>();
	public static void main(String[] args) {
		String path = "c://test//ict.txt";
		try {
			InputStream is = new FileInputStream(new File(path));
			InputStreamReader ir = new InputStreamReader(is, "EUCKR");
			BufferedReader br = new BufferedReader(ir);
			String str;
			while ((str = br.readLine()) != null) {
				prop.put(str.split(":")[0], str.split(":")[1]);
			}
				System.out.println(prop.get("classname"));
				System.out.println(prop.get("subject"));
				System.out.println(prop.get("hangul"));
				
				Scanner s = new Scanner(System.in);
				System.out.println("저장할 경로 및 파일명을 적어주세요");
				path = s.nextLine();
				File f = new File(path);
				f.createNewFile();
				OutputStream os = new FileOutputStream(f);
				OutputStreamWriter ow = new OutputStreamWriter(os,"UTF-8"); 
				BufferedWriter bw = new BufferedWriter(ow);  
				bw.write("classname" + prop.get("classname"));
				bw.newLine();
				bw.write("subject" + prop.get("subject"));
				bw.flush();
				
				br.close();
				bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
