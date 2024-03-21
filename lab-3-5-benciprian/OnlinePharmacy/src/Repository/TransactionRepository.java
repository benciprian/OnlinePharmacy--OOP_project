package Repository;

import Domain.TransactionPharmacy;
import Domain.TransactionPharmacyValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionRepository {
    private Map<String, TransactionPharmacy> storage = new HashMap<>();
    private TransactionPharmacyValidator validator;
    public TransactionRepository(TransactionPharmacyValidator validator) {
        this.validator = validator;
    }
    public TransactionPharmacy findById(String id) {
        return storage.get(id);
    }

    /**
     * Adds or updates a transaction if it already exists.
     * @param transactionPharmacy the transaction to add or update.
     */
    public void upsert(TransactionPharmacy transactionPharmacy) {
        validator.validate(transactionPharmacy);
        storage.put(transactionPharmacy.getId(), transactionPharmacy);
    }

    /**
     * Removes a transaction with a given id.
     * @param id the id.
     * @throws RuntimeException if there is no transaction with the given id.
     */
    public void remove(String id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException("There is no transaction with the given id to remove.");
        }

        storage.remove(id);
    }
    public List<TransactionPharmacy> getAll() { return new ArrayList<>(storage.values());
    }
  }

