package ex5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class MemberHashSet {
	private HashSet<Member>set;
	private int memberId;
	
	public MemberHashSet() {
		set=new HashSet<>();
	}
	
	public MemberHashSet(int size) {
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
	
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member=(Member)obj;
			if(this.memberId==member.getMemberId()) {
				return true;
			}
			return false;
		}
		return false;
	}
}
