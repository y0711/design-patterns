import static java.lang.System.out;

interface Button {
	Button clone();
	void setColor(String color);
	String getColor();
}

class ConcreteButton implements Button, Cloneable {
	private String color;
	@Override
	public Button clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (Exception e) {
			System.err.println("not supported cloneable");
		}
		return (Button)obj;
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

public class ProtoType2 {
	public static void main(String[] args) {
		Button b0 = new ConcreteButton();
		b0.setColor("red");
		Button b1 = b0.clone();
		
		out.println("b0 == b1? " + (b0 == b1));
		out.println("button 0, 1 color: " + b0.getColor() + ", " + b1.getColor());
	}
}
