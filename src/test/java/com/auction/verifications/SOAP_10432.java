package com.auction.verifications;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Handler;

import javax.xml.ws.soap.SOAPFaultException;

import org.apache.xmlbeans.impl.soap.SOAPFault;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.reader.StreamReader;

import com.auction.init.Common;
import com.auction.init.ConfigFileReader;

public class SOAP_10432 {
	
	static ConfigFileReader configFileReader = new ConfigFileReader();

	@Test
	public static void Verify_validation_for_Allow_buyer_select_quantity_Create_and_Update_AuctionLot_SOAP_request() throws IOException {
		
		/***************** dev ***************/
		
		/***************** CREATE_AUCTION ***************/
		System.out.println("***********************CreateAuction***********************");
		String str_auctionname = Common.generateRandomChars(6);

		final String POST_AUCTION1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://dev.auctionserver.net/api/soap12\">\r\n"
				+ "<soapenv:Header>\r\n" + "<soap:Authenticate>\r\n" + "<Login>admin</Login>\r\n"
				+ "<Password>123123</Password>\r\n" + "</soap:Authenticate>\r\n" + "<soap:SetNamespace>\r\n"
				+ "<Namespace>SAM auction.id</Namespace>\r\n" + "</soap:SetNamespace>\r\n" + "</soapenv:Header>\r\n"
				+ "<soapenv:Body>\r\n" + "<soap:CreateAuction>\r\n" + "<AuctionType>T</AuctionType>\r\n" + " <Data>\r\n"
				+ "<Name>" + str_auctionname + "</Name>\r\n" + "<Timezone>UTC</Timezone>\r\n"
				+ "<StartClosingDate>2022-11-11 11:11:11</StartClosingDate>\r\n" + "<Reverse>Y</Reverse>\r\n"
				+ " <PublishDate>2022-04-11 11:11:11</PublishDate>\r\n"
				+ "<StartBiddingDate>2022-04-11 11:11:11</StartBiddingDate>\r\n"
				+ "<StartRegisterDate>2022-04-11 11:11:11</StartRegisterDate>\r\n" + "</Data>\r\n"
				+ "</soap:CreateAuction>\r\n" + "</soapenv:Body>\r\n" + "</soapenv:Envelope>\r\n";

		System.out.println(POST_AUCTION1);
		URL obj = new URL(configFileReader.getdevUrl() + "api/soap12");
		HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		postConnection.setRequestMethod("POST");
		postConnection.setRequestProperty("Content-Type", "application/json");

		postConnection.setDoOutput(true);
		OutputStream os = postConnection.getOutputStream();
		os.write(POST_AUCTION1.getBytes());
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
			str = response.substring(355, 360);

			System.out.println("Generated AuctionId :" + str);
		} else {
			System.out.println("POST NOT WORKED");
		}
		

		/***************** Create_AUCTION_LOT ***************/
		System.out.println("***********************CreateAuctionLot***********************");
		
		final String POST_AUCLOT = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://dev.auctionserver.net/api/soap12\">\r\n"
				+ "<soapenv:Header>\r\n" + "<soap:Authenticate>\r\n" + "<Login>admin</Login>\r\n"
				+ "<Password>123123</Password>\r\n" + "</soap:Authenticate>\r\n" + "<soap:SetNamespace>\r\n"
				+ "<Namespace>SAM auction_lot_item.id</Namespace>\r\n" + "</soap:SetNamespace>\r\n"
				+ "</soapenv:Header>\r\n" + "<soapenv:Body>\r\n" + "<soap:CreateAuctionLot>\r\n" + "<AuctionId>" + str
				+ "</AuctionId>\r\n" + " <LotItemId>23314</LotItemId>\r\n" + "<Data>\r\n"
				+ "<LotStatus>Active</LotStatus>\r\n" + "<StartClosingDate>2022-11-11 11:11:11</StartClosingDate>\r\n"																																																																
				+ "</Data>\r\n"
				+ "</soap:CreateAuctionLot>\r\n" + "  </soapenv:Body>\r\n" + "</soapenv:Envelope>";
		

		System.out.println(POST_AUCLOT);
		URL obj1 = new URL(configFileReader.getdevUrl() + "api/soap12");
		HttpURLConnection postConnection1 = (HttpURLConnection) obj1.openConnection();
		postConnection1.setRequestMethod("POST");
		postConnection1.setRequestProperty("Content-Type", "application/json");

		postConnection1.setDoOutput(true);
		OutputStream os1 = postConnection1.getOutputStream();
		os1.write(POST_AUCLOT.getBytes());
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
			str1 = response.substring(358, 364);

