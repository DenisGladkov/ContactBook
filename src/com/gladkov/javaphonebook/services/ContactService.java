package com.gladkov.javaphonebook.services;

import java.io.IOException;

public interface ContactService {

    void createContact(String name, int age);
    void deleteContact(int index) throws IOException;
    void showContact();


}