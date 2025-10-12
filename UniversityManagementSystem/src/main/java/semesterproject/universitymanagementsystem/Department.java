/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semesterproject.universitymanagementsystem;

public class Department extends University {
    private String deptName;

    public Department(String uniName, String deptName) {
        super(uniName);
        this.deptName = deptName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }


    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Department Name: " + deptName);
    }
}