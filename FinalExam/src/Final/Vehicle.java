//package Final;

public abstract class Vehicle {

	 
	  protected Person[][] personsOnBoard;

	  protected int numberOfRows;

	  protected int maxSeatsPerRow;

	  protected int[] numSeatsPerRow;


	  public Vehicle(int numRows, int numSeatsPerRow) {

	    numberOfRows = numRows;

	    maxSeatsPerRow = numSeatsPerRow;

	    personsOnBoard = new Person[numberOfRows][];

	    this.numSeatsPerRow = new int[numberOfRows];

	    

	    for(int i=0;i<numberOfRows;i++) {

	      personsOnBoard[i] = new Person[numSeatsPerRow];

	      this.numSeatsPerRow[i] = maxSeatsPerRow;

	    }

	  }

	  

	  public Vehicle(int[] numSeatsPerRow) {

	    numberOfRows = numSeatsPerRow.length;

	    maxSeatsPerRow = numSeatsPerRow[0];

	    personsOnBoard = new Person[numberOfRows][];

	    this.numSeatsPerRow = numSeatsPerRow;

	    

	    for(int i=0;i<numberOfRows;i++) {

	      personsOnBoard[i] = new Person[numSeatsPerRow[i]];

	      if(numSeatsPerRow[i] < maxSeatsPerRow)

	        maxSeatsPerRow = this.numSeatsPerRow[i];

	    }

	    

	  }

	  

	  public Vehicle(Person driver, int[] numSeatsPerRow) {

	    this(numSeatsPerRow);

	    if(driver.hasDriverLicense())

	      personsOnBoard[0][0] = driver;

	  }

	  



	  public abstract boolean loadPassenger(Person p);

	  public abstract int loadPassengers(Person[] people);

	  



	  public void setDriver(Person p) throws InvalidDriverException {

	    if(p.hasDriverLicense())

	      personsOnBoard[0][0] = p;

	    else

	      throw new InvalidDriverException();

	  }



	  public Person getDriver() {

	    return personsOnBoard[0][0];

	  }



	  public boolean hasDriver() {

	    return (personsOnBoard[0][0] != null);

	  }



	  public int getNumberOfAvailableSeats() {

	    int availableSeats = 0;

	    for(int i=0;i<numberOfRows;i++) {

	      for(int j=0;j<numSeatsPerRow[i];j++) {

	        if(personsOnBoard[i][j] == null)

	          availableSeats++;

	      }

	    }

	    

	    return availableSeats;

	  }

	  

	  public int getNumberOfAvailableSeatsInRow(int row) {

	    int availableSeats = -1;

	    if(row >=0 && row < numberOfRows) {

	      availableSeats = 0;

	      

	      for(int i=0;i<numSeatsPerRow[row];i++) {

	        if(personsOnBoard[row][i] == null)

	          availableSeats++;

	      }

	    }

	    

	    return availableSeats;

	  }

	  

	  public int getNumberOfPeopleOnBoard() {

	    int countPeopleOnBoard = 0;

	    for(int i=0;i<numberOfRows;i++) {

	      for(int j=0;j<numSeatsPerRow[i];j++) {

	        if(personsOnBoard[i][j] != null)

	          countPeopleOnBoard++;

	      }

	    }

	    

	    return countPeopleOnBoard;

	  }

	  

	  public int getNumberOfPeopleInRow(int row) {

	    int countPeopleInRow = -1;

	    if(row >= 0 && row < numberOfRows)

	    {

	      countPeopleInRow = 0;

	      for(int i=0;i<numSeatsPerRow[row];i++)

	      {

	        if(personsOnBoard[row][i] != null)

	          countPeopleInRow++;

	      }

	    }

	    

	    return countPeopleInRow;

	  }

	  

	  public Person getPersonInSeat(int row, int col) {

	    if(row >=0 && row < numberOfRows && col >= 0 && col < numSeatsPerRow[row]) {

	      return personsOnBoard[row][col];

	    }

	    

	    return null;

	  }

	  

	  public int[] getLocationOfPersonInVehicle(Person p) {

	    int location[] = {-1,-1};

	    for(int i=0;i<numberOfRows;i++) {

	      for(int j=0;j<numSeatsPerRow[i];j++) {

	        if(personsOnBoard[i][j] != null) {

	          if(personsOnBoard[i][j].equals(p)) {

	            location[0] = i;

	            location[1] = j;

	            return location;

	          }

	        }

	      }

	    }

	    

	    return location;

	  }



	  public Person[] getPeopleInRow(int row) {

	    int numPeople = getNumberOfPeopleInRow(row);

	    if(numPeople > 0) {

	      Person[] personsInRow = new Person[numPeople];

	     int count = 0;

	     for(int i=0;i<numSeatsPerRow[row];i++) {

	       if(personsOnBoard[row][i] != null) {

	         personsInRow[count] = personsOnBoard[row][i].clone();

	         count++;

	       }

	      }

	     return personsInRow;

	   }

	    

	    return personsOnBoard[row];

	  }

	  

	  public Person[][] getPeopleOnBoard() {

	    Person[][] peopleOnBoard = new Person[numberOfRows][];

	    

	    for(int i=0;i<numberOfRows;i++) {

	      int count = getNumberOfPeopleInRow(i);

	      if(count <= 0)

	        count = 0;

	      

	      peopleOnBoard[i] = new Person[count];

	      

	      if(peopleOnBoard[i].length > 0) {

	        peopleOnBoard[i] = getPeopleInRow(i);

	      }

	    }

	    

	    return peopleOnBoard;

	  }

	  

	  public boolean isPersonInVehicle(Person p) {

	    int location[] = getLocationOfPersonInVehicle(p);

	    

	    return(location[0] != -1);

	  }

	  

	  public boolean isPersonDriver(Person p) {

	    return (personsOnBoard[0][0].equals(p));

	  }

	}