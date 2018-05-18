package com.gladkov.javaphonebook.dao.impl;

import com.gladkov.javaphonebook.dao.ContactDao;
import com.gladkov.javaphonebook.model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class FileSystemContactDaoImpl implements ContactDao {

    /**
     * Сервис работы с файловой системой. Преобразует модели в/из данные хранимые на жестком диске.
     */

    private static final File FILE = new File("data");
    private ArrayList<Contact> contactList = new ArrayList<Contact>();

    public FileSystemContactDaoImpl() {
        if (!FILE.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE))){
                String line;
                while ((line = reader.readLine()) != null)
            writeCollectionToFile();
        }
    }


    //TODO исправить логику так, что бы файл не пересоздавался а дополнялся.
    @Override
    public void saveContact(Contact contact) {
        try(PrintStream printStream = new PrintStream(new FileOutputStream(FILE, true), true)) {
            printStream.println(contact);
            printStream.println(contact);
            printStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteContact(int id) {
        if (!contactList.isEmpty()) contactList.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))){
            String line;
            while ((line = reader.readLine()) != null) {String[] str = line.split(":");

                String name = str[1];
                String phoneNumber = str[2];
                int age = Integer.valueOf(str[3]);

                contactList.add( new Contact(name, phoneNumber, age));};
        } catch (IOException e) {
            e.printStackTrace();
        }

        int index = findIndexOfElement(id);
        if (index > -1 ) contactList.remove(index);

        if (FILE.delete()) {
            try(PrintStream printStream = new PrintStream(new FileOutputStream(FILE, true), true)) {
                for (Contact contact: contactList) {
                    printStream.println(contact);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private int findIndexOfElement(long id){
        for (int i = 0; i < contactList.size(); i++ ) {
            if (contactList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }


    public void editContact(Contact contact) {

    }


    @Override
    public ArrayList<Contact> selectAllContact() {
        if (!contactList.isEmpty()) contactList.clear();
        {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] str = line.split(":");

                long id = Long.valueOf(str[0]);
                String name = str[1];
                String phoneNumber = str[2];
                int age = Integer.valueOf(str[3]);
                String address = str[4];

                contactList.add( new Contact(name, phoneNumber, age));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return contactList;
    }
}