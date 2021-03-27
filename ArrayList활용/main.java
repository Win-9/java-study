package ex4;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberArrayList ml=new MemberArrayList();
		
		Member m1=new Member(001, "human1");
		Member m2=new Member(002, "human2");
		Member m3=new Member(003, "human3");
		Member m4=new Member(004, "human4");
		
		
		ml.addMember(m1);
		ml.addMember(m2);
		ml.addMember(m3);
		ml.addMember(m4);
		
		ml.showAllMember();
		ml.removeMember(m1.getMemberId());
		ml.showAllMember();
	}

}
