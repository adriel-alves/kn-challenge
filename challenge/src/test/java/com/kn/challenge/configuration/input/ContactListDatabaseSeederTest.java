package com.kn.challenge.configuration.input;

import com.kn.challenge.model.Contact;
import com.kn.challenge.repository.ContactListRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ContactListDatabaseSeederTest {
    @Mock
    private FileImporter fileImporter;

    @Mock
    private ContactListRepository contactListRepository;

    @InjectMocks
    private ContactListDatabaseSeeder contactListDatabaseSeeder;

    @Test
    public void givenAContactList_whenContactListDatabaseSeeder_thenVerify() {

        Contact contact = new Contact("Person 1", "url.xpto1");
        Contact contact2 = new Contact("Person 2", "url.xpto2");
        when(fileImporter.getAll()).thenReturn(Arrays.asList(contact, contact2));
        when(contactListRepository.save(contact)).thenReturn(contact);
        when(contactListRepository.save(contact2)).thenReturn(contact2);
        contactListDatabaseSeeder.initContactListDatabase();
        verify(fileImporter, times(1)).getAll();
        verify(contactListRepository, times(1)).save(contact);
        verify(contactListRepository, times(1)).save(contact2);
    }
}
