package ex4;

import java.util.ArrayList;

public class MemberArrayList {
	private ArrayList<Member>list;
	
	public MemberArrayList() {
		list=new ArrayList<>();
	}
	
	public MemberArrayList(int size) {
		list=new ArrayList<>(size);
	}
	
	public void addMember(Member member) {
		list.add(member);
	}
	
	public boolean removeMember(int  memberId) {
		for(int i=0;i<list.size();i++) {
			Member member=list.get(i);
			
			int tempId=member.getMemberId();
			if(tempId==memberId) {
				list.remove(i);
				return true;
			}
		}
		
		System.out.println(memberId+"not exist");
		return false;
	}
	
	public void showAllMember() {
		for(Member member:list) {
			System.out.println(member);
		}
		System.out.println();
	}
}
