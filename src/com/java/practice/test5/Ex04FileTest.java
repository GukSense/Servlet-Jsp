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
		문제 1.
		현재 패키지에 빈파일을 생성 후 임의의 내용을 출력하세요.
		Path, createFile, newBufferedWriter를 사용하세요.
		문제 2.
		상대경로와 절대경로에 대해 알아보고 차이점을 작성하세요.
		*/
		
		String projectDir = System.getProperty("user.dir");
		String packagePath = "src/com/java/practice/test5";
		
		String str = "Test 전용 First 파일입니다.";
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
