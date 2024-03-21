package Service;

import Domain.MedicinePharmacy;
import Repository.MedicineRepository;


import java.util.List;

public class MedicinePharmacyService {
    private MedicineRepository medicineRepository;
    public MedicinePharmacyService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }
    public MedicinePharmacy addOrUpdate(String id, String name, String manufacturer, double price, boolean requires_prescription) {
        MedicinePharmacy existing = medicineRepository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (name.isEmpty()) {
                name = existing.getName();
            }
            if (manufacturer.isEmpty()) {
                manufacturer = existing.getManufacturer();
            }
            if (price == 0) {
                price = existing.getPrice();
            }
            if (requires_prescription == true) {
                requires_prescription = existing.isRequires_prescription();
            }
        }

        MedicinePharmacy medicine = new MedicinePharmacy(id, name, manufacturer, price, requires_prescription);
        medicineRepository.upsert(medicine);
        return medicine;
    }


    public void remove(String id) { medicineRepository.remove(id);}
    public List<MedicinePharmacy> getAll() {
        return medicineRepository.getAll();
    }
}
