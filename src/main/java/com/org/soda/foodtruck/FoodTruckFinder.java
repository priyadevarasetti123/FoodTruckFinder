package com.org.soda.foodtruck;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FoodTruckFinder {

	public static void main(String[] args) {
		StringBuilder result = new StringBuilder();
		
   		try {
			URL url = new URL("http://data.sfgov.org/resource/bbb8-hzi6.json");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			rd.close();	
			
			Connector.foodTruckData(result.toString());
   		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
