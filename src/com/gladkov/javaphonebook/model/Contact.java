package com.gladkov.javaphonebook.model;

public class Contact {

    /**
     * Класс модель.
     * Этот класс представляет основные сущности и хранимый тип данных.
     * Это логические сущности которые управляются слоем сервисов бизнес логики.
     */

    private String name;
    private String phoneNumber;
    private int age;

    public Contact(String name, String phoneNumber, Integer age) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age= this.age;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return  name + ":" + age + ":" +phoneNumber;
    }
}