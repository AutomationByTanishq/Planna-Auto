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

public class SOAP_9540 {
	static ConfigFileReader configFileReader= new ConfigFileReader();
	
	@Test
	public static void Verify_to_create_and_update_Auction_with_Integer_and_Decimal_custom_fields_having_text_data_via_SOAP() 
			throws IOException {
		
		/***************** CREATE_AUCTION ***************/
		System.out.println("***********************CreateAuction***********************");
		String str_auctionname = Common.generateRandomChars(6);

		final String POST_AUCTION = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://qa3-6-auto.auctionserver.net/api/soap12\">\r\n"
				+ "<soapenv:Header>\r\n" + "<soap:Authenticate>\r\n" + "<Login>admin</Login>\r\n"
				+ "<Password>123123</Password>\r\n" + "</soap:Authenticate>\r\n" + "<soap:SetNamespace>\r\n"
				+ "<Namespace>SAM auction.id</Namespace>\r\n" + "</soap:SetNamespace>\r\n" + "</soapenv:Header>\r\n"
				+ "<soapenv:Body>\r\n" + "<soap:CreateAuction>\r\n" + "<AuctionType>T</AuctionType>\r\n" + " <Data>\r\n"
				+ "<Name>" + str_auctionname + "</Name>\r\n" + "<Timezone>UTC</Timezone>\r\n"
				+ "<StartClosingDate>2022-11-11 11:11:11</StartClosingDate>\r\n" 
				+ " <PublishDate>2022-04-11 11:11:11</PublishDate>\r\n"
				+ "<StartBiddingDate>2022-04-11 11:11:11</StartBiddingDate>\r\n"
				+ "<StartRegisterDate>2022-04-11 11:11:11</StartRegisterDate>\r\n"
				+ "<CustomFieldInteger>rewr</CustomFieldInteger>\r\n"
				+ "<CustomFieldDecimal>ewrew</CustomFieldDecimal>\r\n"
				+ "</Data>\r\n"
				+ "</soap:CreateAuction>\r\n" + "</soapenv:Body>\r\n" + "</soapenv:Envelope>\r\n";

		System.out.println(POST_AUCTION);
		URL obj = new URL(configFileReader.getFrontApiUrl());
		HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		postConnection.setRequestMethod("POST");
		postConnection.setRequestProperty("Content-Type", "application/json");

		postConnection.setDoOutput(true);
		OutputStream os = postConnection.getOutputStream();
		os.write(POST_AUCTION.getBytes());
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
			str = response.substring(362, 366);

			System.out.println("Generated AuctionId :" + str);
		} else {
			System.out.println("POST NOT WORKED");
		}
		

		
		/***************** CREATE_AUCTION ***************/
		System.out.println("***********************CreateAuction***********************");
		String str_auctionname1 = Common.generateRandomChars(6);

		final String POST_AUCTION1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://qa3-6-auto.auctionserver.net/api/soap12\">\r\n"
				+ "<soapenv:Header>\r\n" + "<soap:Authenticate>\r\n" + "<Login>admin</Login>\r\n"
				+ "<Password>123123</Password>\r\n" + "</soap:Authenticate>\r\n" + "<soap:SetNamespace>\r\n"
				+ "<Namespace>SAM auction.id</Namespace>\r\n" + "</soap:SetNamespace>\r\n" + "</soapenv:Header>\r\n"
				+ "<soapenv:Body>\r\n" + "<soap:CreateAuction>\r\n" + "<AuctionType>T</AuctionType>\r\n" + " <Data>\r\n"
				+ "<Name>" + str_auctionname1 + "</Name>\r\n" + "<Timezone>UTC</Timezone>\r\n"
				+ "<StartClosingDate>2022-11-11 11:11:11</StartClosingDate>\r\n" 
				+ " <PublishDate>2022-04-11 11:11:11</PublishDate>\r\n"
				+ "<StartBiddingDate>2022-04-11 11:11:11</StartBiddingDate>\r\n"
				+ "<StartRegisterDate>2022-04-11 11:11:11</StartRegisterDate>\r\n" 
				+ "</Data>\r\n"
				+ "</soap:CreateAuction>\r\n" + "</soapenv:Body>\r\n" + "</soapenv:Envelope>\r\n";

