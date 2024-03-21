
import Domain.*;

import Repository.ClientCardRepository;
import Repository.MedicineRepository;
import Repository.TransactionRepository;

import Service.ClientCardService;
import Service.MedicinePharmacyService;
import Service.TransactionPharmacyService;
import UI.Console;

public class Main {
    public static void main(String[] args) {
        MedicinePharmacyValidator medicinePharmacyValidator = new MedicinePharmacyValidator();
        ClientCardValidator cardClientValidator = new ClientCardValidator();
        TransactionPharmacyValidator transactionPharmacyValidator = new TransactionPharmacyValidator();

        MedicineRepository medicineRepository = new MedicineRepository(medicinePharmacyValidator);
        ClientCardRepository clientCardRepository = new ClientCardRepository(cardClientValidator);
        TransactionRepository transactionRepository = new TransactionRepository(transactionPharmacyValidator);

        MedicinePharmacyService medicinePharmacyService = new MedicinePharmacyService(medicineRepository);
        medicinePharmacyService.addOrUpdate("1","paracetamol","unifarm",12,false);
        medicinePharmacyService.addOrUpdate("2","codamin","terapia",10,true);

        ClientCardService clientCardService = new ClientCardService(clientCardRepository);

        clientCardService.addOrUpdate("1","Ciprian","Negru","1860827055127","27.08.1986","12.03.2023");
        clientCardService.addOrUpdate("2","Florin","Rus","1850525055126","25.05.1985","13.03.2023");
        clientCardService.addOrUpdate("3","Andrei","Negru","1860827055127","27.08.1982","14.02.2023");

        TransactionPharmacyService transactionService = new TransactionPharmacyService(transactionRepository,medicineRepository);

        transactionService.addOrUpdate("1","1","123",5,"12.02.2022 15:12");
        transactionService.addOrUpdate("2","2","412",56,"15.03.2022 14:18");

        Console console = new Console(clientCardService, medicinePharmacyService, transactionService);
        console.run();
    }
}