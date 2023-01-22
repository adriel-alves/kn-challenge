package com.kn.challenge.service;

import com.kn.challenge.model.Contact;
import com.kn.challenge.repository.ContactListRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactListService {

    private final ContactListRepository contactListRepository;

    public ContactListService(final ContactListRepository contactListRepository) {
        this.contactListRepository = contactListRepository;
    }

    public Page<Contact> find(String name, int page, int size) {
        Optional<Page<Contact>> contactListByName = contactListRepository.findByNameContainingIgnoreCase(name, PageRequest.of(page, size));
        return contactListByName.orElseGet(contactListByName::get);
    }
}
