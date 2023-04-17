/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Lim Zhen Foo
 */
public class User {

    protected String name;
    protected char gender;
    protected String contactNo;

    public User() {
    }

    public User(String name, char gender, String contactNo) {
        this.name = name;
        this.gender = gender;
        this.contactNo = contactNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString() {
        return String.format("\nName: %-20s\nGender: %1s\nContact No.: %-4s\n", name, gender, contactNo);
    }

}
