package com.gladkov.javaphonebook.dao.impl;

import com.gladkov.javaphonebook.dao.ContactDao;
import com.gladkov.javaphonebook.model.Contact;
import javafx.collections.ObservableList;
import org.h2.tools.DeleteDbFiles;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.jar.Pack200.Packer.PASS;

public class DBContactDao implements ContactDao {

    private static final String DB_URL = "jdbc:h2:tcp://localhost/~/ContactBook";
    private static final String USER = "Test";
    private static final String PASSWORD = "";

    public DBContactDao() {

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement st = connection.createStatement()) {
            st.execute("CREATE TABLE IF NOT EXISTS CONTACTBOOK (" +
                    "ID INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "NAME VARCHAR(255)," +
                    "PHONE_NUMBER VARCHAR(255)," +
                    "AGE INTEGER);");
        } catch (SQLException e) {
            System.out.println("Something went wrong while initialisation " + e);
        }
    }

    @Override
    public void saveContact(Contact contact ) {
        try (Connection connection = DriverManager
                .getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement st =
                     connection.prepareStatement("INSERT INTO CONTACTBOOK VALUES( default, ?, ?, ?);")){

            st.setString(1, contact.getName());
            st.setString(2, contact.getPhone());
            st.setInt(3, contact.getAge());

            st.execute();
        } catch (SQLException e) {
            System.out.println("boroda");
        }
    }

    @Override
    public void editContact(String oldName, Contact contact) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement st = connection
                     .prepareStatement("UPDATE CONTACTBOOK SET NAME=?, PHONE_NUMBER=?, AGE=? WHERE NAME=?")) {

            st.setString(1, contact.getName());
            st.setString(2, contact.getPhone());
            st.setInt(3, contact.getAge());
            st.setString(4, oldName);

            st.execute();
        } catch (SQLException e) {
            System.out.println("Something went wrong when updating contact " + e);
        }

    }

    @Override
    public void removeContact(String name) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement st = connection.prepareStatement("DELETE FROM CONTACTBOOK WHERE NAME=?;")) {

            st.setString(1, name);
            st.execute();
        } catch (SQLException e) {
            System.out.println("Something went wrong when removing contact" + e);
        }
    }

    @Override
    public List<Contact> showAll() {
        final List<Contact> contacts = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement st = connection.createStatement();
             ResultSet resultSet = st.executeQuery("SELECT * FROM CONTACTBOOK ORDER BY ID")) {

            while (resultSet.next()){
                final String name = resultSet.getString("NAME");
                final String phoneNumber = resultSet.getString("PHONE_NUMBER");
                final Integer age = resultSet.getInt("AGE");
                contacts.add(new Contact(name, phoneNumber, age));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong when selecting all clients " + e);
        }
        return contacts;
    }

    @Override
    public ObservableList<Contact> showContacts() {
        return null;
    }


}

