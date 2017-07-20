import static java.lang.System.out;


interface Button {
	void show();
}

class BigButton implements Button {
	@Override
	public void show() {
		out.println("show big button");
	}
}

class SmallButton implements Button {
	@Override
	public void show() {
		out.println("show small button");
	}
}

interface Text {
	void show();
}

class LongText implements Text {
	@Override
	public void show() {
		out.println("show long text");
	}
}

class ShortText implements Text {
	@Override
	public void show() {
		out.println("show short text");
	}
}

interface Factory {
	Button getButton();
	Text getText();
}

class BigFactory implements Factory {
	@Override
	public Button getButton() {
		return new BigButton();
	}
	@Override
	public Text getText() {
		return new LongText();
	}
}

class SmallFactory implements Factory {
	@Override
	public Button getButton() {
		return new SmallButton();
	}
	@Override
	public Text getText() {
		return new ShortText();
	}
}

public class AbstractFactory {

	public static void main(String[] args) {
		// Factory f = new SmallFactory();
		Factory f = (Factory) XMLUtil.getBean("config.xml");

		Button b = f.getButton();
		Text t = f.getText();
		b.show();
		t.show();
	}

}
