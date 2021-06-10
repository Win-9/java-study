package ex13;

import java.util.ArrayList;
import java.util.Comparator;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Customer>arr=new ArrayList<>();
		
		arr.add(new Customer("FUCK",12,50000));
		arr.add(new Customer("That",15,60000));
		arr.add(new Customer("Shit",20,90000));
		
		arr.stream().map(s->s.getName()).forEach(s->System.out.println(s));
		
		int total=arr.stream().mapToInt(s->s.getPrice()).sum();
		System.out.println("total:"+total);
		
		arr.stream().filter(s->s.getAge()>=15).
		sorted(Comparator.comparing(Customer::getAge).reversed()).
		forEach(s->System.out.println(s.toString()));;
	}

}
