package com.kn.challenge.controller;

import com.kn.challenge.model.Contact;
import com.kn.challenge.service.ContactListService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ContactListControllerTest {

    @Mock
    private ContactListService contactListService;

    @InjectMocks
    private ContactListController contactListcontroller;

    @Test
    public void givenParameters_whenGetContactList_thenReturnListOfContacts(){

        List<Contact> contactList = Arrays.asList(
                new Contact("Nino", "url.xpto"),
                new Contact("Nino2", "url.xpto2"),
                new Contact("Nino3", "url.xpto3")
        );
        Page<Contact> contacts = new PageImpl<>(contactList);

        when(contactListService.find("Nino", 0, 3)).thenReturn(contacts);
        ResponseEntity<Object> actual = contactListcontroller.getContactList(Optional.of("Nino"), PageRequest.of(0, 3));
        assertEquals(actual.getBody(), contacts);
    }

    @Test
    public void givenParameters_whenGetContactList_thenReturnNotFound(){

        List<Contact> contactList = new ArrayList<>();
        Page<Contact> contacts = new PageImpl<>(contactList);

        when(contactListService.find("Nino", 0, 3)).thenReturn(contacts);
        ResponseEntity<Object> actual = contactListcontroller.getContactList(Optional.of("Nino"), PageRequest.of(0, 3));
        assertEquals(actual.getBody(), "Not found any contact");
        assertEquals(actual.getStatusCode(), HttpStatus.NOT_FOUND);
    }


}
