package ex3;

public class main {
	public static <T,V> double make(Point<T, V>p1, Point<T, V>p2) {
		double left = ((Number)p1.getX()).doubleValue();
		double right =((Number)p2.getX()).doubleValue();
		double top = ((Number)p1.getY()).doubleValue();
		double bottom = ((Number)p2.getY()).doubleValue();
		
		double width = right - left;
		double height = bottom - top;
		
		return width * height;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(make(new Point<Integer,Double>(10,10.0),new Point<Integer,Double>(15,15.4)));
		
	}

}
