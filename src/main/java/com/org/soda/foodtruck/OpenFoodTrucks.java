package com.org.soda.foodtruck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

class OpenFoodTrucks {
	
	//Create a Scanner instance to scan the user input
	static Scanner scan = new Scanner(System.in);
	
	
	/* This method gets the sorted list of trucks and calls the printOpenTrucks method
	 *  by passing the sorted trucks list
	 */
	public static void getCurrentTrucks(String truckData, String currentTime, String currentDay) {	
		//Create JSON array to store the truck data
		JSONArray jsonArray = new JSONArray(truckData);
		ArrayList<String> sortedTruckList = new ArrayList<String>();
		
		sortedTruckList = sortOpenTrucks(jsonArray, currentTime, currentDay);
		
		printOpenTrucks(sortedTruckList);
	}
	
	
	/* This method converts the required JSON objects to strings, gets the open trucks
	 * and returns the sorted list of trucks
	 */
	public static ArrayList<String> sortOpenTrucks(JSONArray jsonArray, String currentTime, String currentDay) {		
		JSONObject json;
		String start, end, day, truckInfo;
		
		ArrayList<String> truckList = new ArrayList<String>();
		
		System.out.printf("%-80s%s%n", "NAME", "ADDRESS");
		for (int i = 0; i < jsonArray.length(); i++){
			json = jsonArray.getJSONObject(i);
				
			//Convert the JSON objects to strings
			start = (json.get("start24")).toString();
			end = (json.get("end24")).toString();
			day = (json.get("dayofweekstr")).toString();				
			
			if( validTrucks(currentTime, start, end, day, currentDay)) {
				truckInfo = String.format("%-80s%s", json.get("applicant").toString() , json.get("location").toString());
				truckList.add(truckInfo);
			}
		}
		//use the sort method of Collections to sort the list of trucks
		Collections.sort(truckList);
		return truckList;
	}
	
	
	// This method checks if a truck is open at current time and current day
	public static boolean validTrucks(String currentTime, String start, String end, String day, String currentDay) {	
		return (TimeStampValidator.isTimeValid(currentTime, start, end) && currentDay.equals(day));
	}
	
	
	/* This method prints the name and location of 10 open trucks, then waits for the input
	 * from user and prints the next 10 and so on.
	 */
	public static void printOpenTrucks(ArrayList<String> sortedTrucks) {
		int count = 10;
		
		//Calculate the total number of trucks
		int numberOfTrucks = sortedTrucks.size();
		
		for(int i = 0; i < count && i < numberOfTrucks; i++)
		{
			System.out.println(sortedTrucks.get(i));
			
			if(checkThresholdLimit(i, count, numberOfTrucks))
			{
				Boolean value = scanUserInput();
				if(value)
				count = count+10;
			}
		}
		//close the scanner after use
		scan.close();
	}
	
	
	public static boolean checkThresholdLimit(int i, int count, int numberOfTrucks) {
		return ((i == count-1) && (numberOfTrucks > count));
	}
	
	
	// This method scans the user input to check if the user would like to see more trucks or not
	public static boolean scanUserInput() {
		System.out.println("Would you like to see more?");
		System.out.println("Type yes or y to continue");
		String userInput = scan.next();	
		
		if(userInput.toLowerCase().equals("yes") || userInput.toLowerCase().equals("y")) {
			return true;
		}
		else {
			System.out.println("All right! Thank you..!!!");
			return false;
			//System.exit(0);
		}	
	}	
}
