//package Patient;
public class Pediatrician extends Doctor {
   private boolean hasPrivatePractice = false;
   private String hospitalName = "";

   public Pediatrician(String name) {
       super(name);
   }

   public Pediatrician(String name, boolean hasPrivatePractice, String hospitalName) {
       super(name);
       this.hasPrivatePractice = hasPrivatePractice;
       this.hospitalName = hospitalName;
   }

   public boolean hasPrivatePractice() {
       return hasPrivatePractice;
   }

   public void setHospitalName(String hospitalName){
       this.hospitalName = hospitalName;
   }

   public String getHospitalName() {
       return hospitalName;
   }

   @Override
public void addPatient(Patient pat) throws PatientException {
   int currentYear = 2020;
if (currentYear - pat.getBirthYear() < 18) {
super.addPatient(pat);
}
else {
throw new PatientException("Adult");
}
}
  
@Override
public String toString() {
return super.toString() + String.format("\nPediatrician: %s | hospital name=%15s", (hasPrivatePractice ? "has private practice" : "does not have private practice"), hospitalName);
}
  
@Override
public boolean equals(Object object) {
if (object instanceof Pediatrician) {
Pediatrician ped1 = (Pediatrician)object;
if (this.hasPrivatePractice == ped1.hasPrivatePractice && this.hospitalName == ped1.hospitalName) {
return true;
}
}
return false;
}
}
	