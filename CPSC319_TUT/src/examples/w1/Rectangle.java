package examples.w1;

public class Rectangle {
	int length;
	int width;
	
	public Rectangle(int l, int w) {
		length = l;
		width = w;
	}
	
	public int get_area() {
		return width * length;
	}
}
