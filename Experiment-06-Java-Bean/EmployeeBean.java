import java.io.Serializable;

public class EmployeeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    // Private Data Members

    private int empID;
    private String name;
    private double salary;
    private String designation;
    private String department;

    // Default Constructor

    public EmployeeBean() {
    }

    // Getter and Setter for Employee ID

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    // Getter and Setter for Name

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for Salary

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Getter and Setter for Designation

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    // Getter and Setter for Department

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}