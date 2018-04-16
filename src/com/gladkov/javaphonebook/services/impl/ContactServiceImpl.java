package com.gladkov.javaphonebook.services.impl;


import java.util.HashMap;
import java.util.Map;

import com.gladkov.javaphonebook.model.Contact;
import com.gladkov.javaphonebook.services.ContactService;

    public class ContactServiceImpl implements ContactService {

        /**
         * Реализация ContactService которая использует Map для хранения данных.
         */

        private final Map<String, Contact> contactList;


        public ContactServiceImpl() {
            this.contactList = new HashMap<>();
        }

        @Override
        public void createContact(String name, int phone) {
            contactList.put(name, new Contact(name, phone));
        }

        @Override
        public void deleteContact(String name) {
            contactList.remove(name);
        }

        @Override
        public void showContacts() {
            for (Contact contact : contactList.values()) {
                System.out.println(contact);
            }
        }

        @Override
        public void editContact(String name, String newName, int newAge) {
            Contact contact = contactList.get(name);
            contact.setName(newName);
            contact.setAge(newAge);
        }
    }


