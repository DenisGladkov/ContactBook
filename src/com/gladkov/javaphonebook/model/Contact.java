package com.gladkov.javaphonebook.model;

public class Contact {

    /**
     * Класс модель.
     * Этот класс представляет основные сущности и хранимый тип данных.
     * Это логические сущности которые управляются слоем сервисов бизнес логики.
     */

    private String name;
    private String phoneNumber;
    private int id;

    public Contact(String name, String phoneNumber, int id) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.id=id;

    }

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return id + ":" + name + ":" + phoneNumber;
    }
}