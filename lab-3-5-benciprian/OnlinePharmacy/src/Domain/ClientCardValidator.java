package Domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ClientCardValidator {
    public void validate(ClientCard client,String CNP)  {

       if (!client.getCNP().equals(CNP)) {
           throw new RuntimeException("CNP must be unique!");
      }
          /*if (equals(client.getCNP())) {
              throw new RuntimeException("CNP must be  unique!");
        }*/

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            format.parse(client.getDateOfBirth());
        } catch (ParseException pe) {
            throw new RuntimeException("The date of birth is not in a correct format!");
        }

        try {
            format.parse(client.getDateOfRegistration());
        } catch (ParseException pe) {
            throw new RuntimeException("The date of registration is not in a correct format!");
        }
    }
}


