package com.gladkov.javaphonebook.services.impl;


import com.gladkov.javaphonebook.dao.ContactDao;
import com.gladkov.javaphonebook.model.Contact;
import com.gladkov.javaphonebook.services.ContactService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;

public class ContactServiceImpl implements ContactService {

    /**
     * Реализация ContactService которая использует Map для хранения данных.
     */

ContactDao contactDao;
    private final ObservableList<Contact> contactList;


    public ContactServiceImpl() {
        this.contactList = FXCollections.observableArrayList();
    }

    @Override
    public void createContact(String name, String phoneNumber, int ageN) {

        contactList.add( new Contact( name, phoneNumber, ageN ) );
    }

    @Override
    public void removeContact(String name) {

    }

    @Override
    public void showContacts() {

    }


    public ObservableList<Contact> showAllContacts() {
        return contactList;
//        for (Contact contact : this.contactList.values()) {
//            System.out.println(contact);
//        }
    }

    @Override
    public void editContact(String oldName, String name, String phoneNumber, int Age) {

    }



    public void deleteContact(String Name) {
        // this.contactList.remove(Name);
    }


    }




        // public void editContact(String oldSurname, String newSurname, String newName, String newPhoneNumber, int newAge) {

//        Contact contact = this.contactList.get(oldSurname);
//
//        if (!newSurname.equals("")) {
//            contact.setSurname(newSurname);
//        }
//        if (!newName.equals("")) {
//            contact.setName(newName);
//        }
//        if (!newPhoneNumber.equals("")) {
//            contact.setPhoneNumber(newPhoneNumber);
//        }
//        try {
//            if (newAge != 0) {
//                contact.setAge(newAge);
//            }
//        } catch (NumberFormatException e) {
//            System.out.println(" Enter zero ");
//        }
//
//
//        contactList.remove(oldSurname);
//        contactList.add(newSurname, contact);
//    }





