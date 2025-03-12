package Main;
import Main.Models.Employee;
import Main.Models.Services.Impl.EmployeeArrayList;
import Main.Models.Employee;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeArrayList employee = new EmployeeArrayList();

        while(true){
            System.out.println("\n-----Employee Management System-----");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee by Email or Contact");
            System.out.println("3. Search Employee by Email, Contact, or Name");
            System.out.println("4. Display All Employees");
            System.out.println("5. Generate Salary Slip by Email or Contact");
            System.out.println("6. Update Employee Salary by Email or Contact");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Contact: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter Province: ");
                    String province = scanner.nextLine();

                    employee.addEmployee(new Employee(name, email, address, contact, salary, province));
                    break;

                case 2:
                    System.out.print("Enter Email or Contact of Employee to Remove: ");
                    String identifier = scanner.nextLine();
                    employee.removeEmployee(identifier);
                    break;

                case 3:
                    System.out.print("Enter Email, Contact, or Name to Search: ");
                    String searchKey = scanner.nextLine();
                    Employee foundEmployee = employee.searchEmployees(searchKey);
                    if (foundEmployee != null) {
                        System.out.println("Employee Found: " + foundEmployee.getName());
                    } else {
                        System.out.println("Employee Not Found.");
                    }
                    break;

                case 4:
                    employee.displayAllEmployees();
                    break;

                case 5:
                    System.out.println("Enter email or contact for salary Slip: ");
                    String SalaryEmployee = scanner.nextLine();
                    employee.generateSalarySLip(SalaryEmployee);
                    break;

                case 6:
                    System.out.println("Enter Email or contact to update the salary: ");
                    String UpdateSalary = scanner.nextLine();
                    System.out.println("Enter the new salary to update: ");
                    double newSalary = scanner.nextDouble();
                    employee.updateSalary(UpdateSalary, newSalary);
                    break;

                case 7:
                    System.out.println("Thank you for using our system...Bye....");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice. Please Try Again.");
            }
        }
    }
}