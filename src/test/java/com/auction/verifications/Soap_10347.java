package com.auction.verifications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.Test;

import com.auction.init.Common;
import com.auction.init.ConfigFileReader;

public class Soap_10347 {
	static ConfigFileReader configFileReader= new ConfigFileReader();

	@Test
	public static void Verify_to_save_Quantity_digits_value_via_Create_and_Update_Item_SOAP_request() throws IOException {
		
		/***************** CREATE_ITEM ***************/
		System.out.println("***********************Create Item***********************");
		String str_itemname = Common.generateRandomChars(6);
		final String POST_CITEM = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://dev.auctionserver.net/api/soap12\">\r\n"
				+ "  <soapenv:Header>\r\n" + "    <soap:Authenticate>\r\n" + "        <Login>admin</Login>\r\n"
				+ "        <Password>123123</Password>\r\n" + "    </soap:Authenticate>\r\n"
				+ "     <soap:SetNamespace>\r\n" + "        <Namespace>SAM lot_item.id</Namespace>\r\n"
				+ "     </soap:SetNamespace>\r\n" + "  </soapenv:Header>\r\n" + "  <soapenv:Body>\r\n"
				+ "     <soap:CreateItem>\r\n" + "<Name>"+str_itemname+"</Name>\r\n" + "        <Data>\r\n"
				+ "  <Quantity>22.11</Quantity>\r\n" + "<QuantityDigits>8</QuantityDigits>\r\n" + "</Data>\r\n" + "</soap:CreateItem>\r\n"
				+ "  </soapenv:Body>\r\n" + "</soapenv:Envelope>";
		System.out.println(POST_CITEM);
		URL obj = new URL(configFileReader.getdevUrl()+"api/soap12");
		HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		postConnection.setRequestMethod("POST");
		postConnection.setRequestProperty("Content-Type", "application/json");

		postConnection.setDoOutput(true);
		OutputStream os = postConnection.getOutputStream();
		os.write(POST_CITEM.getBytes());
		os.flush();
		os.close();

		int responseCode = postConnection.getResponseCode();
		System.out.println("POST Response Code :  " + responseCode);
		System.out.println("POST Response Message : " + postConnection.getResponseMessage());
		System.out.println("POST Requested Method : " + postConnection.getRequestMethod());

		String str = null;
		if (responseCode == 200) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println("Response Body :" + response.toString());
			str = response.substring(352, 358);

			System.out.println("Generated ItemId :" + str);
		} else {
			System.out.println("POST NOT WORKED");
		}

	
	
	/***************** UPDATE_ITEM ***************/
	System.out.println("***********************Update Item***********************");
 
	final String POST_CITEM1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://dev.auctionserver.net/api/soap12?wsdl\">\r\n"
			+ "   <soapenv:Header>\r\n" + "    <soap:Authenticate>\r\n" + "        <Login>admin</Login>\r\n"
			+ "        <Password>123123</Password>\r\n" + "    </soap:Authenticate>\r\n"
			+ "    <soap:SetNamespace>\r\n" + "        <Namespace>SAM lot_item.id</Namespace>\r\n"
			+ "     </soap:SetNamespace>\r\n" + "   </soapenv:Header>\r\n" + "   <soapenv:Body>\r\n"
			+ "      <soap:updateItem>\r\n" + "         <Id>" + str + "</Id>\r\n" + "         <Data>\r\n"
			+ "      <Quantity>22.11</Quantity>\r\n" + "        <QuantityDigits>3</QuantityDigits>\r\n"
			+ "         </Data>\r\n" + "      </soap:updateItem>\r\n" + "   </soapenv:Body>\r\n"
			+ "</soapenv:Envelope>";
	System.out.println(POST_CITEM1);
	URL obj1 = new URL(configFileReader.getdevUrl()+"api/soap12");
	HttpURLConnection postConnection1 = (HttpURLConnection) obj1.openConnection();
	postConnection1.setRequestMethod("POST");
	postConnection1.setRequestProperty("Login", "admin");
	postConnection1.setRequestProperty("Password", "123123");
	postConnection1.setRequestProperty("Namespace", "SAM lot_item.id");
	postConnection1.setRequestProperty("Content-Type", "application/json");

	postConnection1.setDoOutput(true);
	OutputStream os1 = postConnection1.getOutputStream();
	os1.write(POST_CITEM1.getBytes());
	os1.flush();
	os1.close();

	int responseCode1 = postConnection1.getResponseCode();
	System.out.println("POST Response Code :  " + responseCode1);
	System.out.println("POST Response Message : " + postConnection1.getResponseMessage());
	System.out.println("POST Requested Method : " + postConnection1.getRequestMethod());

	if (responseCode1 == 200) { // success
		BufferedReader in = new BufferedReader(new InputStreamReader(postConnection1.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println("Response Body :" + response.toString());
//        String str = response.substring(352, 358);
//        
//        System.out.println("generated id :" +str);
	} else {
		System.out.println("POST NOT WORKED FOR UPDATE");
	}
	}
}