			System.out.println("Generated AuctionLotId :" + str1);
		} else {
			System.out.println("POST NOT WORKED");
		}
		

		
		/***************** UPDATE_AUCTION_LOT ***************/
		System.out.println("***********************Update Auction Lot***********************");
	 
		final String POST_UAUCLOT = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://dev.auctionserver.net/api/soap12\">\r\n"
				+ "<soapenv:Header>\r\n" + "<soap:Authenticate>\r\n" + "<Login>admin</Login>\r\n"
				+ "<Password>123123</Password>\r\n" + "</soap:Authenticate>\r\n"
				+ "<soap:SetNamespace>\r\n" + "<Namespace>SAM auction_lot_item.id</Namespace>\r\n"
				+ "</soap:SetNamespace>\r\n" + "</soapenv:Header>\r\n" + "<soapenv:Body>\r\n"
				+ "<soap:UpdateAuctionLot>\r\n" + "<Id> " + str1 +" </Id>\r\n" + "<Data>\r\n"
				+  "<LotStatus>Active</LotStatus>\r\n" + "<Quantity>66</Quantity>\r\n" + "<QuantityXMoney>Y</QuantityXMoney>\r\n"
				+ " <BuyNowSelectQuantityEnabled>Y</BuyNowSelectQuantityEnabled>\r\n" + "<BuyNowAmount>2000</BuyNowAmount>\r\n"
				+ "</Data>\r\n" + " </soap:UpdateAuctionLot>\r\n" + "</soapenv:Body>\r\n"
				+ "</soapenv:Envelope>"; 
		
		System.out.println(POST_UAUCLOT);
		URL obj111 = new URL(configFileReader.getdevUrl()+"api/soap12");
		HttpURLConnection postConnection11 = (HttpURLConnection) obj111.openConnection();
		postConnection11.setRequestMethod("POST");
		postConnection11.setRequestProperty("Login", "admin");
		postConnection11.setRequestProperty("Password", "123123");
		postConnection11.setRequestProperty("Namespace", "SAM auction_lot_item.id");
		postConnection11.setRequestProperty("Content-Type", "application/json");
	
		postConnection11.setDoOutput(true);
		OutputStream os11 = postConnection11.getOutputStream();
		os11.write(POST_UAUCLOT.getBytes());
		os11.flush();
		os11.close();
	
		int responseCode11 = postConnection11.getResponseCode();
		System.out.println("POST Response Code :  " + responseCode11);
		System.out.println("POST Response Message : " + postConnection11.getResponseMessage());
		System.out.println("POST Requested Method : " + postConnection11.getRequestMethod());
		
	
		/***************** Create_AUCTION_LOT ***************/
		System.out.println("***********************CreateAuctionLot***********************");
		
		final String POST_AUCLOT1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://dev.auctionserver.net/api/soap12\">\r\n"
				+ "<soapenv:Header>\r\n" + "<soap:Authenticate>\r\n" + "<Login>admin</Login>\r\n"
				+ "<Password>123123</Password>\r\n" + "</soap:Authenticate>\r\n" + "<soap:SetNamespace>\r\n"
				+ "<Namespace>SAM auction_lot_item.id</Namespace>\r\n" + "</soap:SetNamespace>\r\n"
				+ "</soapenv:Header>\r\n" + "<soapenv:Body>\r\n" + "<soap:CreateAuctionLot>\r\n" + "<AuctionId>" + str
				+ "</AuctionId>\r\n" + " <LotItemId>23316</LotItemId>\r\n" + "<Data>\r\n" + "<StartClosingDate>2022-11-11 11:11:11</StartClosingDate>\r\n"
				+ "<LotStatus>Active</LotStatus>\r\n" + "<Quantity>66</Quantity>\r\n" + "<QuantityXMoney>Y</QuantityXMoney>\r\n"
				+ " <BuyNowSelectQuantityEnabled>Y</BuyNowSelectQuantityEnabled>\r\n" + "<BuyNowAmount>2000</BuyNowAmount>\r\n" + "</Data>\r\n"
				+ " </soap:CreateAuctionLot>\r\n" + "</soapenv:Body>\r\n" + "</soapenv:Envelope>";
		
		System.out.println(POST_AUCLOT1);
		URL obj11 = new URL(configFileReader.getdevUrl() + "api/soap12");
		HttpURLConnection postConnection111 = (HttpURLConnection) obj11.openConnection();
		postConnection111.setRequestMethod("POST");
		postConnection111.setRequestProperty("Content-Type", "application/json");

		postConnection111.setDoOutput(true);
		OutputStream os111 = postConnection111.getOutputStream();
		os111.write(POST_AUCLOT1.getBytes());
		os111.flush();
		os111.close();

		int responseCode111 = postConnection111.getResponseCode();
		System.out.println("POST Response Code :  " + responseCode111);
		System.out.println("POST Response Message : " + postConnection111.getResponseMessage());
		System.out.println("POST Requested Method : " + postConnection111.getRequestMethod());

		
		/***************** qa3-6-auto ***************/
		
		/***************** CREATE_AUCTION ***************/
		System.out.println("***********************CreateAuction***********************");
		String str_auctionname1 = Common.generateRandomChars(6);

		final String POST_AUCTION2 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://qa3-6-auto.auctionserver.net/api/soap12\">\r\n"
				+ "<soapenv:Header>\r\n" + "<soap:Authenticate>\r\n" + "<Login>admin</Login>\r\n"
				+ "<Password>123123</Password>\r\n" + "</soap:Authenticate>\r\n" + "<soap:SetNamespace>\r\n"
				+ "<Namespace>SAM auction.id</Namespace>\r\n" + "</soap:SetNamespace>\r\n" + "</soapenv:Header>\r\n"
				+ "<soapenv:Body>\r\n" + "<soap:CreateAuction>\r\n" + "<AuctionType>T</AuctionType>\r\n" + " <Data>\r\n"
				+ "<Name>" + str_auctionname1 + "</Name>\r\n" + "<Timezone>UTC</Timezone>\r\n"
				+ "<StartClosingDate>2022-11-11 11:11:11</StartClosingDate>\r\n" + "<Reverse>Y</Reverse>\r\n"
				+ " <PublishDate>2022-04-11 11:11:11</PublishDate>\r\n"
				+ "<StartBiddingDate>2022-04-11 11:11:11</StartBiddingDate>\r\n"
				+ "<StartRegisterDate>2022-04-11 11:11:11</StartRegisterDate>\r\n" + "</Data>\r\n"
				+ "</soap:CreateAuction>\r\n" + "</soapenv:Body>\r\n" + "</soapenv:Envelope>\r\n";

		System.out.println(POST_AUCTION2);
		URL obj2 = new URL(configFileReader.getFrontApiUrl());
		HttpURLConnection postConnection2 = (HttpURLConnection) obj2.openConnection();
		postConnection2.setRequestMethod("POST");
		postConnection2.setRequestProperty("Content-Type", "application/json");

		postConnection2.setDoOutput(true);
		OutputStream os2 = postConnection2.getOutputStream();
		os2.write(POST_AUCTION2.getBytes());
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
			str2 = response.substring(362, 366);

			System.out.println("Generated AuctionId :" + str2);
		} else {
			System.out.println("POST NOT WORKED");
		}
		

		/***************** Create_AUCTION_LOT ***************/
		System.out.println("***********************CreateAuctionLot***********************");
		
		final String POST_AUCLOT2 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://qa3-6-auto.auctionserver.net/api/soap12\">\r\n"
				+ "<soapenv:Header>\r\n" + "<soap:Authenticate>\r\n" + "<Login>admin</Login>\r\n"
				+ "<Password>123123</Password>\r\n" + "</soap:Authenticate>\r\n" + "<soap:SetNamespace>\r\n"
				+ "<Namespace>SAM auction_lot_item.id</Namespace>\r\n" + "</soap:SetNamespace>\r\n"
				+ "</soapenv:Header>\r\n" + "<soapenv:Body>\r\n" + "<soap:CreateAuctionLot>\r\n" + "<AuctionId>" + str2
				+ "</AuctionId>\r\n" + " <LotItemId>"+3656+"</LotItemId>\r\n" + "<Data>\r\n"
				+ "<LotStatus>Active</LotStatus>\r\n" + "<Quantity>66</Quantity>\r\n" + "<QuantityXMoney>Y</QuantityXMoney>\r\n"
				+ "<StartClosingDate>2022-11-11 11:11:11</StartClosingDate>\r\n" + "</Data>\r\n"
				+ "</soap:CreateAuctionLot>\r\n" + "  </soapenv:Body>\r\n" + "</soapenv:Envelope>";
		

		System.out.println(POST_AUCLOT2);
		URL obj3 = new URL(configFileReader.getFrontApiUrl());
		HttpURLConnection postConnection3 = (HttpURLConnection) obj3.openConnection();
		postConnection3.setRequestMethod("POST");
		postConnection3.setRequestProperty("Content-Type", "application/json");

		postConnection3.setDoOutput(true);
		OutputStream os3 = postConnection3.getOutputStream();
		os3.write(POST_AUCLOT2.getBytes());
		os3.flush();
		os3.close();

		int responseCode3 = postConnection3.getResponseCode();
		System.out.println("POST Response Code :  " + responseCode3);
		System.out.println("POST Response Message : " + postConnection3.getResponseMessage());
		System.out.println("POST Requested Method : " + postConnection3.getRequestMethod());

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
			str3 = response.substring(365, 369);

			System.out.println("Generated AuctionId :" + str3);
		} else {
			System.out.println("POST NOT WORKED");
		}
		

		
		/***************** UPDATE_AUCTION_LOT ***************/
		System.out.println("***********************Update Auction Lot***********************");
	 
		final String POST_UAUCLOT1 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://qa3-6-auto.auctionserver.net/api/soap12\">\r\n"
				+ "<soapenv:Header>\r\n" + "<soap:Authenticate>\r\n" + "<Login>admin</Login>\r\n"
				+ "<Password>123123</Password>\r\n" + "</soap:Authenticate>\r\n"
				+ "<soap:SetNamespace>\r\n" + "<Namespace>SAM auction_lot_item.id</Namespace>\r\n"
				+ "</soap:SetNamespace>\r\n" + "</soapenv:Header>\r\n" + "<soapenv:Body>\r\n"
				+ "<soap:UpdateAuctionLot>\r\n" + "<Id> " + str3 +" </Id>\r\n" + "<Data>\r\n"
				+  "<LotStatus>Active</LotStatus>\r\n" + "<Quantity>66</Quantity>\r\n" + "<QuantityXMoney>Y</QuantityXMoney>\r\n"
				+ " <BuyNowSelectQuantityEnabled>Y</BuyNowSelectQuantityEnabled>\r\n" + "  <BuyNowAmount>2000</BuyNowAmount>\r\n"
				+ "</Data>\r\n" + " </soap:UpdateAuctionLot>\r\n" + "</soapenv:Body>\r\n"
				+ "</soapenv:Envelope>"; 
		
		System.out.println(POST_UAUCLOT1);
		URL obj4 = new URL(configFileReader.getFrontApiUrl());
		HttpURLConnection postConnection4 = (HttpURLConnection) obj4.openConnection();
		postConnection4.setRequestMethod("POST");
		postConnection4.setRequestProperty("Login", "admin");
		postConnection4.setRequestProperty("Password", "123123");
		postConnection4.setRequestProperty("Namespace", "SAM auction_lot_item.id");
		postConnection4.setRequestProperty("Content-Type", "application/json");
	
		postConnection4.setDoOutput(true);
		OutputStream os4 = postConnection4.getOutputStream();
		os4.write(POST_UAUCLOT1.getBytes());
		os4.flush();
		os4.close();
	
		int responseCode4 = postConnection4.getResponseCode();
		System.out.println("POST Response Code :  " + responseCode4);
		System.out.println("POST Response Message : " + postConnection4.getResponseMessage());
		System.out.println("POST Requested Method : " + postConnection4.getRequestMethod());
		
	
		/***************** Create_AUCTION_LOT ***************/
		System.out.println("***********************CreateAuctionLot***********************");
		
		final String POST_AUCLOT3 = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://qa3-6-auto.auctionserver.net/api/soap12\">\r\n"
				+ "<soapenv:Header>\r\n" + "<soap:Authenticate>\r\n" + "<Login>admin</Login>\r\n"
				+ "<Password>123123</Password>\r\n" + "</soap:Authenticate>\r\n" + "<soap:SetNamespace>\r\n"
				+ "<Namespace>SAM auction_lot_item.id</Namespace>\r\n" + "</soap:SetNamespace>\r\n"
				+ "</soapenv:Header>\r\n" + "<soapenv:Body>\r\n" + "<soap:CreateAuctionLot>\r\n" + "<AuctionId>" + str2
				+ "</AuctionId>\r\n" + " <LotItemId>"+3657+"</LotItemId>\r\n" + "<Data>\r\n"
				+ "<LotStatus>Active</LotStatus>\r\n" + "<StartClosingDate>2022-11-11 11:11:11</StartClosingDate>\r\n" + "<Quantity>66</Quantity>\r\n" + "<QuantityXMoney>Y</QuantityXMoney>\r\n"
				+ " <BuyNowSelectQuantityEnabled>Y</BuyNowSelectQuantityEnabled>\r\n" + "<BuyNowAmount>2000</BuyNowAmount>\r\n"+ "</Data>\r\n"
				+ " </soap:CreateAuctionLot>\r\n" + "  </soapenv:Body>\r\n" + "</soapenv:Envelope>";
		
		System.out.println(POST_AUCLOT3);
		URL obj6 = new URL(configFileReader.getFrontApiUrl());
		HttpURLConnection postConnection6 = (HttpURLConnection) obj6.openConnection();
		postConnection6.setRequestMethod("POST");
		postConnection6.setRequestProperty("Content-Type", "application/json");

		postConnection6.setDoOutput(true);
		OutputStream os6 = postConnection6.getOutputStream();
		os6.write(POST_AUCLOT3.getBytes());
		os6.flush();
		os6.close();

		int responseCode6 = postConnection6.getResponseCode();
		System.out.println("POST Response Code :  " + responseCode6);
		System.out.println("POST Response Message : " + postConnection6.getResponseMessage());
		System.out.println("POST Requested Method : " + postConnection6.getRequestMethod());

		
		}
		}
	
	
