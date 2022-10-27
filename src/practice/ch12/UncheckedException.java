package practice.ch12;

import java.io.File;

public class UncheckedException {

	public static void main(String[] args) {
		
		File f = new File("./src/com/lcomputerstudy/books/java/ch12/hello.txt");
		try {
		f.createNewFile();		// Checked Exception
		} catch(Exception e) {
			
		}
		int[] arr = {3, 7, 5};
		System.out.println(arr[5]);	 // Unchecked Exception

	}

}

/*
���� 1.
f.createNewFile �� �ּ��� �����մϴ�.
�߻��� ���ܸ� try catch �� �̿��Ͽ� ó���ϼ���.
*/