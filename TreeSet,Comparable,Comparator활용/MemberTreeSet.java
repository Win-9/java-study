package ex6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class MemberTreeSet {
	private HashSet<Member>set;
	
	public MemberTreeSet() {
		set=new HashSet<>();
	}
	
	public MemberTreeSet(int size) {
		set=new HashSet<>(size);
	}
	
	public void addMember(Member member) {
		set.add(member);
	}
	
	public boolean removeMember(int  memberId) {
		/*for(int i=0;i<list.size();i++) {
			Member member=list.get(i);
			
			int tempId=member.getMemberId();
			if(tempId==memberId) {
				list.remove(i);
				return true;
			}
		}*/
		
		Iterator<Member>iter=set.iterator();
		
		while(iter.hasNext()){
			Member member=iter.next();
			
			int temp=member.getMemberId();
			if(temp==memberId) {
				set.remove(member);
				return true;
			}
		}
		
		System.out.println(memberId+"not exist");
		return false;
	}
	
	public void showAllMember() {
		for(Member member:set) {
			System.out.println(member);
		}
		System.out.println();
	}
	
}
