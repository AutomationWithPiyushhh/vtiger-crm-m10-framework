package ddt_extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropertiesFile {
	public static void main(String[] args) throws IOException {
//		step 1> create the java representation object of the physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		
//		step 2> load all the keys by using non static method load(fis)
		Properties pObj = new Properties();
		pObj.load(fis);
		
//		step 3> get the value by using getProperty() and pass the key in double quote
		String browser = pObj.getProperty("bro");
		System.out.println(browser);
		
//		dont forget to close the file
		fis.close();
	}
}
