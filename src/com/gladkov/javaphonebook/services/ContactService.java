package com.gladkov.javaphonebook.services;

import com.gladkov.javaphonebook.model.Contact;
import javafx.collections.ObservableList;

import java.io.IOException;

public interface ContactService {

    /**
     * Сервис бизнес логики который описывает основные действия над доменными моделями - Контактами.
     */

    void createContact(String name, String phoneNumber);

    public void removeContact(int id);

    ObservableList<Contact> showContacts();

    void editContact(int id, String name, String phoneNumber);

}