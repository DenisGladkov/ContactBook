package com.gladkov.javaphonebook.dao.impl;

import com.gladkov.javaphonebook.dao.ContactDao;
import com.gladkov.javaphonebook.model.Contact;

import java.sql.*;

public class DBContactDao implements ContactDao {

    private static final String DB_URL = "jdbc:h2:tcp://localhost/~/ContactBook";
    private static final String USER = "Test";
    private static final String PASSWORD = "";

    public DBContactDao() {
        try {
            Class.forName("org.h2.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Can't connect to DB");
        }
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement st = connection.createStatement()) {
            st.execute("CREATE TABLE IF NOT  EXISTS CLIENT(ID INT AUTO_INCREMENT PRIMARY KEY, NAME VARCHAR(255), PHONENUMBER VARCHAR(255));");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveContact(String name, String phoneNumber) {
        try (Connection connection = DriverManager
                .getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement st = connection.prepareStatement("INSERT INTO CLIENT(NAME, PHONENUMBER) VALUES(?, ?);")) {

            st.setString(1, name);
            st.setString(2, phoneNumber);

            st.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void removeContact(int id) {
        try (Connection connection = DriverManager
                .getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement st =
                     connection.prepareStatement("DELETE FROM CLIENT WHERE ID = ?;")){

            st.setInt(1, id);

            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void editContact(Contact contact){
        try (Connection connection = DriverManager
                .getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement st =
                     connection.prepareStatement(
                             "UPDATE CLIENT SET NAME = ?,  AGE = ?")){

            st.setString(1, contact.getName());
            st.setString(2, contact.getPhone());

            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void showAll() {
        /*try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement st = connection.createStatement()) {
            List<Contact> clients = new ArrayList<>();
            try (ResultSet resultSet = st.executeQuery("SELECT * FROM CLIENT;")) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String phoneNumber = resultSet.getString("phoneNumber");
                    clients.add(new Contact(name, phoneNumber));
                }
            }
            return clients;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }*/
}
}

