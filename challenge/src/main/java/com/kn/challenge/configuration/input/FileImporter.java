package com.kn.challenge.configuration.input;

import com.kn.challenge.exception.ImportFileException;
import com.kn.challenge.exception.ReadFileException;
import com.kn.challenge.model.Contact;
import com.kn.challenge.utils.FileHelper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FileImporter {
    private static final String SEPARATOR = ",";
    private final FileHelper fileHelper;

    public FileImporter(FileHelper fileHelper) {
        this.fileHelper = fileHelper;
    }

    public List<Contact> getAll() {

        File file = fileHelper.getFileFromResource();
        try {
            return Files.readAllLines(file.toPath()).stream().skip(1).map(line -> line.split(SEPARATOR))
                    .map(this::contactListSeeds)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new ReadFileException(file.getName());
        }
    }

    private Contact contactListSeeds(String[] vect) {
        try {
            return new Contact(vect[0], vect[1]);
        } catch (RuntimeException e) {
            throw new ImportFileException();
        }
    }
}
