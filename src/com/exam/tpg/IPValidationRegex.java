package com.exam.tpg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPValidationRegex {
	
	public IPValidationRegex() {
		// TODO Auto-generated constructor stub
	}
	
	public static void validate(){
	
		startTime = System.currentTimeMillis();
		
		System.out.println("\n********** IPValidationRegex **********\n");
		
		BufferedReader br = null;
		
		Pattern pattern = Pattern.compile(TpgMain.getProp().getProperty(IP_ADDRESS));
		Matcher matcher;

		try {
			//read file from the same package
			br = new BufferedReader(new InputStreamReader(IPValidationRegex.class.getResourceAsStream(TpgMain.getProp().getProperty(TEST_DATA)), "UTF-8"));

			String sCurrentLine;
			
			System.out.println("Invalid IP Address\n");

			while ((sCurrentLine = br.readLine()) != null) {
				matcher = pattern.matcher(sCurrentLine);
		    	if (!matcher.matches()){
		    		System.out.println(sCurrentLine);
		    	}
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}
		
		endTime = System.currentTimeMillis();
		
		elapseTime = endTime - startTime;
		
		System.out.println("\nElapse Time:\t" + elapseTime + " Milliseconds\n");
		System.out.println("*****************************************");
		
	}
	
	private static final String IP_ADDRESS = "IP_ADDRESS_PATTERN";
	private static final String TEST_DATA = "TEST_DATA_IP_ADDRESS";
	
	private static long startTime;
	private static long endTime;
	private static long elapseTime;
	
}
