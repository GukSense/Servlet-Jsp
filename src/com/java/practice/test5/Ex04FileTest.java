package com.java.practice.test5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex04FileTest {

	public static void main(String[] args) {
		/*
		���� 1.
		���� ��Ű���� �������� ���� �� ������ ������ ����ϼ���.
		Path, createFile, newBufferedWriter�� ����ϼ���.
		���� 2.
		����ο� �����ο� ���� �˾ƺ��� �������� �ۼ��ϼ���.
		*/
		
		String projectDir = System.getProperty("user.dir");
		String packagePath = "src/com/java/practice/test5";
		
		String str = "Test ���� First �����Դϴ�.";
		Path p1 = Paths.get(projectDir).resolve(packagePath).resolve("file-newtestwriter.txt");
		
		try (
				BufferedWriter out = Files.newBufferedWriter(p1, Charset.forName("UTF-8"));
		) {
			out.write(str, 0, str.length());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		Path p2 = Paths.get(projectDir).resolve(packagePath).resolve("test3.txt");
		try{
			if(!Files.exists(p2))
			Files.createFile(p2);		
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
