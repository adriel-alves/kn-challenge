package com.kn.challenge.service;

import com.kn.challenge.model.Contact;
import com.kn.challenge.repository.ContactListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactListService {

    private final ContactListRepository contactListRepository;

    public ContactListService(ContactListRepository contactListRepository) {
        this.contactListRepository = contactListRepository;
    }

    public List<Contact> findAll() {
        return contactListRepository.findAll();
    }
}
