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

public class SOAP_3578_Dev {
	static ConfigFileReader configFileReader= new ConfigFileReader();

	@Test
	public static void Verify_Create_and_Update_Item_and_Lot_with_Allowbuyerselectquantity_Access_via_SOAP_request_on_Dev() throws IOException {
		
		System.out.println("***********************Dev***********************");
		/***************** CREATE_ITEM ***************/
		System.out.println("***********************Create Item***********************");
		String str_itemname = Common.generateRandomChars(6);
		final String POST_CITEM = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://dev.auctionserver.net/api/soap12\">\r\n"
				+ "  <soapenv:Header>\r\n" + "<soap:Authenticate>\r\n" + "<Login>admin</Login>\r\n"
				+ "  <Password>123123</Password>\r\n" + "</soap:Authenticate>\r\n"
				+ "  <soap:SetNamespace>\r\n" + "<Namespace>SAM lot_item.id</Namespace>\r\n"
				+ "  </soap:SetNamespace>\r\n" + "</soapenv:Header>\r\n" + "<soapenv:Body>\r\n"
				+ "  <soap:CreateItem>\r\n" + "<Name>" + str_itemname + "</Name>\r\n" + "<Data>\r\n"
				+ "  <Quantity>200</Quantity>\r\n" + "   <QuantityXMoney>Y</QuantityXMoney>\r\n" 
				+ "  <BuyNowSelectQuantityEnabled>Y</BuyNowSelectQuantityEnabled>\r\n"
				+ "  </Data>\r\n" + "</soap:CreateItem>\r\n"
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
			+ "   <soapenv:Header>\r\n" + "<soap:Authenticate>\r\n" + "<Login>admin</Login>\r\n"
			+ "   c<Password>123123</Password>\r\n" + "</soap:Authenticate>\r\n"
			+ "   <soap:SetNamespace>\r\n" + "<Namespace>SAM lot_item.id</Namespace>\r\n"
			+ "   </soap:SetNamespace>\r\n" + "</soapenv:Header>\r\n" + "<soapenv:Body>\r\n"
			+ "   <soap:updateItem>\r\n" + "<Id>" + str + "</Id>\r\n" + "<Data>\r\n"
			+ "   <Quantity>300</Quantity>\r\n" + " <QuantityXMoney>Y</QuantityXMoney>\r\n"
			+ "   <BuyNowSelectQuantityEnabled>Y</BuyNowSelectQuantityEnabled>\r\n"
			+ "   </Data>\r\n" + "</soap:updateItem>\r\n" + "</soapenv:Body>\r\n"
			+ "   </soapenv:Envelope>";
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

	/***************** CREATE_AUCTION ***************/
	System.out.println("***********************Create Auction***********************");
	final String POST_AUCTION = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"https://dev.auctionserver.net/api/soap12\">\r\n"
			+ "    <soapenv:Header>\r\n" + "<soap:Authenticate>\r\n" + "<Login>admin</Login>\r\n"
			+ "    <Password>123123</Password>\r\n" + "</soap:Authenticate>\r\n"
			+ "    <soap:SetNamespace>\r\n" + "<Namespace>SAM auction.id</Namespace>\r\n"
			+ "    </soap:SetNamespace>\r\n" + "</soapenv:Header>\r\n" + "   <soapenv:Body>\r\n"
			+ "    <soap:CreateAuction>\r\n" + "<AuctionType>T</AuctionType>\r\n" + "<Data>\r\n"
			+ "    <Name>BuyNow Auction</Name>\r\n" + "<Timezone>UTC</Timezone>\r\n"
			+ "    <StartClosingDate>2022-12-11 11:11:11</StartClosingDate>\r\n"
			+ "    <StartBiddingDate> 2022-05-10 11:11:11 </StartBiddingDate>\r\n"
			+ "    <PublishDate>2022-03-11 11:11:11</PublishDate>\r\n"
			+ "    <StartRegisterDate>2022-03-11 11:11:11</StartRegisterDate>\r\n"
			+ "    </Data>\r\n" + "</soap:CreateAuction>\r\n" + "</soapenv:Body>\r\n"
			+ "    </soapenv:Envelope>";
	System.out.println(POST_AUCTION);
	URL obj2 = new URL(configFileReader.getdevUrl() + "api/soap12");
	HttpURLConnection postConnection2 = (HttpURLConnection) obj2.openConnection();
	postConnection2.setRequestMethod("POST");
	postConnection2.setRequestProperty("Login", "admin");
	postConnection2.setRequestProperty("Password", "123123");
	postConnection2.setRequestProperty("Namespace", "SAM lot_item.id");
	postConnection2.setRequestProperty("Content-Type", "application/json");

	postConnection2.setDoOutput(true);
	OutputStream os2 = postConnection2.getOutputStream();
	os2.write(POST_AUCTION.getBytes());
	os2.flush();
	os2.close();

	int responseCode2 = postConnection2.getResponseCode();
	System.out.println("POST Response Code :  " + responseCode2);
	System.out.println("POST Response Message : " + postConnection2.getResponseMessage());
	System.out.println("POST Requested Method : " + postConnection2.getRequestMethod());

	String str1 = null;
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
		str1 = response.substring(355, 360);

		System.out.println("Generated Auction name :" + str1);
	} else {
		System.out.println("POST NOT WORKED");
	}

	/***************** ADD_LOT ***************/
	System.out.println("***********************Add Lot***********************");
	//String str_lotname = Common.generateRandomChars(6);

