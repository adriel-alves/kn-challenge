package com.kn.challenge.service;

import com.kn.challenge.model.Contact;
import com.kn.challenge.repository.ContactListRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ContactListServiceTest {
    @Mock
    private ContactListRepository contactListRepository;

    @InjectMocks
    private ContactListService contactListService;

    @Test
    public void givenAValidName_whenFindByNameContaingingIgnoreCases_thenReturnListOfContacts(){

        List<Contact> contactList = Arrays.asList(
                new Contact("Nino", "url.xpto"),
                new Contact("Nino2", "url.xpto2"),
                new Contact("Nino3", "url.xpto3")
        );
        Page<Contact> contacts = new PageImpl<>(contactList);

        when(contactListRepository.findByNameContainingIgnoreCase("Nino", PageRequest.of(0, 1))).thenReturn(Optional.of(contacts));
        Page<Contact> actual = contactListService.find("Nino", 0, 1);
        assertEquals(actual, contacts);
    }
}
