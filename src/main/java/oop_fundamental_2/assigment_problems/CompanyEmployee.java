
package oop_fundamental_2.assigment_problems;

public class CompanyEmployee {

    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {

        CompanyEmployee employee1 = new CompanyEmployee("Divya", 65000);
        CompanyEmployee employee2 = new CompanyEmployee("Arjun", 55000);
        CompanyEmployee employee3 = new CompanyEmployee("Priya", 60000);

        CompanyEmployee.printCompanyInfo();
    }
}