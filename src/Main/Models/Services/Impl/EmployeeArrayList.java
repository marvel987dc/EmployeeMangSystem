package Main.Models.Services.Impl;

import Main.Models.Employee;
import Main.Models.Services.EmpInterface;

import java.util.ArrayList;
import java.util.List;

public class EmployeeArrayList implements EmpInterface {
  private List<Employee> employeeList;

  public EmployeeArrayList() {
      this.employeeList = new ArrayList<>();
  }

    @Override
    public void addEmployee(Employee employee) {
      employeeList.add(employee);
        System.out.println("Employee was add successfully!!");
    }

    @Override
    public boolean removeEmployee(String employeeID) {
        boolean removed = employeeList.removeIf(emp -> emp.getEmail().equals(employeeID) ||
                emp.getContact().equals(employeeID));
        if(removed){
            System.out.println("The user was successfully removed!");
        } else {
            System.out.println("User not Found");
        }
        return removed;
    }

    @Override
    public Employee searchEmployees(String employeeID) {
        for(Employee emp : employeeList){
            if(emp.getName().equalsIgnoreCase(employeeID) || emp.getEmail().equalsIgnoreCase(employeeID) || emp.getContact().equalsIgnoreCase(employeeID)){
                return emp;
            }
        }
        return null;
    }

    @Override
    public void displayAllEmployees() {
        if(employeeList.isEmpty()){
            System.out.println("There is no users here!!");
            return;
        }
        for (Employee emp : employeeList){
            emp.display();
        }
    }

    @Override
    public void generateSalarySLip(String employeeID) {
       Employee emp = searchEmployees(employeeID);
       if(emp == null){
           System.out.println("Employee not found.");
           return;
       }
       double taxRate = getTaxRate(emp.getProvince());
       double taxAmount = emp.getSalary() * taxRate / 100;
       double netSalary = emp.getSalary() - taxAmount;

        System.out.println("-------Salary Slip-------");
        System.out.println("Employee: " + emp.getName());
        System.out.println("Gross Salary: " + emp.getSalary());
        System.out.println("Tax Rate: " + emp.getProvince() + " - " + taxRate + "%");
        System.out.println("TaxDeducted: " + taxAmount);
        System.out.println("Net Salary: " + netSalary);
    }

    @Override
    public boolean updateSalary(String employeeID, double newSalary) {
        Employee emp = searchEmployees(employeeID);
        if(emp != null){
            emp.setSalary(newSalary);
            System.out.println("Salary has been updated ");
            return true;
        } else {
            System.out.println("Employee was not found");
            return false;
        }
    }

    private double getTaxRate(String province) {
        return switch (province.toLowerCase()) {
            case "ontario" -> 13.0;
            case "quebec" -> 15.0;
            case "british columbia" -> 12.0;
            case "alberta" -> 10.0;
            default -> 10.0;
        };
    }
    }

