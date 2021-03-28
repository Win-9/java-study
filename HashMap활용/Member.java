package ex7;

import java.util.Comparator;

public class Member implements Comparator<Member> {
	private int memberId;
	private String memberName;
	
	public Member(int memberId,String memberName) {
		this.memberId=memberId;
		this.memberName=memberName;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String toString() {
		return memberName+"Id:"+memberId+".";
	}
	
	public int hashCode() {
		return memberId;
	}

	@Override
	public boolean equals(Object obj) {
		if( obj instanceof Member){
			Member member = (Member)obj;
			if( this.memberId == member.memberId )
				return true;
			else 
				return false;
		}
		return false;
	}

	/*public int compareTo(Member member) {
		return (this.memberId-member.memberId);
	}*/

	@Override
	public int compare(Member member1, Member member2) {
		// TODO Auto-generated method stub
		
		return (member1.memberId -member2.memberId);
	}

	
}
