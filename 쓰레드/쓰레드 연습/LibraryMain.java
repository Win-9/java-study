package ex20;

import java.util.ArrayList;

class FastLibrary{
	public ArrayList<String>shelf=new ArrayList<>();
	
	public FastLibrary() {
		shelf.add("Book1");
		shelf.add("Book2");
		shelf.add("Book3");
	}
	
	public synchronized String lendBook() throws InterruptedException{
		
		Thread t = Thread.currentThread();
		
		while(shelf.size() == 0 ) {
			System.out.println(t.getName() + " waiting start");
			wait();
			System.out.println(t.getName() + " waiting end");
		}
		String book = shelf.remove(0);
		System.out.println(t.getName() + ": " + book + " lend");
	
		return book;
	}
	
	public synchronized void returnBook(String book){
		Thread t = Thread.currentThread();
		
		shelf.add(book);
		notify();
		System.out.println(t.getName() + ": " + book + " return");
	}

}

class Student extends Thread{
	
	public Student(String name) {
		super(name);
	}
	public void run(){

		try{
				
			
			String title = LibraryMain.library.lendBook();
			if( title == null ) return;
			sleep(5000);
			LibraryMain.library.returnBook(title);
			
		}catch (InterruptedException e) {
			System.out.println(e);
		}
	}

}

public class LibraryMain {
	
	public static FastLibrary library=new FastLibrary();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student std1=new Student("std1");
		Student std2=new Student("std2");
		Student std3=new Student("std3");
		Student std4=new Student("std4");
		Student std5=new Student("std5");
		
		std1.start();
		std2.start();
		std3.start();
		std4.start();
		std5.start();

	}

}
