public class Facade {
	public static void main(String[] args) {
		EncryptFacade facade = new EncryptFacade();
		facade.process();
	}
}

class FileReader {
	void read() {
		System.out.println("read file");
	}
}

class FileEncrypt {
	void encrypt() {
		System.out.println("encrypt file");
	}
}

class FileSaver {
	void save() {
		System.out.println("save file");
	}
}

class EncryptFacade {
	private FileReader reader;
	private FileEncrypt encrypt;
	private FileSaver saver;
	
	EncryptFacade() {
		reader = new FileReader();
		encrypt = new FileEncrypt();
		saver = new FileSaver();
	}
	
	void process() {
		reader.read();
		encrypt.encrypt();
		saver.save();
	}
}
