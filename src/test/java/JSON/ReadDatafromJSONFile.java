package JSON;

import java.io.FileReader;




import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDatafromJSONFile {
	public static String getDatafromJson(String Jsonfield ) throws IOException, ParseException {
		JSONParser jsonparse= new JSONParser();
		
		FileReader reader= new FileReader(".\\test_data\\data.json");
		
		
		Object obj = jsonparse.parse(reader);		   
	    JSONArray usersdetails1 = (JSONArray) obj;
	    System.out.println("Usersdetails ->" + usersdetails1);
	    JSONObject Username1 = (JSONObject)usersdetails1.get(0);
	   
	    JSONObject usersdetail = (JSONObject)Username1.get("usersdetails1");
	   
	    String user = (String)usersdetail.get(Jsonfield);
	    System.out.println("Username1:" + user);
		return user;

	}

//	private static void printpaths(File file) {
//		// TODO Auto-generated method stub
//		System.out.println("Absolute Path:" + file.getAbsolutePath());
//		
//		
//	}
}
