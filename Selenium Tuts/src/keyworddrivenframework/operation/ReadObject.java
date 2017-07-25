package keyworddrivenframework.operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadObject {
	Properties p = new Properties();
	
	public Properties getObjectRepository() throws IOException {
		InputStream is = new FileInputStream(new File(System.getProperty("user.dir")+"/src/keyworddrivenframework/objects/object.properties")); 
		
		p.load(is);
		return p;
		
	}
}
