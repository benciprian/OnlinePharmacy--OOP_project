package Service;

import Domain.ClientCard;
import Repository.ClientCardRepository;

import java.util.List;

public class ClientCardService {
    private ClientCardRepository repository;

    public ClientCardService(ClientCardRepository repository) {
        this.repository = repository;
    }

    public void addOrUpdate(String id, String lastName, String firstName, String CNP, String dateOfBirth, String dateOfRegistration) {
        ClientCard existing = repository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (lastName.isEmpty()) {
                lastName = existing.getLastName();
            }
            if (firstName.isEmpty()) {
                firstName = existing.getFirstName();
            }
            if (CNP.isEmpty()) {
                CNP = existing.getCNP();
            }
            if (dateOfBirth.isEmpty()) {
                dateOfBirth = existing.getDateOfBirth();
            }
            if (dateOfRegistration.isEmpty()) {
                dateOfRegistration = existing.getDateOfRegistration();
            }
        }
        ClientCard client = new ClientCard(id, lastName, firstName, CNP, dateOfBirth, dateOfRegistration);
        repository.upsert(client, CNP);
    }

    public void remove(String id) {
        repository.remove(id);
    }

    public List<ClientCard> getAll() {
        return repository.getAll();
    }
}



