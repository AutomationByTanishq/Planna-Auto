package com.auction.init;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath= "Config//Configurations.properties";
	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getFrontUrl() {
		String url = properties.getProperty("frontURL");
		if(url != null) return url;
		else throw new RuntimeException("front url not specified in the Configuration.properties file.");
	}
	
	public String getAdminUrl() {
		String url = properties.getProperty("adminURL");
		if(url != null) return url;
		else throw new RuntimeException("admin url not specified in the Configuration.properties file.");
	}
	
	public String getdev3_4Url() {
		String url = properties.getProperty("dev3_4front");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getdevUrl() {
		String url = properties.getProperty("devfront");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	public String getqa3_5adminUrl() {
		String url = properties.getProperty("qa3_5admin");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	
	public String getFrontApiUrl() {
		String url = properties.getProperty("frontapiURL");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public String getdev_auctionUrl() {
		String url = properties.getProperty("devauction");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public String settlement_Url() {
		String url = properties.getProperty("my-settlements");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public String getqa_dev_autofrontendUrl() {
		String url = properties.getProperty("qa_dev_autofrontend");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public String getqa_dev_autoadminUrl() {
		String url = properties.getProperty("qa_dev_autoadmin");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public String getdev_main() {
		String url = properties.getProperty("dev_main");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public String getqa_MainAutoAdmin() {
		String url = properties.getProperty("qaMainAutoAdmin");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public String getqa_MainAutoFront() {
		String url = properties.getProperty("qaMainAutoFront");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	
	
}
