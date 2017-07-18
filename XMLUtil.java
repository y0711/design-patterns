import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLUtil {
	public static Object getBean(){
		try {
			DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = df.newDocumentBuilder();
			Document doc = db.parse(new File("config.xml"));
			
			NodeList nl = doc.getElementsByTagName("className");
			Node node = nl.item(0).getFirstChild();
			String name = node.getNodeValue();
			
			Class c = Class.forName(name);
			Object obj = c.newInstance();
			return obj;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
