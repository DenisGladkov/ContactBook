package com.gladkov.javaphonebook.services.impl;

import com.gladkov.javaphonebook.dao.ContactDao;
import com.gladkov.javaphonebook.model.Contact;
import com.gladkov.javaphonebook.services.ContactService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

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
    public void createContact(String name, String phoneNumber) {
        contactDao.saveContact(new Contact(name, phoneNumber));
        showContacts();
    }

    @Override
    //public void removeContact(int id) {

   // }

    @Override
    public void deleteContact(String name) {
//		this.contactList.remove(name);
    }

    @Override
    public ObservableList<Contact> showContacts() {
        list.clear();
        list.addAll(contactDao.showAll());
        return list;
    }

    public void editContact(String name, String newName, int newAge) {
//		Contact contact = this.contactList.get(name);
//		contact.setName(newName);
//		contact.setAge(newAge);
    }

}
