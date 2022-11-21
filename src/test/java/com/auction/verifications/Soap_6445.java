package com.auction.verifications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import org.testng.annotations.Test;

import com.auction.init.ConfigFileReader;

import freemarker.core.ReturnInstruction.Return;

import java.io.OutputStreamWriter;

import java.net.HttpURLConnection;

import java.net.MalformedURLException;

import java.net.ProtocolException;

import java.net.URL;

public class Soap_6445 {

	static ConfigFileReader configFileReader= new ConfigFileReader();
	@Test
	public static void Create_Update_Delete_Item_POSTRequest() throws IOException {

		/***************** CREATE_ITEM ***************/
		System.out.println("***********************Create Item***********************");
		final String POST_PARAMS = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"https://dev.auctionserver.net/api/soap12\">\r\n"
				+ "    <soapenv:Header>\r\n" + "    <soap:Authenticate>\r\n" + "      <Login>admin</Login>\r\n"
				+ "      <Password>123123</Password>\r\n" + "    </soap:Authenticate>\r\n"
				+ "    <soap:SetNamespace>\r\n" + "       <Namespace>SAM lot_item.id</Namespace>\r\n"
				+ "     </soap:SetNamespace>\r\n" + "   </soapenv:Header>\r\n" + "   <soapenv:Body>\r\n"
				+ "      <soap:CreateItem>\r\n" + "      <AccountId xsi:nil=\"true\"/>\r\n"
				+ "         <Name >SOAP Lot 1</Name>\r\n" + "         <Data>\r\n" + "             <Categories>\r\n"
				+ "                 <Category>my category 12113</Category>\r\n"
				+ "                 <Category>my category 12123</Category>\r\n"
				+ "                 <Category>child category 12133</Category>\r\n" + "              </Categories>\r\n"
				+ "         </Data>\r\n" + "     </soap:CreateItem>\r\n" + "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		System.out.println(POST_PARAMS);
		URL obj = new URL(configFileReader.getdevUrl()+"api/soap12");
		HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		postConnection.setRequestMethod("POST");
		postConnection.setRequestProperty("Login", "admin");
		postConnection.setRequestProperty("Password", "123123");
		postConnection.setRequestProperty("Namespace", "SAM lot_item.id");
		postConnection.setRequestProperty("Content-Type", "application/json");

		postConnection.setDoOutput(true);
		OutputStream os = postConnection.getOutputStream();
		os.write(POST_PARAMS.getBytes());
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

			System.out.println("Generated id :" + str);
		} else {
			System.out.println("POST NOT WORKED");
		}

		/***************** UPDATE_ITEM ***************/
		System.out.println("***********************Update Item***********************");

		final String POST_PARAMS1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://dev.auctionserver.net/api/soap12?wsdl\">\r\n"
				+ "   <soapenv:Header>\r\n" + "    <soap:Authenticate>\r\n" + "        <Login>admin</Login>\r\n"
				+ "        <Password>123123</Password>\r\n" + "    </soap:Authenticate>\r\n"
				+ "    <soap:SetNamespace>\r\n" + "        <Namespace>SAM lot_item.id</Namespace>\r\n"
				+ "     </soap:SetNamespace>\r\n" + "   </soapenv:Header>\r\n" + "   <soapenv:Body>\r\n"
				+ "      <soap:updateItem>\r\n" + "         <Id>" + str + "</Id>\r\n" + "         <Data>\r\n"
				+ "    <Categories>\r\n" + "                 <Category>my category 111.11</Category>\r\n"
				+ "                 <Category>my category 121.22</Category>\r\n"
				+ "                 <Category>child category 321.21</Category>\r\n" + "              </Categories>\r\n"
				+ "         </Data>\r\n" + "      </soap:updateItem>\r\n" + "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		System.out.println(POST_PARAMS1);
		URL obj1 = new URL(configFileReader.getdevUrl()+"api/soap12");
		HttpURLConnection postConnection1 = (HttpURLConnection) obj1.openConnection();
		postConnection1.setRequestMethod("POST");
		postConnection1.setRequestProperty("Login", "admin");
		postConnection1.setRequestProperty("Password", "123123");
		postConnection1.setRequestProperty("Namespace", "SAM lot_item.id");
		postConnection1.setRequestProperty("Content-Type", "application/json");

