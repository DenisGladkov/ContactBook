package com.gladkov.javaphonebook.services;

import com.gladkov.javaphonebook.model.Contact;
import javafx.collections.ObservableList;

import java.io.IOException;

public interface ContactService {

    /**
     * Сервис бизнес логики который описывает основные действия над доменными моделями - Контактами.
     */


    void createContact(String name, String phoneNumber, int ageN);

    void removeContact(String name);

   void showContacts();

    void editContact(String oldName, String name, String phoneNumber, int Age);

}