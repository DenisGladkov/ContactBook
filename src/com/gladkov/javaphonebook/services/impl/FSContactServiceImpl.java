package com.gladkov.javaphonebook.services.impl;

import com.gladkov.javaphonebook.dao.ContactDao;
import com.gladkov.javaphonebook.model.Contact;
import com.gladkov.javaphonebook.services.ContactService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class FSContactServiceImpl implements ContactService {

    /**
     * Реализация ContactService которая использует Файловую Систему для хранения данных.
     */

    private final ContactDao contactDao;
    ObservableList<Contact> list = FXCollections.observableArrayList();

    public FSContactServiceImpl(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    public void createContact(String name, String phoneNumber, int ageN) {
        contactDao.saveContact(new Contact(name, phoneNumber, ageN));
    }

    @Override
    public void removeContact(String Name) {
        contactDao.removeContact(Name);
    }

    @Override
    public void showContacts() {
        final List<Contact> contacts = contactDao.showAll();
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    @Override
    public void editContact(String oldName, String newName, String newPhoneNumber, int newAge) {
        Contact contact = new Contact(newName, newPhoneNumber, newAge);
        contactDao.editContact(oldName, contact);
    }
}
