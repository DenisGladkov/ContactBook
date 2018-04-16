package com.gladkov.javaphonebook.dao.impl;

import com.gladkov.javaphonebook.dao.ContactDao;
import com.gladkov.javaphonebook.model.Contact;

import java.io.*;
import java.nio.file.StandardOpenOption;

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
                new OutputStreamWriter(new FileOutputStream(FILE, true)) {
                    @Override
                    public void write(int b) throws IOException { }
                })) {
            writer.println(contact);
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeContact() {

    }

    @Override
    public void showAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}