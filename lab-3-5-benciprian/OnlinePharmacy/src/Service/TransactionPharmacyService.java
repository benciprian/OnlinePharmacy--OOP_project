package Service;


import Domain.MedicinePharmacy;
import Domain.TransactionPharmacy;
import Repository.MedicineRepository;
import Repository.TransactionRepository;

import java.util.List;

public class TransactionPharmacyService {
    private TransactionRepository transactionRepository;
    private MedicineRepository medicineRepository;

    public TransactionPharmacyService(TransactionRepository transactionRepository, MedicineRepository medicineRepository) {
        this.transactionRepository = transactionRepository;
        this.medicineRepository = medicineRepository;
    }
    public TransactionPharmacy addOrUpdate(String id, String id_medicine, String id_card_client, int number_of_Items, String date_and_time) {
        TransactionPharmacy existing = transactionRepository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (id_medicine.isEmpty()) {
                id_medicine = existing.getId_medicine();
            }
            if (id_card_client == null) {
                id_card_client = existing.getId_card_client();
            }
            if (number_of_Items == 0) {
                number_of_Items = existing.getNumber_of_Items();
            }
            if (date_and_time.isEmpty()) {
                date_and_time = existing.getDate_and_time();
            }
        }
        MedicinePharmacy medicinePharmacy = medicineRepository.findById(id_medicine);
        double totalPrice = medicinePharmacy.getPrice() * number_of_Items;
        double discount = 0.0;
        if (id_card_client != null) {
            boolean requires_prescription = medicinePharmacy.isRequires_prescription();
            if (requires_prescription) {
                discount = totalPrice * 0.15;
            } else {
                discount = totalPrice * 0.10;
            }
        }
            double finallyPrice = totalPrice - discount;
            TransactionPharmacy transaction = new TransactionPharmacy(id, id_medicine, id_card_client, number_of_Items, date_and_time,discount,finallyPrice);
            transactionRepository.upsert(transaction);
            return transaction;
        }


    public void remove(String id) { transactionRepository.remove(id);}
    public List<TransactionPharmacy> getAll() {
        return transactionRepository.getAll();
    }
}

