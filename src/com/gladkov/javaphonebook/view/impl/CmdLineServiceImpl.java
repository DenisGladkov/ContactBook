package com.gladkov.javaphonebook.view.impl;

import com.gladkov.javaphonebook.model.Contact;
import com.gladkov.javaphonebook.services.ContactService;
import com.gladkov.javaphonebook.view.CmdLineService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdLineServiceImpl implements CmdLineService {

    private ContactService contactService;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public CmdLineServiceImpl(ContactService contactService) {
        this.contactService = contactService;
    }

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
        int ageN = readInt();
        this.contactService.createContact(name, ageN);
    }

    private void deleteContact() throws IOException {
        System.out.println("Enter name");
        String name = br.readLine();
        this.contactService.deleteContact(name);
    }

    private void showContacts() {
        this.contactService.showContacts();
    }

    private void editContact() throws IOException {

        System.out.println("Enter name of modified contact");
        String name = br.readLine();

        System.out.println("Enter name");
        String newname = br.readLine();

        System.out.println("Enter age of modified contact");
        String age = br.readLine();
        System.out.println("Enter age");
        String newage = br.readLine();
        int newa = new Integer(newage);
        this.contactService.editContact(name, newname, newa);
    }

    private int readInt() throws IOException {
        int i;
        try {
            System.out.println("Input number!");
            String line = this.br.readLine();
            i = new Integer(line);
        }
        catch (NumberFormatException ex) {
            System.out.println("Wrong Input!");
            return readInt();
        }
        return i;
    }

    private void showContact(){
        this.contactService.showContacts();
    }
}