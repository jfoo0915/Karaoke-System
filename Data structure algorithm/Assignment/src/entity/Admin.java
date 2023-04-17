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
public class Admin extends User {

    private static int nextId = 1000;
    private int adminId;
    private int password;

    public Admin() {
        this.adminId = nextId;
        nextId++;
    }

    public Admin(String name, char gender, String contactNo, int password) {
        super(name, gender, contactNo);
        this.adminId = nextId;
        this.password = password;
    }

    public Admin(int memberId, String name, char gender, String contactNo, int password) {
        super(name, gender, contactNo);
        this.adminId = memberId;
        this.password = password;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Admin.nextId = nextId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return this.getAdminId() == ((Admin) obj).getAdminId();
    }

    @Override
    public String toString() {
        return ("Admin ID:" + adminId + super.toString() + "Password: " + password);
    }

}
