package com.gladkov.javaphonebook.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.gladkov.javaphonebook.model.Contact;
import com.gladkov.javaphonebook.services.ContactService;

public class ContactServiceImpl implements ContactService {

    private List<Contact> contactList = new ArrayList<>();

    @Override
    public void createContact(String name, int age) {
        this.contactList.add(new Contact(name, age));

        for (Contact contact : this.contactList) {
            System.out.println(contact);
        }

    }

    @Override
    public void deleteContact(int index) throws IOException{


        this.contactList.remove(index);

        System.out.println("after remove: "+this.contactList.size());
        for (Contact contact : this.contactList) {
            System.out.println(contact);
        }
    }

    public void showContact() {

        System.out.println("Size of collection: "+this.contactList.size());
        for (Contact contact : this.contactList) {
            System.out.println(contact);
        }
    }
}

