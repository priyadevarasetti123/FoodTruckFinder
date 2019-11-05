# FoodTruckFinder
This maven project retrieves the name and address of food trucks list that are open at the current time. It uses the Sanfrancisco government API(SOCRATA) to get the json data for the trucks.

Prerequisities:
1. Java 1.8 or above
2. Maven 3.1 or above

Dependencies:
<dependency>
  <groupId>org.json</groupId>
  <artifactId>json</artifactId>
  <version>20171018</version>
</dependency>

Plugin:
maven-assembly-plugin

Steps to run:
Linux/Bash/Mac OS:
./socrata.sh

Windows:
In the root folder..execute the below steps
1. mvn clean install package
2. mvn install assembly:assembly
3. Once the jar file is generated in the target folder
java -cp target\com.org.soda.foodtruck-1.0.0-jar-with-dependencies.jar com.org.soda.foodtruck.FoodTruckFinder

Alternatively, you can execute the jar file with third party tools like JexePack.

Also, you can import the maven project into IDE like eclipse or Netbeans.

Further Improvements:
Connect the backend application with a front end framework.
It can also be made more of user interactive application by letting the user choose the options rather than just showing the open trucks.
