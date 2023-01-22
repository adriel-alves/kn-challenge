package com.kn.challenge.configuration.input;

import com.kn.challenge.exception.ReadFileException;
import com.kn.challenge.model.Contact;
import com.kn.challenge.utils.FileHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Objects;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class FileImporterTest {

    @Mock
    private FileHelper fileHelper;
    @InjectMocks
    private FileImporter fileImporter;

    @Test
    public void givenAFile_whenFileImporter_thenReturnListOfContact() {
        String fileName = "peopleTest.csv";
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        File file = null;
        try {
            file = new File(Objects.requireNonNull(resource).toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        when(fileHelper.getFileFromResource()).thenReturn(file);
        List<Contact> actual = fileImporter.getAll();
        assertEquals(4, actual.size());
    }
}
