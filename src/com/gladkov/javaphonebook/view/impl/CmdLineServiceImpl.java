package com.gladkov.javaphonebook.view.impl;

import com.gladkov.javaphonebook.services.ContactService;
import com.gladkov.javaphonebook.view.CmdLineService;

public class CmdLineServiceImpl implements CmdLineService {

    private ContactService contactService;

    public CmdLineServiceImpl(ContactService contactService) {
        this.contactService = contactService;
    }

    @Override
    public void showMenu() {
        System.out.println("Menu");
    }
}