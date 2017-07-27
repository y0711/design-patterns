public class Decorator {
	public static void main(String[] args) {
		Component window = new Window();
		// Decorate with scroll bar.
		Component window2 = new ScollbarDecorator(window);
		// Decorate with black border.
		BlackborderDecorator window3 = new BlackborderDecorator(window2);
		window3.display();
	}
}

interface Component {
	void display();
}

class Window implements Component {
	@Override
	public void display() {
		System.out.println("show window");
	}
}

class ComponentDecorator implements Component {
	private Component c;
	public ComponentDecorator(Component c) {
		this.c = c;
	}
	@Override
	public void display() {
		c.display();
	}
}

class ScollbarDecorator extends ComponentDecorator {
	public ScollbarDecorator(Component c) {
		super(c);
	}
	@Override
	public void display() {
		super.display();
		show();
	}
	private void show() {
		System.out.println("show scollbar.");
	}
}

class BlackborderDecorator extends ComponentDecorator {
	public BlackborderDecorator(Component c) {
		super(c);
	}
	@Override
	public void display() {
		super.display();
		show();
	}
	private void show() {
		System.out.println("show black border.");
	}
}
