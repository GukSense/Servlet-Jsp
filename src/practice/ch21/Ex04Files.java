package practice.ch21;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ex04Files {

	public static void main(String[] args) {
		String projectDir  = System.getProperty("user.dir");
		String packagePath = "src/com/java/practice/test5";
		String fileName =  "test2.txt";
		
		Path p1 = Paths.get(projectDir ).resolve(packagePath).resolve(fileName);
		System.out.println(String.format("%-20s", "user.dir: ") + projectDir );
		System.out.println(String.format("%-20s", "toAbsolutePath: ") + p1.toAbsolutePath());
		System.out.println(String.format("%-20s", "getFileName: ") + p1.getFileName());
		System.out.println(String.format("%-20s", "getName(0): ") + p1.getName(0));
		System.out.println(String.format("%-20s", "getName(1): ") + p1.getName(1));
		System.out.println(String.format("%-20s", "getNameCount: ") + p1.getNameCount());
		System.out.println(String.format("%-20s", "getName(n): ") + p1.getName(p1.getNameCount()-1));
		System.out.println(String.format("%-20s", "subpath: ") + p1.subpath(p1.getNameCount()-6, p1.getNameCount()-2));
		System.out.println(String.format("%-20s", "getParent: ") + p1.getParent());
		System.out.println(String.format("%-20s", "getRoot: ") + p1.toUri());	// 브라우저에서 사용 가능한 경로
		System.out.println();
		
		Path p2 = Paths.get("./src/com/");
		System.out.println(String.format("%-20s", "toString: ") + p2.toString());
		System.out.println(String.format("%-20s", "toString: ") 		+ p2.toString());
		System.out.println(String.format("%-20s", "toAbsolutePath: ") 	+ p2.toAbsolutePath());
		
		try {
			System.out.println(String.format("%-20s", "toRealPath: ") + p2.toRealPath());
		} catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		System.out.println("< 경로가 존재하지 않을 경우 >");
		Path p3 =  Paths.get("./src/error");
		try {
			System.out.println(String.format("%-20s", "toRealPath: ") 	+ p3.toRealPath());
		} catch(IOException e) {
			System.out.println(e.getMessage() + "경로가 존재하지 않습니다.");
		}
		System.out.println();
		
		try {
			System.out.println(String.format("%-20s", "size: ")+ Files.size(p1));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println(String.format("%-20s", "isDirectory: ") + Files.isDirectory(p1));		
		System.out.println();
		
		System.out.println("< newBufferedReader >");
		try (BufferedReader in = Files.newBufferedReader(p1, Charset.forName("UTF-8"))) {
		    String line = null;
		    int num = 0;
		    while ((line = in.readLine()) != null) {
		        System.out.println(++num + ": " + line);
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
		System.out.println();
		
		System.out.println("< newBufferedWriter >");
		String str = "Hello. 안녕하세요. ABcdeFg";
		Path p4 = Paths.get(projectDir).resolve(packagePath).resolve("file1-newbufferedwriter.txt");
		try (BufferedWriter out = Files.newBufferedWriter(p4, Charset.forName("UTF-8"))) {
		    out.write(str, 0, str.length());
		} catch (IOException e) {
		    e.printStackTrace();
		}
		System.out.println();
		
		System.out.println("< createFile >");
		Path p5 = Paths.get(projectDir).resolve(packagePath).resolve("test3.txt");
		try {
			Files.createFile(p5);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
