//package Final;

import java.util.Scanner;
import java. util. Arrays;

public class RecursionQuestion {
public static int helperSearch(Car[] cars, Car c, int low, int high) {
boolean unfound = false;
int mid = low + (high - low) / 2;

if(mid>high) System.out.println("s=" + low + ", e=" + high);

else System.out.println("s=" + low + ", e=" + high + ", mid=" + mid);

if (high >= low && !unfound) {
if (cars[mid].compareTo(c) == 1) {
System.out.println("go left");
return helperSearch(cars, c, low, mid - 1);
}
else if (cars[mid].compareTo(c) == -1) {
System.out.println("go right");
return helperSearch(cars, c, mid + 1, high);
}
else {
System.out.println("FOUND at " + mid);
System.out.println();
System.out.println();
return mid;
}
}
else {
System.out.println("Not Found");
unfound = true;
}
return -1;
}
public static int binarySearch(Car[] cars, Car c) {
Arrays.sort(cars);
System.out.println("Looking for "+c.toString()+"\n");
return helperSearch(cars, c, 0, cars.length - 1);
}

public static void main(String[] args) {
	Car [] cars = new Car[10];
	int [][] seatConfigurations = {new int[]{2,2}, new int[]{2,3}, 
			new int[]{2,2,3}, new int[]{2,3,3}, new int[]{2,3,4}, new int[]{2,4,3}, 
			new int[]{2,3,5}, new int[]{2,4,4}, new int[]{2,4,5}, new int[]{3,4,5}};
	for(int i=0; i<cars.length; i++){
		cars[i] = new Car(2, 4, seatConfigurations[i]);
	}
	Scanner kb = new Scanner(System.in);
	//System.out.print("enter seat info");   //uncomment only when testing on your local system
	String [] input = kb.nextLine().split(" ");
	int [] rowSeats = new int[input.length];
	for(int i=0; i<input.length; i++){
		rowSeats[i] = Integer.parseInt(input[i]);
	}

}

}