		System.out.println(POST_AUCTION1);
		URL obj1 = new URL(configFileReader.getFrontApiUrl());
		HttpURLConnection postConnection1 = (HttpURLConnection) obj1.openConnection();
		postConnection1.setRequestMethod("POST");
		postConnection1.setRequestProperty("Content-Type", "application/json");

		postConnection1.setDoOutput(true);
		OutputStream os1 = postConnection1.getOutputStream();
		os1.write(POST_AUCTION1.getBytes());
		os1.flush();
		os1.close();

		int responseCode1 = postConnection1.getResponseCode();
		System.out.println("POST Response Code :  " + responseCode1);
		System.out.println("POST Response Message : " + postConnection1.getResponseMessage());
		System.out.println("POST Requested Method : " + postConnection1.getRequestMethod());

		String str1 = null;
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
			str1 = response.substring(362, 366);

			System.out.println("Generated AuctionId :" + str1);
		} else {
			System.out.println("POST NOT WORKED");
		}
		
		
		/***************** UPDATE_AUCTION ***************/
		System.out.println("***********************Update Auction***********************");
		//String integer = Common.generateRandomChars(6);
		//String decimal = Common.generateRandomChars(6);

		final String POST_UPDATEAUCTION = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://qa3-6-auto.auctionserver.net/api/soap12\">\r\n"
				+ " <soapenv:Header>\r\n" + " <soap:Authenticate>\r\n" + " <Login>admin</Login>\r\n"
				+ " <Password>123123</Password>\r\n" + "</soap:Authenticate>\r\n"
				+ " <soap:SetNamespace>\r\n" + " <Namespace>SAM auction.id</Namespace>\r\n"
				+ " </soap:SetNamespace>\r\n" + " </soapenv:Header>\r\n" + " <soapenv:Body>\r\n"
				+ " <soap:UpdateAuction>\r\n" 
				+ " <Id>" + str1 +"</Id>\r\n"
				+ " <Data>\r\n"               
				+ " <CustomFieldInteger>dssdsf</CustomFieldInteger>\r\n"
				+ " <CustomFieldDecimal>fewr</CustomFieldDecimal>\r\n"
				+ " </Data>\r\n" + " </soap:UpdateAuction>\r\n" + "</soapenv:Body>\r\n"
				+ " </soapenv:Envelope>";	
		
		System.out.println(POST_UPDATEAUCTION);
		URL obj2 = new URL(configFileReader.getFrontApiUrl());
		System.out.println(configFileReader.getFrontApiUrl());
		HttpURLConnection postConnection2 = (HttpURLConnection) obj2.openConnection();
		postConnection2.setRequestMethod("POST");
		postConnection2.setRequestProperty("Login", "admin");
		postConnection2.setRequestProperty("Password", "123123");
		postConnection2.setRequestProperty("Namespace", "SAM lot_item.id");
		postConnection2.setRequestProperty("Content-Type", "application/json");

		postConnection2.setDoOutput(true);
		OutputStream os2 = postConnection2.getOutputStream();
		os2.write(POST_UPDATEAUCTION.getBytes());
		os2.flush();
		os2.close();

		int responseCode2 = postConnection2.getResponseCode();
		System.out.println("POST Response Code :  " + responseCode2);
		System.out.println("POST Response Message : " + postConnection2.getResponseMessage());
		System.out.println("POST Requested Method : " + postConnection2.getRequestMethod());

		
		String str2 = null; 
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
	        String str21 = response.substring(225, 251);
	        
	        System.out.println("Updated Auction" +str21);
		} else {
			System.out.println("POST NOT WORKED FOR UPDATE AUCTION");
		}
		

	}

}
