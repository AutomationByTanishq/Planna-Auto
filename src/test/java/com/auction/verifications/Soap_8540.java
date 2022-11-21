package com.auction.verifications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import org.testng.annotations.Test;

import freemarker.core.ReturnInstruction.Return;

import java.io.OutputStreamWriter;

import java.net.HttpURLConnection;

import java.net.MalformedURLException;

import java.net.ProtocolException;

import java.net.URL;

import com.auction.init.Common;
import com.auction.init.ConfigFileReader;

public class Soap_8540 {
	static ConfigFileReader configFileReader= new ConfigFileReader();
	
	@Test
	public static void Create_User_With_Blocked_Flag_POSTRequest() throws IOException {

		String str_username = Common.generateRandomChars(5);
		System.out.println("***********************Create User With Blocked Flag***********************");
		final String POST_PARAMS = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://dev.auctionserver.net/api/soap12\">\r\n"
				+ "  <soapenv:Header>\r\n" + "    <soap:Authenticate>\r\n" + "        <Login>admin</Login>\r\n"
				+ "        <Password>123123</Password>\r\n" + "    </soap:Authenticate>\r\n"
				+ "     <soap:SetNamespace>\r\n" + "        <Namespace>SAM user.id</Namespace>\r\n"
				+ "     </soap:SetNamespace>\r\n" + "  </soapenv:Header>\r\n" + "  <soapenv:Body>\r\n"
				+ "     <soap:CreateUser>\r\n" + "        <Username>"+str_username+"-flag</Username>\r\n" + "        <Data>\r\n"
				+ "            <Flag>BLOCKED</Flag>\r\n" + "        </Data>\r\n" + "     </soap:CreateUser>\r\n"
				+ "  </soapenv:Body>\r\n" + "</soapenv:Envelope>";
		System.out.println(POST_PARAMS);
		URL obj = new URL(configFileReader.getdevUrl()+"api/soap12");
		HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		postConnection.setRequestMethod("POST");
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
			str = response.substring(414, 419);

			System.out.println("Generated ItemId :" + str);
		} else {
			System.out.println("POST NOT WORKED");
		}

	}
}
