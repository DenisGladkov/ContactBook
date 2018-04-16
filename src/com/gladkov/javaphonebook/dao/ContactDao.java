package com.gladkov.javaphonebook.dao;

import com.gladkov.javaphonebook.model.Contact;

public interface ContactDao {

    /**
     * Интерфейс описывающий основное поведение работы с различными вариантами долгострочного хранения данных.
     * (файловая система, БД и т.д.)
     */

    void saveContact(Contact contact);

    void removeContact();

    void showAll();
}