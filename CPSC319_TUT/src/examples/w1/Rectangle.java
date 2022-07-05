package examples.w1;

public class Rectangle {
	public int length;
	public int width;
	
	// Constructor
	public Rectangle(int l, int w) {
		length = l;
		width = w;
	}
	
	public int get_area() {
		return width * length;
	}
}