		postConnection1.setDoOutput(true);
		OutputStream os1 = postConnection1.getOutputStream();
		os1.write(POST_PARAMS1.getBytes());
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
//	        String str = response.substring(352, 358);
//	        
//	        System.out.println("generated id :" +str);
		} else {
			System.out.println("POST NOT WORKED FOR UPDATE");
		}

		/***************** DELETE_ITEM ***************/
		System.out.println("***********************Delete Item***********************");

		final String POST_PARAMS2 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"https://dev.auctionserver.net/api/soap12?wsdl\">\r\n"
				+ "  <soapenv:Header>\r\n"
				+ "    <soap:Authenticate>\r\n"
				+ "        <Login>admin</Login>\r\n"
				+ "        <Password>123123</Password>\r\n"
				+ "    </soap:Authenticate>\r\n"
				+ "    <soap:SetNamespace>\r\n"
				+ "        <Namespace>SAM lot_item.id</Namespace>\r\n"
				+ "     </soap:SetNamespace>\r\n"
				+ "   </soapenv:Header>\r\n"
				+ "   <soapenv:Body>\r\n"
				+ "      <soap:deleteItem>\r\n"
				+ "         <Id>"+str+"</Id>\r\n"
				+ "      </soap:deleteItem>\r\n"
				+ "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		System.out.println(POST_PARAMS2);
		URL obj2 = new URL(configFileReader.getdevUrl()+"api/soap12");
		HttpURLConnection postConnection2 = (HttpURLConnection) obj2.openConnection();
		postConnection2.setRequestMethod("POST");
		postConnection2.setRequestProperty("Login", "admin");
		postConnection2.setRequestProperty("Password", "123123");
		postConnection2.setRequestProperty("Namespace", "SAM lot_item.id");
		postConnection2.setRequestProperty("Content-Type", "application/json");

		postConnection2.setDoOutput(true);
		OutputStream os2 = postConnection2.getOutputStream();
		os2.write(POST_PARAMS2.getBytes());
		os2.flush();
		os2.close();

//	    HttpURLConnection postConnection1 = (HttpURLConnection) obj1.openConnection();
		int responseCode2 = postConnection2.getResponseCode();
		System.out.println("POST Response Code :  " + responseCode2);
		System.out.println("POST Response Message : " + postConnection2.getResponseMessage());
		System.out.println("POST Requested Method : " + postConnection2.getRequestMethod());

		if (responseCode2 == 200) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(postConnection2.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println("Response Body :" + response.toString());
//	        String str = response.substring(352, 358);
//	        
//	        System.out.println("generated id :" +str);
		} else {
			System.out.println("POST NOT WORKED FOR DELETE");
		}

	}

	@Test
	public static void POSTRequest1() throws IOException {

		final String POST_PARAMS = "{\n" + "\"userId\": 101,\r\n" + "    \"id\": 101,\r\n"
				+ "    \"title\": \"Test Title\",\r\n" + "    \"body\": \"Test Body\"" + "\n}";
		System.out.println(POST_PARAMS);
		URL obj = new URL("https://jsonplaceholder.typicode.com/posts");
		HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		postConnection.setRequestMethod("POST");
		postConnection.setRequestProperty("userId", "a1bcdefgh");
		postConnection.setRequestProperty("Content-Type", "application/json");

		postConnection.setDoOutput(true);
		OutputStream os = postConnection.getOutputStream();
		os.write(POST_PARAMS.getBytes());
		os.flush();
		os.close();

		int responseCode = postConnection.getResponseCode();
		System.out.println("POST Response Code :  " + responseCode);
		System.out.println("POST Response Message : " + postConnection.getResponseMessage());

		if (responseCode == HttpURLConnection.HTTP_CREATED) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("POST NOT WORKED");
		}
	}
}
