package com.gladkov.javaphonebook;

import java.io.IOException;

import com.gladkov.javaphonebook.dao.ContactDao;
import com.gladkov.javaphonebook.dao.impl.DBContactDao;
import com.gladkov.javaphonebook.dao.impl.FileSystemContactDaoImpl;
import com.gladkov.javaphonebook.model.Contact;
import com.gladkov.javaphonebook.services.ContactService;
import com.gladkov.javaphonebook.services.impl.ContactServiceImpl;
import com.gladkov.javaphonebook.services.impl.FSContactServiceImpl;
import com.gladkov.javaphonebook.view.CmdLineService;
import com.gladkov.javaphonebook.view.impl.CmdLineServiceImpl;
import javafx.collections.ObservableList;

public class App {

    /**
     * Начало программы. Тут запускается программа, создаются все сервиса и устанавливаются связи между ними.
     */

    public static void main(String[] args) throws IOException {

        /*
        ContactDao contactDao = new DBContactDao();
        ContactService contactService = new FSContactServiceImpl(contactDao);
        CmdLineService cmd = new CmdLineServiceImpl(contactService);
        */

        ContactDao contactDao = new FileSystemContactDaoImpl() {
            @Override
            public void editContact(String oldName, Contact contact) {

            }

            @Override
            public ObservableList<Contact> showContacts() {
                return null;
            }
        };
        ContactService contactService = new ContactServiceImpl(contactDao);
        CmdLineService cmd = new CmdLineServiceImpl(contactService);
        cmd.runMenu();
    }
}