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
        boolean isRunning = true;
        while (isRunning) {
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
                    showAllContacts();
                    break;
                }
                case "4": {
                    editContact();
                    break;
                }
                case "0": {
                    isRunning = false;
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
        System.out.println("3. Show all Contacts");
        System.out.println("4. Edit Contact");
        System.out.println("0. Exit");
    }

    private void createContact() throws IOException {

        System.out.println("Enter name");
        String name = br.readLine();
        System.out.println("Enter phone number");
        String phoneNumber = br.readLine();
        System.out.println("Enter age");
        //int age = Integer.parseInt(br.readLine());
        int ageN = readInt();

        this.contactService.createContact(name, phoneNumber, ageN);
    }

    private void deleteContact() throws IOException {
        System.out.println("Enter surname in order to remove .");
        String surname = br.readLine();
        this.contactService.removeContact(surname);
    }

    private void showAllContacts() {
        System.out.println("The Contacts of the Phonebook are:");
        this.contactService.showContacts();


    }


    private void editContact() throws IOException {

        System.out.println("Enter surname of modified contact");
        String oldName = br.readLine();

        System.out.println("Enter new surname");
        String newName = br.readLine();


        System.out.println("Enter new phone");
        String newPhoneNumber = br.readLine();

        System.out.println("Enter new age");
        int newAge = readInt();
        //int newAge = Integer.parseInt(br.readLine());


        this.contactService.editContact(oldName, newName, newPhoneNumber, newAge);

    }

    private int readInt() throws IOException {
        try {
            // System.out.println("Input number!");
            String line = br.readLine();
            return ValidationUtil.checkNumber(line);
        } catch (NumberFormatException ex) {
            System.out.println("Wrong Input! You must input number");
            return readInt();
        }
    }

}