package Repository;

import Domain.ClientCard;
import Domain.ClientCardValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientCardRepository {
    private Map<String, ClientCard> storage = new HashMap<>();
    private ClientCardValidator validator;

    public ClientCardRepository(ClientCardValidator validator) {
        this.validator = validator;

    }
    public ClientCard findById(String id) {
        return storage.get(id);
    }

    /**
     * Adds or updates a client if it already exists.
     * @param client the client to add or update.
     */
    public void upsert(ClientCard client,String CNP) {

        validator.validate(client,CNP);
        storage.put(client.getId(), client);
    }

    /**
     * Removes a client with a given id.
     * @param id the id.
     * @throws RuntimeException if there is no client with the given id.
     */
    public void remove(String id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException("There is no client with the given id to remove.");
        }

        storage.remove(id);
    }

    public List<ClientCard> getAll() {
        return new ArrayList<>(storage.values());
    }
}

