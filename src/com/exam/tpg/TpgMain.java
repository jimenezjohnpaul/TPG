package com.exam.tpg;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TpgMain {

	private static Properties prop = null;

	public static Properties getProp() {
		return prop;
	}

	public static void setProp(Properties prop) {
		TpgMain.prop = prop;
	}

	public TpgMain() {
		
		setProp(loadProperties());
		
		IPValidationRegex.validate();
		
		StudentInformation.sort();;
		
	}
	
	private static Properties loadProperties(){
		
		Properties prop = new Properties();
		
		InputStream input = null;
		
		try{
			
			input = IPValidationRegex.class.getResourceAsStream("/resources/config.properties");
			
			prop.load(input);
			
		} catch (IOException e){
			
			e.printStackTrace();
			
		} finally {
			
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		return prop;
		
	}
	
	public static void main(String[] args) {
		
		new TpgMain();
		
	}
	
}
