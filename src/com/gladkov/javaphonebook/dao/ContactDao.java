package com.gladkov.javaphonebook.dao;

import com.gladkov.javaphonebook.model.Contact;

import java.util.List;

public interface ContactDao {

    /**
     * Интерфейс описывающий основное поведение работы с различными вариантами долгострочного хранения данных.
     * (файловая система, БД и т.д.)
     */

    void saveContact(Contact contact);

    void removeContact(String Name);
    void deleteContact(int id);

    void editContact(String oldName, Contact contact);

    List<Contact> showAll();
}