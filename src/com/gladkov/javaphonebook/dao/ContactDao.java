package com.gladkov.javaphonebook.dao;

import com.gladkov.javaphonebook.model.Contact;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.List;

public interface ContactDao {

    /**
     * Интерфейс описывающий основное поведение работы с различными вариантами долгострочного хранения данных.
     * (файловая система, БД и т.д.)
     */

    void saveContact(Contact contact) throws IOException ;

    void removeContact(String Name);
   // void deleteContact(int id);
    //void deleteContact(String lineToRemove);

    void editContact(String oldName, Contact contact);

    List<Contact> showAll();
    ObservableList<Contact> showContacts();
}