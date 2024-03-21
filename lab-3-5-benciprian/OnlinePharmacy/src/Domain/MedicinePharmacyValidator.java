package Domain;

public class MedicinePharmacyValidator {
     public void validate(MedicinePharmacy medicinePharmacy) {
         if (medicinePharmacy.getPrice() < 0) {
             throw new RuntimeException("The price of medicine must be positive ");
         }
     }
}
