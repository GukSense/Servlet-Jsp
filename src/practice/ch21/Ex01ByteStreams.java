package practice.ch21;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex01ByteStreams {

	public static void main(String[] args) {
		
		FileInputStream oldIn = null;
		FileOutputStream oldOut = null;
		try {
			oldIn = new FileInputStream("./src/practice/ch21/test.txt");
			oldOut = new FileOutputStream("./src/practice/ch21/out-fileoutputstream1.txt");

			int c;
			
			while((c = oldIn.read()) != -1) {
				oldOut.write(c);
			}
			System.out.println("< FileInputStream / FileOutputStream >");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(oldIn != null) oldIn.close();
				if(oldOut != null) oldOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
		System.out.println();
		
		
		
	}

}
