import static java.lang.System.out;

interface Button {
	Button clone();
	void setColor(String color);
	String getColor();
}

class ConcreteButton implements Button {
	private String color;
	@Override
	public Button clone() {
		Button b = new ConcreteButton();
		b.setColor(color);
		return b;
	}
	@Override
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String getColor() {
		return color;
	}
}

public class ProtoType {
	public static void main(String[] args) {
		Button b0 = new ConcreteButton();
		b0.setColor("red");
		Button b1 = b0.clone();
		
		out.println("b0 == b1? " + (b0 == b1));
		out.println("button 0, 1 color: " + b0.getColor() + ", " + b1.getColor());
	}
}
