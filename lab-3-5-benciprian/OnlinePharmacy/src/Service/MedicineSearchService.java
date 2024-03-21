package Service;

import Domain.MedicinePharmacy;
import Repository.MedicineRepository;

import java.util.ArrayList;
import java.util.List;

public class MedicineSearchService {
    MedicineRepository medicineRepository;
    public MedicineSearchService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;

    }
    public List<MedicinePharmacy> searchMedicine (String query) {
        List<MedicinePharmacy> result = new ArrayList<>();
        for (MedicinePharmacy medicine : this.medicineRepository.getAll()) {
            if (medicine.getName().toLowerCase().contains((query.toLowerCase()))) {
                result.add(medicine);
            } else if (String.valueOf(medicine.getManufacturer()).equals(query)) {
                result.add(medicine);
            } else if (String.valueOf(medicine.getId()).equals(query)) {
                result.add(medicine);
            }
        }
        return result;
    }

}
