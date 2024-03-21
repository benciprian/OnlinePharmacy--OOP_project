package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TransactionPharmacyValidator {
    public void validate(TransactionPharmacy transactionPharmacy) {
    SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        try {
        format.parse(transactionPharmacy.getDate_and_time());
    } catch (
    ParseException pe) {
        throw new RuntimeException("The date and hour is not in a correct format!");
    }
  }
}
