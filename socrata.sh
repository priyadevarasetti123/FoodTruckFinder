#!/bin/bash
mvn clean install package
mvn install assembly:assembly
java -cp target/com.org.soda.foodtruck-1.0.0-jar-with-dependencies.jar com.org.soda.foodtruck.FoodTruckFinder
