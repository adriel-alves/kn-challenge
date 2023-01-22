package com.kn.challenge.controller;

import com.kn.challenge.service.ContactListService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/contact-list")
public class ContactListController {

    private final ContactListService contactListService;

    public ContactListController(final ContactListService contactListService) {
        this.contactListService = contactListService;
    }

    @GetMapping
    public ResponseEntity<Object> getContactList(@RequestParam Optional<String> name, @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {

        if(contactListService.find(name.orElse(""), pageable.getPageNumber(), pageable.getPageSize()).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found any contact");
        }
        return ResponseEntity.status(HttpStatus.OK).body(contactListService.find(name.orElse(""), pageable.getPageNumber(), pageable.getPageSize()));
    }
}
