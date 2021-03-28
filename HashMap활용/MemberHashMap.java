package ex7;

import java.util.HashMap;
import java.util.Iterator;

public class MemberHashMap {
	private HashMap<Integer,Member>hashMap;
	
	public MemberHashMap() {
		hashMap=new HashMap<Integer, Member>();
	}
	
	public void addHash(Member member) {
		hashMap.put(member.getMemberId(), member);
	}
	public boolean removeMember(int id) {
		if(hashMap.containsKey(id)) {
			hashMap.remove(id);
			return true;
		}
		System.out.println("NO!");
		return false;
	}
	
	public void showAll() {
		Iterator<Integer>iter=hashMap.keySet().iterator();
		while(iter.hasNext()) {
			int key=iter.next();
			Member member=hashMap.get(key);
			System.out.println(member);
		}
	}
}