	final String POST_LOT = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://dev.auctionserver.net/api/soap12?wsdl\">\r\n"
			+ "   <soapenv:Header>\r\n" + "<soap:Authenticate>\r\n" + "<Login>admin</Login>\r\n"
			+ "   <Password>123123</Password>\r\n" + "</soap:Authenticate>\r\n"
			+ "   <soap:SetNamespace>\r\n" + "<Namespace>SAM auction_lot_item.id</Namespace>\r\n"
			+ "   </soap:SetNamespace>\r\n" + "</soapenv:Header>\r\n" + "<soapenv:Body>\r\n"
			+ "   <soap:CreateAuctionLot>\r\n" + "<AuctionId>" + str1 + "</AuctionId>\r\n"
			+ "   <LotItemId>377301																											</LotItemId>\r\n"
			+ "   <Data>\r\n"
			+ "   <StartClosingDate>2022-12-11 11:11:11</StartClosingDate>\r\n"
			+ "   <LotStatus>Active</LotStatus>\r\n"                
			+ "   <Quantity>200</Quantity>\r\n" + " <QuantityXMoney>Y</QuantityXMoney>\r\n"
			+ "   <BuyNowSelectQuantityEnabled>Y</BuyNowSelectQuantityEnabled>\r\n"
			+ "   <BuyNowAmount>2000</BuyNowAmount>\r\n" 
			+ "   </Data>\r\n" + "</soap:CreateAuctionLot>\r\n" + "</soapenv:Body>\r\n"
			+ "    </soapenv:Envelope>";
	System.out.println(POST_LOT);
	URL obj3 = new URL(configFileReader.getdevUrl() + "api/soap12");
	HttpURLConnection postConnection3 = (HttpURLConnection) obj3.openConnection();
	postConnection3.setRequestMethod("POST");
	postConnection3.setRequestProperty("Login", "admin");
	postConnection3.setRequestProperty("Password", "123123");
	postConnection3.setRequestProperty("Namespace", "SAM lot_item.id");
	postConnection3.setRequestProperty("Content-Type", "application/json");

	postConnection3.setDoOutput(true);
	OutputStream os3 = postConnection3.getOutputStream();
	os3.write(POST_LOT.getBytes());
	os3.flush();
	os3.close();

	int responseCode3 = postConnection3.getResponseCode();
	System.out.println("POST Response Code :  " + responseCode3);
	System.out.println("POST Response Message : " + postConnection3.getResponseMessage());
	System.out.println("POST Requested Method : " + postConnection3.getRequestMethod());

	String strnew = null;
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
        strnew = response.substring(358, 364);
        
        System.out.println("Lot:" +strnew);
	} else {
		System.out.println("POST NOT WORKED FOR ADD LOT");
	}
	
	/***************** UPDATE_LOT ***************/
	System.out.println("***********************Update Lot***********************");

	final String POST_UPDATELOT = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:soap=\"http://dev.auctionserver.net/api/soap12?wsdl\">\r\n"
			+ "   <soapenv:Header>\r\n" + "<soap:Authenticate>\r\n" + "<Login>admin</Login>\r\n"
			+ "   <Password>123123</Password>\r\n" + "</soap:Authenticate>\r\n"
			+ "   <soap:SetNamespace>\r\n" + "<Namespace>SAM auction_lot_item.id</Namespace>\r\n"
			+ "   </soap:SetNamespace>\r\n" + "</soapenv:Header>\r\n" + "<soapenv:Body>\r\n"
			+ "   <soap:UpdateAuctionLot>\r\n" 
			+ "   <Id>" + strnew +"</Id>\r\n"
			+ "   <Data>\r\n"               
			+ "   <Quantity>300</Quantity>\r\n" + " <QuantityXMoney>Y</QuantityXMoney>\r\n"
			+ "   <BuyNowSelectQuantityEnabled>Y</BuyNowSelectQuantityEnabled>\r\n"
			+ "   <BuyNowAmount>2000</BuyNowAmount>\r\n" 
			+ "   </Data>\r\n" + "</soap:UpdateAuctionLot>\r\n" + "</soapenv:Body>\r\n"
			+ "   </soapenv:Envelope>";
	System.out.println(POST_UPDATELOT);
	URL obj4 = new URL(configFileReader.getdevUrl() + "api/soap12");
	HttpURLConnection postConnection4 = (HttpURLConnection) obj4.openConnection();
	postConnection4.setRequestMethod("POST");
	postConnection4.setRequestProperty("Login", "admin");
	postConnection4.setRequestProperty("Password", "123123");
	postConnection4.setRequestProperty("Namespace", "SAM lot_item.id");
	postConnection4.setRequestProperty("Content-Type", "application/json");

	postConnection4.setDoOutput(true);
	OutputStream os4 = postConnection4.getOutputStream();
	os4.write(POST_UPDATELOT.getBytes());
	os4.flush();
	os4.close();

	int responseCode4 = postConnection3.getResponseCode();
	System.out.println("POST Response Code :  " + responseCode4);
	System.out.println("POST Response Message : " + postConnection4.getResponseMessage());
	System.out.println("POST Requested Method : " + postConnection4.getRequestMethod());

	@SuppressWarnings("unused")
	String str4 = null; 
	if (responseCode4 == 200) { // success
		BufferedReader in = new BufferedReader(new InputStreamReader(postConnection4.getInputStream()));
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
	

