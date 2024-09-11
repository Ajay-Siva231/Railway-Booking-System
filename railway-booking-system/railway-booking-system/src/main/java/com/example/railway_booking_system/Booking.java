package com.example.railway_booking_system;

public class Booking {
    private static int pnrCounter = 1;
    private int pnr;
    private String name;
    private int age;
    private String sex;

    public Booking(String name, int age, String sex) {
        this.pnr = pnrCounter++;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public int getPnr() {
        return pnr;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "PNR: " + pnr + ", Name: " + name + ", Age: " + age + ", Sex: " + sex;
    }
}

