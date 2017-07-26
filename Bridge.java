public class Bridge {
	public static void main(String[] args) {
		Image image = new PNGImage();
		ImageImpl impl = new LinuxImageImpl();
		image.setImpl(impl);
		
		image.display();
	}

}

class Matrix {}

abstract class Image {
	protected ImageImpl impl;
	public void setImpl(ImageImpl impl) {
		this.impl = impl;
	}
	public abstract Matrix parseData();
	public abstract void display();
}

class JPGImage extends Image {
	@Override
	public Matrix parseData() {
		System.out.println("parse JPG");
		return new Matrix();
	}
	@Override
	public void display() {
		Matrix m = parseData();
		impl.doPaint(m);
	}
}

class PNGImage extends Image {
	@Override
	public Matrix parseData() {
		System.out.println("parse PNG");
		return new Matrix();
	}
	@Override
	public void display() {
		Matrix m = parseData();
		impl.doPaint(m);
	}
}

interface ImageImpl {
	void doPaint(Matrix m);
}

class WindowsImageImpl implements ImageImpl {
	@Override
	public void doPaint(Matrix m) {
		System.out.println("on Windows ");
	}
}

class LinuxImageImpl implements ImageImpl {
	@Override
	public void doPaint(Matrix m) {
		System.out.println("on Linux ");
	}
}
