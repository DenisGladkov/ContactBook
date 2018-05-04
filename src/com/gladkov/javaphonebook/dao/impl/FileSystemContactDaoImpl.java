package com.gladkov.javaphonebook.dao.impl;

import com.gladkov.javaphonebook.dao.ContactDao;
import com.gladkov.javaphonebook.model.Contact;

import java.io.*;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileSystemContactDaoImpl implements ContactDao {

    /**
     * Сервис работы с файловой системой. Преобразует модели в/из данные хранимые на жестком диске.
     */

    private static final File FILE = new File("data");

    public FileSystemContactDaoImpl() {
    }

    //TODO исправить логику так, что бы файл не пересоздавался а дополнялся.
    @Override
    public void saveContact(Contact contact) {
        try (PrintWriter writer = new PrintWriter(
                new BufferedWriter(new FileWriter(FILE)))) {
            writer.println(contact);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeContact(int id) {

    }

    @Override
    public void editContact(Contact contact) {

    }


    @Override
    public List<Contact> showAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}