/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semesterproject.universitymanagementsystem;

/**
 *
 * @author user
 */
// University.java
// Base class demonstrating Encapsulation and Inheritance

public class University implements Displayable {
    private String uniName;

    public University(String uniName) {
        this.uniName = uniName;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    @Override
    public void displayInfo() {
        System.out.println("University Name: " + uniName);
    }
}
