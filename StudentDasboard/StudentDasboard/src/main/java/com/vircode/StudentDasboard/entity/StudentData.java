package com.vircode.StudentDasboard.entity;

// so this class is specifically made for only name and address output
//  if the dao prints the whole id and subjects of the students too.
// made separate class to, /students/allStudents only shows name and address

public class StudentData {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public StudentData(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
