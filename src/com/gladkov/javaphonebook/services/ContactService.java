package com.gladkov.javaphonebook.services;

public interface ContactService {

    /**
     * Сервис бизнес логики который описывает основные действия над доменными моделями - Контактами.
     */

    void createContact(String name, int phone);

    void deleteContact(String name);

    void showContacts();

    void editContact(String oldName, String newName, int newAge);

}