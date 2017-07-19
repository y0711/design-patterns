import static java.lang.System.out;

import java.io.ObjectOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

class Attr implements Serializable {
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

class Button implements Serializable {
	private String color;
	private Attr attr;
	public Button deepClone() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(this);
		
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		return (Button)ois.readObject();
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	public Attr getAttr() {
		return attr;
	}
	public void setAttr(Attr attr) {
		this.attr = attr;
	}
}

public class ProtoType4 {
	public static void main(String[] args) {
		Button b0 = new Button();
		b0.setColor("red");
		Attr attr = new Attr("size");
		b0.setAttr(attr);

		Button b1 = null;
		try {
		b1 = b0.deepClone();
		} catch (Exception e) {
			System.err.println("deep clone error");
		}
		
		out.println("b0 == b1? " + (b0 == b1));
		// Not identical because of deep clone. 
		out.println("button attr identical? " + (b0.getAttr() == b1.getAttr()));
		out.println("button attr name? b0,b1: " 
		+ b0.getAttr().getName() + ", " + b1.getAttr().getName());
		
	}
}
