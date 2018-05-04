package com.gladkov.javaphonebook.services.impl;


import java.util.HashMap;
import java.util.Map;

import com.gladkov.javaphonebook.model.Contact;
import com.gladkov.javaphonebook.services.ContactService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContactServiceImpl implements ContactService {

    /**
     * Реализация ContactService которая использует Map для хранения данных.
     */

    private final ObservableList<Contact> contactList;


    public ContactServiceImpl() {
        this.contactList = FXCollections.observableArrayList();
    }

    @Override
    public void createContact(String name, int phone) {
        contactList.add(new Contact(name, phone));
    }

    @Override
    public void removeContact(int id) {
        contactList.remove(id);
    }

    @Override
    public ObservableList<Contact> showContacts() {
        return contactList;
    }

    @Override
    public void editContact(String name, String newName, int newAge) {
//        Contact contact = contactList.get(name);
//        contact.setName(newName);
//        contact.setAge(newAge);
    }
}


