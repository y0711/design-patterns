import java.util.ArrayList;

public class Composite {
	public static void main(String[] args) {
		AbstractFile file = new Image();
		AbstractFile folder = new Folder();
		folder.add(file);
		folder.killVirus();
	}

}

interface AbstractFile {
	void killVirus();
	void add(AbstractFile file);
}

class Image implements AbstractFile {
	@Override
	public void killVirus() {
		System.out.println("Kill virus of image file.");
	}
	@Override
	public void add(AbstractFile file) {
		System.out.println("Error!");
	}
}

class Folder implements AbstractFile {
	private ArrayList<AbstractFile> list = new ArrayList<AbstractFile>();
	@Override
	public void killVirus() {
		System.out.println("Kill virus of folder.");
		for (AbstractFile file : list) {
			file.killVirus();
		}
	}
	@Override
	public void add(AbstractFile file) {
		list.add(file);
	}
}
