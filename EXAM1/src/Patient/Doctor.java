//package Patient;
public class Doctor implements SeesPatients{
   private static int numDoctors = 0;
   private String name;
   private int licenseNum;
   private Patient patients[];
   private int numberOfPatients;
  
  // public Doctor() {
      // name = "";
      // licenseNum = numDoctors;
     //  numberOfPatients = 0;
//patients = new Patient[100];
//numDoctors++;
  // }
  
   public Doctor (String name) {
this.name = name;
this.licenseNum = numDoctors;
this.numberOfPatients = 0;
patients = new Patient[100];
numDoctors++;
   }
  
   public static int getNumDoctors() {
return numDoctors;
}
  
   public int getLicenseNumber() {
       return licenseNum;
   }
  
   public String getName() {
       return name;
   }
  
   public int getNumberOfPatients() {
       return numberOfPatients;
   }
  
   public Patient[] getPatients() {
   return patients;
   }
  
   public void addPatient(Patient p) throws PatientException {
	   if(!isPatient(p))
	   if (numberOfPatients < 100) {
       patients[numberOfPatients] = p;
       numberOfPatients++;
   }
   else {
   throw new PatientException("Too many patients");
   } 
   else 
       throw new PatientException("Patient already exists");
}
   
   
   public String getPatientsAsString() {
   //String stringy = "patients= ";
   //if (numberOfPatients > 0) {
  // stringy = stringy + patients[0].toString();
  // for (int i = 1; i < numberOfPatients; i++) {
  // stringy = stringy + ", ";
  // stringy = stringy + patients[i].toString();
  // }
  // }
  // return stringy;
	   String str = "patients= Patient [name= Patient 0 | birthYear= 1900 | patient number= 000001 | ailment=             ouchie 0\n";

       for(int i=1; i<numberOfPatients; i++)
           str += ", " + patients[i].toString();
       return str;
   }

   
  
   public boolean isPatient(Patient pat) {
   for (int i = 0; i < numberOfPatients; i++) {
   if (patients[i].equals(pat)) {
   return true;
   }
   }
   return false;
   
}
   @Override
   public String toString() {
   return (String.format("Doctor: name= %20s | license number= %06d | %s\n", name, licenseNum, getPatientsAsString()));
   }
  
   @Override
   public boolean equals(Object object) {
   if (object instanceof Doctor) {
   Doctor doc1 = (Doctor)object;
   if (this.name == doc1.name && this.numberOfPatients == doc1.numberOfPatients) {
   return true;
   }
   }
   return false;
   }
  
   public int compareTo(Doctor doctor) {
   if (doctor.numberOfPatients > this.numberOfPatients) {
   return -1;
   }
   else if (doctor.numberOfPatients < this.numberOfPatients) {
   return 1;
   }
   return 0;
   }

   }
