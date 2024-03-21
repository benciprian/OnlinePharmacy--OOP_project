package UI;



import Domain.ClientCard;
import Domain.MedicinePharmacy;
import Domain.TransactionPharmacy;

import Service.ClientCardService;
import Service.MedicinePharmacyService;
import Service.TransactionPharmacyService;

import java.util.List;
import java.util.Scanner;

public class Console {
    private ClientCardService clientCardService;
    private MedicinePharmacyService medicinePharmacyService;
    private TransactionPharmacyService transactionPharmacyService;
    private Scanner scanner;
    public Console(ClientCardService clientCardService, MedicinePharmacyService medicinePharmacyService, TransactionPharmacyService transactionPharmacyService) {
        this.clientCardService = clientCardService;
        this.medicinePharmacyService = medicinePharmacyService;
        this.transactionPharmacyService = transactionPharmacyService;

        this.scanner = new Scanner(System.in);
    }
    private void showMenu() {
        System.out.println("1. Medicine Pharmacy CRUD");
        System.out.println("2. Client Pharmacy CRUD");
        System.out.println("3. Transaction Pharmacy CRUD");
        System.out.println("0. Exit");
    }
    public void run() {
        while (true) {
            showMenu();

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    runMedicinePharmacyCrud();
                    break;
                case "2":
                    runCardClientPharmacyCrud();
                    break;
                case "3":
                    runTransactionPharmacyCrud();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
    private void runTransactionPharmacyCrud() {
        while (true) {
            System.out.println("1. Add or update a transaction");
            System.out.println("2. Remove a transaction");
            System.out.println("3. View all transactions");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateTransaction();
                    break;
                case "2":
                    handleRemoveTransaction();
                    break;
                case "3":
                    handleViewTransactions();
                    break;
                case "4":
                    return;

                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
    private void handleViewTransactions() {
        for (TransactionPharmacy transaction : transactionPharmacyService.getAll()) {
            System.out.println(transaction);
        }
    }
    private void handleRemoveTransaction() {
        try {
            System.out.print("Enter the id to remove:");
            String id = scanner.nextLine();
            transactionPharmacyService.remove(id);

            System.out.println("Transaction removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }
    private void handleAddUpdateTransaction() {
        try {
            System.out.print("Enter id: ");
            String id = scanner.nextLine();
            System.out.print("Enter transaction id (empty to not change for update): ");
            String id_medicine = scanner.nextLine();
            System.out.print("Enter client card (empty to not change for update): ");
            String id_card_client = scanner.nextLine();
            System.out.print("Enter number of items (0 to not change for update): ");
            int number_of_Items = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter date (empty to not change for update): ");
            String date_and_time = scanner.nextLine();

            TransactionPharmacy transaction = transactionPharmacyService.addOrUpdate(id, id_medicine, id_card_client, number_of_Items, date_and_time);
            System.out.println(String.format("Added transaction id=%s,discount=%f%%, paid price=%f", transaction.getId(),transaction.getDiscount(),transaction.getFinallyPrice()));//,transaction.(), transaction.getDiscount()));
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }
    private void runCardClientPharmacyCrud() {
        while (true) {
            System.out.println("1. Add or update a card client");
            System.out.println("2. Remove a card client");
            System.out.println("3. View all cards clients");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateCardClient();
                    break;
                case "2":
                    handleRemoveCardClient();
                    break;
                case "3":
                    handleViewCardClients();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
    private void handleViewCardClients() {
        for (ClientCard client : clientCardService.getAll()) {
            System.out.println(client);
        }
    }

    private void handleRemoveCardClient() {
        try {
            System.out.print("Enter the id to remove:");
            String id = scanner.nextLine();
            clientCardService.remove(id);

            System.out.println("Client removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateCardClient() {
        try {
            System.out.print("Enter id: ");
            String id = scanner.nextLine();
            System.out.print("Enter last name (empty to not change for update): ");
            String lastName = scanner.nextLine();
            System.out.print("Enter first name (empty to not change for update): ");
            String firstName = scanner.nextLine();
            System.out.print("Enter CNP (empty to not change for update): ");
            String CNP = scanner.nextLine();
            System.out.print("Enter date of birth (empty to not change for update): ");
            String dateOfBirth = scanner.nextLine();
            System.out.print("Enter date of registration (empty to not change for update): ");
            String dateOfRegistration = scanner.nextLine();

            clientCardService.addOrUpdate(id, lastName, firstName, CNP, dateOfBirth, dateOfRegistration);

            System.out.println("Client added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void runMedicinePharmacyCrud() {
        while (true) {
            System.out.println("1. Add or update a medicine");
            System.out.println("2. Remove a medicine");
            System.out.println("3. View all medicines");
            System.out.println("4  Search medicine");
            System.out.println("5. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateMedicine();
                    break;
                case "2":
                    handleRemoveMedicine();
                    break;
                case "3":
                    handleViewMedicine();
                    break;
                case "4":
                    //handleSearchMedicine();
                case "5":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
    private void handleViewMedicine() {
        for (MedicinePharmacy medicine : medicinePharmacyService.getAll()) {
            System.out.println(medicine);
        }
    }
  /* private void handleSearchMedicine() {
        System.out.println("Search terms:");
        scanner.nextLine();
        String searchTerm = this.scanner.nextLine().toLowerCase();
        List<MedicinePharmacy> searchResult = this.medicinePharmacyService.searchMedicine(searchTerm);
        System.out.println("The medicine found:");
        for (MedicinePharmacy medicinePharmacy : searchResult) {
            System.out.println(medicinePharmacy);
        }
    }*/
    private void handleRemoveMedicine() {
        try {
            System.out.print("Enter the id to remove:");
            String id = scanner.nextLine();
            medicinePharmacyService.remove(id);

            System.out.println("Medicine removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }
    private void handleAddUpdateMedicine() {

        try {
            System.out.print("Enter id: ");
            String id = scanner.nextLine();
            System.out.print("Enter name (empty to not change for update): ");
            String name = scanner.nextLine();
            System.out.print("Enter manufacturer (empty to not change for update): ");
            String manufacturer = scanner.nextLine();
            System.out.print("Enter price (0 to not change for update): ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter the prescription (true / false): ");
            boolean  requires_prescription= Boolean.parseBoolean(scanner.nextLine());

            medicinePharmacyService.addOrUpdate(id, name, manufacturer, price, requires_prescription);

            System.out.println("Medicine added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }
}





