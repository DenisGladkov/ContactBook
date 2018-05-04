package com.gladkov.javaphonebook.dao;

import com.gladkov.javaphonebook.model.Contact;

import java.io.IOException;
import java.util.List;

public interface ContactDao {

    /**
     * Интерфейс описывающий основное поведение работы с различными вариантами долгострочного хранения данных.
     * (файловая система, БД и т.д.)
     */

    void saveContact(Contact contact);

    public void removeContact(int id);

    public void editContact(Contact contact);

    List<Contact> showAll();
}