package com.gladkov.javaphonebook.view.impl;

import com.gladkov.javaphonebook.model.Contact;
import com.gladkov.javaphonebook.services.ContactService;
import com.gladkov.javaphonebook.util.ValidationUtil;
import com.gladkov.javaphonebook.view.CmdLineService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdLineServiceImpl implements CmdLineService {

    /**
     * Сервис реализующий логику предоставления и считывания информации в/из консоль.
     */

    private final ContactService contactService;
    private final BufferedReader br;

    public CmdLineServiceImpl(ContactService contactService) {
        this.contactService = contactService;
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void runMenu() throws IOException {
        boolean exit = true;
        while (exit) {
            showMenu();
            String line = br.readLine();
            switch (line) {
                case "1": {
                    createContact();
                    break;
                }
                case "2": {
                    deleteContact();
                    break;
                }
                case "3": {
                    showContacts();
                    break;
                }
                case "4": {
                    editContact();
                    break;
                }
                case "0": {
                    exit = false;
                    break;
                }
                default:
                    System.out.println("Repeat");
            }
        }
    }

    private static void showMenu() {
        System.out.println("1. Create Contact");
        System.out.println("2. Delete Contact");
        System.out.println("3. Show Contacts");
        System.out.println("4. Edit Contact");
        System.out.println("0. Exit");
    }

    private void createContact() throws IOException {

        System.out.println("Enter name");
        String name = br.readLine();

        System.out.println("Enter age");
        int age = readInt();
        contactService.createContact(name, age);
    }

    private void deleteContact() throws IOException {
        System.out.println("Enter ID");
        int id = readInt();
        if(id > 0) {
            contactService.removeContact(id);
        } else System.out.println("Wrong input!");
    }
    }

    private void showContacts() {
        contactService.showContacts();
    }

    private void editContact() throws IOException {

        System.out.println("Enter ID");
        int id = readInt();
        if(id > 0) {
            String name = readName();
            String phoneNumber = readPhoneNumber();
            int age = readAge();
            String address = readAddress();

            if (!name.isEmpty() && !phoneNumber.isEmpty() && age >= MIN_AGE && age <= MAX_AGE ) {
                contactService.editContact(id, name, age);
            } else {
                System.out.println("Wrong input!");
            }
        } else System.out.println("Wrong input!");
    }

    private int readInt() throws IOException {
        try {
            String line = br.readLine();
            return ValidationUtil.checkNumber(line);
        } catch (NumberFormatException ex) {
            System.out.println("Wrong Input! You must input number");
            return readInt();
        }
    }
}