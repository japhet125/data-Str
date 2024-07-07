//package Final;

import java.util.Objects;

public class Car extends Vehicle implements Comparable<Car> , Announcements{
	   private int numDoors;
	   private int numWindows;
	  
	   public Car(int numDoors,int numWindows){
	       super(2,2);
	       this.numDoors=numDoors;
	       this.numWindows=numWindows;
	   }
	   public Car(int numDoors,int numWindows,int numSeatsPerRow){
	       super(2,numSeatsPerRow);
	       this.numDoors=numDoors;
	       this.numWindows=numWindows;      
	   }
	   public Car(int numDoors,int numWindows,int [] numSeatsPerRow){
	       super(numSeatsPerRow);
	       this.numDoors=numDoors;
	       this.numWindows=numWindows;
	   }
	   public Car(int numDoors,int numWindows,Person driver,int [] numSeatsPerRow){
	       super(driver,numSeatsPerRow);
	       this.numDoors=numDoors;
	       this.numWindows=numWindows;
	   }
	  
	   public boolean canOpenDoor(Person p){
	       if(this.numDoors>=2*super.numberOfRows){
	           Person p_=super.getPersonInSeat(0,super.getPeopleInRow(0).length-1);
	           if(p_!=null && p_.getAge()>5){
	               return true;
	           }
	       }      
	       return false;
	   }
	   public boolean canOpenWindow(Person p){
	       if(this.numWindows>=2*super.numberOfRows){
	           Person p_=super.getPersonInSeat(0,super.getPeopleInRow(0).length-1);
	           if(p_!=null && p_.getAge()>2){
	               return true;
	           }
	       }      
	       return false;
	   }
	  
	   public int getNumDoors() {
	       return numDoors;
	   }
	   public void setNumDoors(int numDoors) {
	       this.numDoors = numDoors;
	   }
	   public int getNumWindows() {
	       return numWindows;
	   }
	   public void setNumWindows(int numWindows) {
	       this.numWindows = numWindows;
	   }
	  
	   public boolean equals(Object o){

	if(o==null) return false;
	if(!(o instanceof Car)) return false;

	       Car c=(Car) o;
	       if(c.numWindows==this.numWindows && c.getNumDoors()==this.numDoors){
	           //////////////////
	           if(c.numberOfRows==this.numberOfRows && c.maxSeatsPerRow==this.maxSeatsPerRow){}{
	              
	 for(int i=0;i<c.numberOfRows;i++){
	 if(c.numSeatsPerRow[i]!=this.numSeatsPerRow[i]){
	                       return false;
	                   }
	               }
	               return true;
	           }          
	       }
	       return false;
	   }
	  



	public String toString() {
		
	String seatsPerRow = "[";
	if(numSeatsPerRow!=null){
	for (int i = 0; i < numberOfRows; i++) {
	seatsPerRow += Integer.toString(numSeatsPerRow[i]);
	if (i != numberOfRows - 1) {
	seatsPerRow += ",";
	}
	}
	}
seatsPerRow += "]";
	String names = "[";
	if(personsOnBoard!=null){
	for (int i = 0; i < numberOfRows; i++) {

	for (int j = 0; j < personsOnBoard[i].length; j++) {
	if(personsOnBoard[i][j]==null) continue;

	names += personsOnBoard[i][j].getName();
	names += ", ";

	}
	}}

	names+="]";

	return String.format("Car: number of doors = %02d | number of windows = %02d | number of rows = %02d | seats per row = %s | names of people on board = %s\n", numDoors, numWindows, numberOfRows, seatsPerRow, names);
	}  


	/* public int compareTo(Car c){
	       Person [][] pc=c.getPeopleOnBoard();
	       Person [][] pct=this.getPeopleOnBoard();
	      
	       int tSeat=0,tcSeat=0;
	      
	       for(int i=0;i<pc.length;i++){
	           tSeat+=pc[i].length;
	       }
	      
	       for(int j=0;j<pct.length;j++){
	           tcSeat+=pct[j].length;
	       }
	      
	       if(tSeat<tcSeat){
	           return -1;
	       }
	       else{
	           if(tSeat>tcSeat){
	               return 1;
	           }
	           else{
	               return 0;
	           }
	       }      
	   }
	  
	*/
	public int compareTo(Car car) {
	int numSeatsThis = 0;
	int numSeatsCar = 0;
	for (int i = 0; i < this.numberOfRows; i++) {
	numSeatsThis += this.getNumberOfAvailableSeatsInRow(i);
	}
	for (int i = 0; i < car.numberOfRows; i++) {
	numSeatsCar += car.getNumberOfAvailableSeatsInRow(i);
	}
	if (numSeatsThis < numSeatsCar) {
	return -1;
	}
	else if (numSeatsThis == numSeatsCar) {
	return 0;
	}
	else {
	return 1;
	}
	}
	 @Override
	   public String departure() {
	       return "All Aboard\n";
	   }
	   @Override
	   public String arrival() {
	       return "Everyone Out\n";
	   }

	   public String doNotDisturbTheDriver() {
	       return "No Breakseat Driving\n";
	   }
	   @Override
	   public boolean loadPassenger(Person p) {
	       if(p.getAge()>=5 && p.getHeight()>=36){
	           for(int i=0;i<super.numberOfRows;i++){
	               if(super.getNumberOfAvailableSeatsInRow(i)!=0){
	                   super.getPeopleOnBoard()[i][super.getNumberOfPeopleInRow(i)]=p;
	                   return true;
	               }
	           }
	       }
	      
	       return false;
	   }
	   @Override
	   public int loadPassengers(Person[] peeps) {
	       int ret=0;
	       for(int i=0;i<peeps.length;i++){
	           if(this.loadPassenger(peeps[i])==true){
	               ret++;
	           }
	       }
	      
	       return ret;
	   }



	}