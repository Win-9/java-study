package ex16;

import java.io.FileInputStream;

public class FileInputStreamTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		try(FileInputStream fis=new FileInputStream("input.txt")) {
			byte[]bs=new byte[10];
			while((i=fis.read(bs))!=-1) {
				for(int ch:bs) {
					System.out.print((char)ch);
				}
				System.out.println();
			}
		}catch(Exception e){
			
		}
	}

}
