package semesterproject.universitymanagementsystem;

public class Department extends University {
    private String deptName;

    
    public Department(String uniName, String deptName) {
        super(uniName, "Unknown");
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
        System.out.println("Department: " + deptName);
    }
}
