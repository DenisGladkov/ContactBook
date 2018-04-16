package com.gladkov.javaphonebook;

import java.io.IOException;

import com.gladkov.javaphonebook.dao.ContactDao;
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

        //Создание самого нижнего слоя сервисов  - слой DAO который работает со средствами долгосрочноого хранения информации.
        ContactDao contactDao = new FileSystemContactDaoImpl();


        //Создание слоя срвисов, которые хранят бизнесс логику. Логику управления моделями и т.д.
        //Обычно эти сервисы используют слой DAO для долгосрочного хранения данных.
        ContactService contactService = new FSContactServiceImpl(contactDao);

        //Создание сервисов слоя представления. Самые высокоуровневые сервиса которые управляют сервисами бизнесс логики.
        //Слой отвечающий за графический интерфейс и удобство работы Пользователя с программой
        CmdLineService cmd = new CmdLineServiceImpl(contactService);

        //Непосредственный запуск графического интерфейся и программы
        cmd.runMenu();
    }
}