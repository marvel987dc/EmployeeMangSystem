package Main.Models;

public class Employee {
     String name;
     String email;
     String address;
     String contact;
     double salary;
     String province;

    //constructor to initialize the variables
    public Employee(String name, String email, String address, String contact,double salary, String province ){
        this.name = name;
        this.email = email;
        this.address = address;
        this.contact = contact;
        this.salary = salary;
        this.province = province;
    }

    //getters and setters to access and modify the values attributes.
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public double getSalary() { return salary; }

    public String getProvince() {
        return province;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setSalary(double salary) { this.salary = salary; }

    public void setProvince(String province) {
        this.province = province;
    }

    public void display(){
        System.out.println("Name: " + name + ", Email: " + email + ", Contact: " + contact +
                ", Address: " + address + ", Salary: " + salary + ", province: " + province);
    }

}



