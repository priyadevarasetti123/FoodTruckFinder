package com.org.soda.foodtruck;

class Connector {
	
	public static void foodTruckData(String data) {
		
		try {
			final String CURRENT_TIME = TimeStampValidator.getCurrentTime();
			final String CURRENT_DAY = TimeStampValidator.getCurrentDay();
			
			OpenFoodTrucks.getCurrentTrucks(data, CURRENT_TIME, CURRENT_DAY); 
		} catch (Exception e) {
			System.out.println("Error validationg time");
			System.out.println(e.getMessage());
		}
	}
}
