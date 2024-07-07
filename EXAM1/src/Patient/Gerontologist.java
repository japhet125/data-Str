//package Patient;

	public class Gerontologist extends Doctor{
		   private boolean performsHouseCalls = true;
		   private double visitFee = 0.0;

		   public Gerontologist (String name) {
		       super(name);
		   }

		   public Gerontologist (String name, boolean performsHouseCalls, double visitFee) {
		       super(name);
		       this.performsHouseCalls = performsHouseCalls;
		       this.visitFee = visitFee;
		   }

		   public void setPerformsHouseCalls(boolean performsHouseCalls) {
		       this.performsHouseCalls = performsHouseCalls;
		   }

		   public boolean performsHouseCalls() {
		       return performsHouseCalls;
		   }

		   public void setVisitFee(double visitFee) {
		      // this.visitFee = visitFee;
			   if(visitFee < 0){
		            visitFee = 0.0;
		        }
		        this.visitFee = visitFee;
		    }
		   

		   public double getVisitFee() {
		       return visitFee;
		   }

		   public void addPatient(Patient p) throws PatientException {
		       int currentYear = 2022;
		       if (currentYear - p.getBirthYear() > 65) {
		           super.addPatient(p);
		       }
		       else {
		           throw new PatientException("Patient too young");
		       }
		   }
		  
		   @Override
		   public String toString() {
		       return super.toString() + String.format("\nGerontologist: %s | visit fee=%02.2f", (performsHouseCalls ? "performs house calls" : "no house calls"), visitFee);
		   }
		  
		   @Override
		   public boolean equals(Object object) {
		       //if (object instanceof Gerontologist) {
		         //  Gerontologist ger1 = (Gerontologist) object;
		           //if (this.performsHouseCalls == ger1.performsHouseCalls && this.visitFee == ger1.visitFee) {
		             //  return true;
		           //}
		      // }
		     //  return false;
		  // }
			   return toString().equals(object.toString());
		    }
		}
		

