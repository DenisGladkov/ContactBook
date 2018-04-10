package com.gladkov.javaphonebook.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gladkov.javaphonebook.model.Contact;
import com.gladkov.javaphonebook.services.ContactService;

public class ContactServiceImpl implements ContactService {

    /*private List<Contact> contactList = new ArrayList<>();

    @Override
    public void createContact(String name, int age) {
        this.contactList.add(new Contact(name, age));
    }

    @Override
    public void deleteContact(String name) throws IOException{
            this.contactList.remove(name);
    }

    public void showContact() {
        System.out.println("Size of collection: "+this.contactList.size());
        for (Contact contact : this.contactList) {
            System.out.println(contact);
        }
    }*/

    private Map<String, Contact> contactList = new HashMap<>();

    @Override
    public void createContact(String name, int phone) {
        this.contactList.put(name, new Contact(name, phone));
    }

    @Override
    public void deleteContact(String name) {
        this.contactList.remove(name);
    }

    @Override
    public void showContacts() {
        for (Contact contact : this.contactList.values()) {
            System.out.println(contact);
        }
    }

    public void editContact(String name, String newName, int newAge) {
        Contact contact = this.contactList.get(name);
        contact.setName(newName);
        contact.setAge(newAge);
    }

}


