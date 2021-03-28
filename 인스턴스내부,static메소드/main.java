package ex8;

class OutClass{
	private int num=0;
	private static int snum=20;
	private inClass inClass;
	public OutClass() {
		inClass=new inClass();
	
	}
	class inClass{
		int inum=100;
		
		void inTest() {
			System.out.println("OutClass num="+num);
			System.out.println("OutClass snum="+snum);
			System.out.println("OutClass inum="+inum);
		}
	}
	public void usingClass() {
		inClass.inTest();
	}
	
	static class Instatic{
		int inum=100;
		static int snum=200;
		void inTest() {
			System.out.println("OutClass num="+inum);
			System.out.println("OutClass snum="+snum);
			System.out.println("OutClass inum="+inum);
		}
		
		static void sTest() {
			System.out.println("OutClass snum="+snum);
		}
	}
}
public class inner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*OutClass o=new OutClass();
		o.usingClass();
		
		OutClass.inClass inner=o.new inClass();
		inner.inTest();*/
		
		OutClass.Instatic s=new OutClass().Instatic();
		s.inTest();
		
		System.out.println();
		
		OutClass.Instatic.sTest();
		
	}

}
