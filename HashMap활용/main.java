package ex7;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberHashMap ml=new MemberHashMap();
	
		Member m4=new Member(004, "human4");

		Member m1=new Member(001, "human1");
		Member m2=new Member(002, "human2");
		Member m3=new Member(003, "human3");		
		
		ml.addHash(m1);
		ml.addHash(m2);
		ml.addHash(m3);
		ml.addHash(m4);
		
		ml.showAll();
		
		Member m5=new Member(004,"human5");
		ml.addHash(m5);
		ml.showAll();
	}

}
