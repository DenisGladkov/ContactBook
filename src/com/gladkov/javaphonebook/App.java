package com.gladkov.javaphonebook;

import java.io.IOException;

import com.gladkov.javaphonebook.dao.ContactDao;
import com.gladkov.javaphonebook.dao.impl.DBContactDao;
import com.gladkov.javaphonebook.dao.impl.FileSystemContactDaoImpl;
import com.gladkov.javaphonebook.services.ContactService;
import com.gladkov.javaphonebook.services.impl.ContactServiceImpl;
import com.gladkov.javaphonebook.services.impl.FSContactServiceImpl;
import com.gladkov.javaphonebook.view.CmdLineService;
import com.gladkov.javaphonebook.view.impl.CmdLineServiceImpl;

public class App {

    /**
     * Начало программы. Тут запускается программа, создаются все сервиса и устанавливаются связи между ними.
     */

    public static void main(String[] args) throws IOException {

        ContactDao contactDao = new DBContactDao();

        ContactService contactService = new FSContactServiceImpl(contactDao);

        CmdLineService cmd = new CmdLineServiceImpl(contactService);

        cmd.runMenu();
    }
}