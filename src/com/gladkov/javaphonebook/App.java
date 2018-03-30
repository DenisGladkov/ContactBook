package com.gladkov.javaphonebook;

import java.io.IOException;

import com.gladkov.javaphonebook.services.impl.ContactServiceImpl;
import com.gladkov.javaphonebook.view.CmdLineService;
import com.gladkov.javaphonebook.view.impl.CmdLineServiceImpl;

public class App {

    public static void main(String[] args) throws IOException {
        CmdLineService cmd = new CmdLineServiceImpl(new ContactServiceImpl());
        cmd.runMenu();
    }
}