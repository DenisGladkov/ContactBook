package com.gladkov.javaphonebook.services.impl;

import com.gladkov.javaphonebook.dao.ContactDao;
import com.gladkov.javaphonebook.model.Contact;
import com.gladkov.javaphonebook.services.ContactService;

public class FSContactServiceImpl implements ContactService {

    /**
     * Реализация ContactService которая использует Файловую Систему для хранения данных.
     */

    private final ContactDao contactDao;

    public FSContactServiceImpl(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    public void createContact(String name, int phone) {
        contactDao.saveContact(new Contact(name, phone));
    }

    @Override
    public void deleteContact(String name) {
//		this.contactList.remove(name);
    }

    @Override
    public void showContacts() {
        contactDao.showAll();
//		for (Contact contact : this.contactList.values()) {
//			System.out.println(contact);
//		}
    }

    public void editContact(String name, String newName, int newAge) {
//		Contact contact = this.contactList.get(name);
//		contact.setName(newName);
//		contact.setAge(newAge);
    }

}
