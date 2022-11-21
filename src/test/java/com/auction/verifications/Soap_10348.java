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

public class Soap_10348 {
	static ConfigFileReader configFileReader = new ConfigFileReader();

	@Test
	public static void Verify_to_save_Quantity_digits_via_Create_and_Update_Auction_Lot_POSTRequest() throws IOException {

		/***************** CREATE_AUCTION ***************/
		System.out.println("***********************Create Auction***********************");
		final String POST_PARAMS = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"https://dev.auctionserver.net/api/soap12\">\r\n"
				+ "    <soapenv:Header>\r\n" + "    <soap:Authenticate>\r\n" + "      <Login>admin</Login>\r\n"
				+ "      <Password>123123</Password>\r\n" + "    </soap:Authenticate>\r\n"
				+ "    <soap:SetNamespace>\r\n" + "       <Namespace>SAM auction.id</Namespace>\r\n"
				+ "     </soap:SetNamespace>\r\n" + "   </soapenv:Header>\r\n" + "   <soapenv:Body>\r\n"
				+ "      <soap:CreateAuction>\r\n" + "      <AuctionType>T</AuctionType>\r\n" + "            <Data>\r\n"
				+ " 				<Name >soap auction</Name>\r\n" + "                <Timezone>UTC</Timezone>\r\n"
				+ "                 <StartClosingDate>2022-12-11 11:11:11</StartClosingDate>\r\n"
				+ "                 <StartBiddingDate> 2022-05-10 11:11:11 </StartBiddingDate>\r\n"
				+ "                 <PublishDate>2022-03-11 11:11:11</PublishDate>\r\n"
				+ "                  <StartRegisterDate>2022-03-11 11:11:11</StartRegisterDate>\r\n"
				+ "         </Data>\r\n" + "     </soap:CreateAuction>\r\n" + "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		System.out.println(POST_PARAMS);
		URL obj = new URL(configFileReader.getdevUrl() + "api/soap12");
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
			str = response.substring(355, 359);

			System.out.println("Generated Auction name :" + str);
		} else {
			System.out.println("POST NOT WORKED");
		}
	
		/***************** ADD_LOT ***************/
		System.out.println("***********************Add Lot***********************");

		final String POST_PARAMS1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://dev.auctionserver.net/api/soap12?wsdl\">\r\n"
				+ "   <soapenv:Header>\r\n" + "    <soap:Authenticate>\r\n" + "        <Login>admin</Login>\r\n"
				+ "        <Password>123123</Password>\r\n" + "    </soap:Authenticate>\r\n"
				+ "    <soap:SetNamespace>\r\n" + "        <Namespace>SAM auction_lot_item.id</Namespace>\r\n"
				+ "     </soap:SetNamespace>\r\n" + "   </soapenv:Header>\r\n" + "   <soapenv:Body>\r\n"
				+ "      <soap:CreateAuctionLot>\r\n" + "         <AuctionId>" + str + "</AuctionId>\r\n"
				+ "      <LotItemId>23242</LotItemId>\r\n		"
				+ "      <Data>\r\n   "
				+ "   	 <LotStatus>Active</LotStatus>\r\n   "                
				+ " 	<Quantity>23.8</Quantity>\r\n"
				+ "     <QuantityDigits>7</QuantityDigits>\r\n  "
				+ "         </Data>\r\n" + "      </soap:CreateAuctionLot>\r\n" + "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		System.out.println(POST_PARAMS1);
		URL obj1 = new URL(configFileReader.getdevUrl() + "api/soap12");
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

		String strnew = null;
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
	        strnew = response.substring(358, 364);
	        
	        System.out.println("Lot:" +strnew);
		} else {
			System.out.println("POST NOT WORKED FOR ADD LOT");
		}
		
		/***************** UPDATE_LOT ***************/
		System.out.println("***********************Update Lot***********************");

		final String POST_PARAMS3 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://dev.auctionserver.net/api/soap12?wsdl\">\r\n"
				+ "   <soapenv:Header>\r\n" + "    <soap:Authenticate>\r\n" + "        <Login>admin</Login>\r\n"
				+ "        <Password>123123</Password>\r\n" + "    </soap:Authenticate>\r\n"
				+ "    <soap:SetNamespace>\r\n" + "        <Namespace>SAM auction_lot_item.id</Namespace>\r\n"
				+ "     </soap:SetNamespace>\r\n" + "   </soapenv:Header>\r\n" + "   <soapenv:Body>\r\n"
				+ "      <soap:UpdateAuctionLot>\r\n" 
				+ "      <Id>" + strnew +"</Id>\r\n		"
				+ "      <Data>\r\n   "               
				+ " 	<Quantity>22.9</Quantity>\r\n"
				+ "     <QuantityDigits>3</QuantityDigits>\r\n  "
				+ "         </Data>\r\n" + "      </soap:UpdateAuctionLot>\r\n" + "   </soapenv:Body>\r\n"
				+ "</soapenv:Envelope>";
		System.out.println(POST_PARAMS3);
		URL obj3 = new URL(configFileReader.getdevUrl() + "api/soap12");
		HttpURLConnection postConnection3 = (HttpURLConnection) obj3.openConnection();
		postConnection3.setRequestMethod("POST");
		postConnection3.setRequestProperty("Login", "admin");
		postConnection3.setRequestProperty("Password", "123123");
		postConnection3.setRequestProperty("Namespace", "SAM lot_item.id");
		postConnection3.setRequestProperty("Content-Type", "application/json");

		postConnection3.setDoOutput(true);
		OutputStream os3 = postConnection3.getOutputStream();
		os3.write(POST_PARAMS3.getBytes());
		os3.flush();
		os3.close();

		int responseCode3 = postConnection3.getResponseCode();
		System.out.println("POST Response Code :  " + responseCode3);
		System.out.println("POST Response Message : " + postConnection3.getResponseMessage());
		System.out.println("POST Requested Method : " + postConnection3.getRequestMethod());

		@SuppressWarnings("unused")
		String str3 = null; 
		if (responseCode3 == 200) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(postConnection3.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println("Response Body :" + response.toString());
	        String str31 = response.substring(225, 251);
	        
	        System.out.println("Lot:" +str31);
		} else {
			System.out.println("POST NOT WORKED FOR UPDATE LOT");
		}
		
		
	}
}
