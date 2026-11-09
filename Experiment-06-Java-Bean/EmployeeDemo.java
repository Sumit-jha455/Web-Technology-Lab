public class EmployeeDemo {

    public static void main(String[] args) {

        // Create EmployeeBean Object

        EmployeeBean employee = new EmployeeBean();

        // Set Employee Information

        employee.setEmpID(101);

        employee.setName("Sumit Kumar Jha");

        employee.setSalary(55000.00);

        employee.setDesignation("Software Developer");

        employee.setDepartment("Information Technology");

        // Display Employee Information

        System.out.println("====================================");

        System.out.println("       EMPLOYEE INFORMATION         ");

        System.out.println("====================================");

        System.out.println("Employee ID : " + employee.getEmpID());

        System.out.println("Name        : " + employee.getName());

        System.out.println("Salary      : " + employee.getSalary());

        System.out.println("Designation : " + employee.getDesignation());

        System.out.println("Department  : " + employee.getDepartment());

        System.out.println("====================================");
    }
}