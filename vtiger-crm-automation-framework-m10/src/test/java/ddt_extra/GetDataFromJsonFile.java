package ddt_extra;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class GetDataFromJsonFile {
	public static void main(String[] args) throws IOException, ParseException {
//		step 1> create a java rep object of the physical file
		FileReader fr = new FileReader("./src/test/resources/cd.json");
		
//		step 2> pass the jro  non static method => parse(fr) to convert to Object
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(fr);
		
//		step 3> downcast Object to JSONObject to get the value
		JSONObject jObj = (JSONObject) obj;
		
//		step 4> by using get() and passing the key get the value
		String username = jObj.get("un").toString();
		String password = jObj.get("pwd").toString();
		System.out.println(username);
		System.out.println(password);
		
	}
}
