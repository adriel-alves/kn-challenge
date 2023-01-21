package com.kn.challenge.controller;

import com.kn.challenge.model.Contact;
import com.kn.challenge.service.ContactListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/contact-list")
public class ContactListController {

    private final ContactListService contactListService;

    public ContactListController(ContactListService contactListService) {
        this.contactListService = contactListService;
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContactList(){
        return ResponseEntity.status(HttpStatus.OK).body(contactListService.findAll());
    }
}
