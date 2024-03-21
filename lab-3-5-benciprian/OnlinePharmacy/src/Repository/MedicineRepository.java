package Repository;

import Domain.MedicinePharmacy;
import Domain.MedicinePharmacyValidator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicineRepository {
    private  Map<String, MedicinePharmacy> storage = new HashMap<>();
    private MedicinePharmacyValidator validator;
    public MedicineRepository(MedicinePharmacyValidator validator) {
        this.validator = validator;
    }
    public  MedicinePharmacy findById(String id) {
        return storage.get(id);
    }

    /**
     * Removes a medicine with a given id
     * @param medicinePharmacy the medicine to add or update
     */

    public void upsert(MedicinePharmacy medicinePharmacy) {
        validator.validate(medicinePharmacy);
        storage.put(medicinePharmacy.getId(), medicinePharmacy);
    }

    /**
     * Removes a medicine with a given id.
     * @param
     * @throws RuntimeException if there is no transaction with the given id.
     */
    public void remove(String id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException("There is no medicine with the given id to remove.");
        }

        storage.remove(id);
    }
    public List<MedicinePharmacy> getAll() {
        return new ArrayList<>(storage.values());
    }
}
