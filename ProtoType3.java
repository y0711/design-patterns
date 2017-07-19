import static java.lang.System.out;

class Attr {
	String name;
	public Attr(String name) {
		this.name = name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}

interface Button {
	Button clone();
	void setColor(String color);
	String getColor();
	void setAttr(Attr attr);
	Attr getAttr();
}

class ConcreteButton implements Button, Cloneable {
	private String color;
	private Attr attr;
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
	@Override
	public Attr getAttr() {
		return attr;
	}
	@Override
	public void setAttr(Attr attr) {
		this.attr = attr;
	}
}

public class ProtoType3 {
	public static void main(String[] args) {
		Button b0 = new ConcreteButton();
		b0.setColor("red");
		Attr attr = new Attr("size");
		b0.setAttr(attr);

		Button b1 = b0.clone();
		
		out.println("b0 == b1? " + (b0 == b1));
		// Identical because of shallow clone. 
		out.println("button attr identical? " + (b0.getAttr() == b1.getAttr()));	
	}
}
