package com.kn.challenge.utils;

import com.kn.challenge.configuration.input.FileImporter;
import com.kn.challenge.model.Contact;
import com.kn.challenge.repository.ContactListRepository;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ContactListComponent {

    private final FileImporter fileImporter;
    private final ContactListRepository contactListRepository;

    public ContactListComponent(FileImporter fileImporter, ContactListRepository contactListRepository) {
        this.fileImporter = fileImporter;
        this.contactListRepository = contactListRepository;
    }

    @Transactional
    public void initContactListDatabase() {
        List<Contact> contactListSeeds = fileImporter.getAll();
        for (Contact contact: contactListSeeds) {
            contactListRepository.save(contact);
        }
    }

}
