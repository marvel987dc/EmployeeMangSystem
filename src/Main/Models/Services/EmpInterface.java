package Main.Models.Services;
import Main.Models.Employee;

public interface EmpInterface {
    void addEmployee(Employee employee);
    boolean removeEmployee(String employeeID);
    Employee searchEmployees(String employeeID);
    void displayAllEmployees();
    void generateSalarySLip(String employeeID);
    boolean updateSalary(String employeeID, double newSalary);
}
