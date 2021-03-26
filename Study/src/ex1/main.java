package ex1;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GePrinter<Powder>powder=new GePrinter<>();
		powder.setMaterial(new Powder());
		
		System.out.println(powder.toString());
		
		GePrinter<Plastic>plastic=new GePrinter<>();
		plastic.setMaterial(new Plastic());
		
		System.out.println(plastic.toString());
	}

}
