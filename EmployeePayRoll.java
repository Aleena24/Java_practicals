import java.text.DecimalFormat;
import java.util.Scanner;

//constructor
class Employee {
    private int employeeId;
    private String employeeName;
    private String designation;

    //parametrised constructor
    public Employee(int employeeId, String employeeName, String designation) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
    }

    //get methods 
    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDesignation() {
        return designation;
    }

    //set methods
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    //calculating the bonus
    public double calculateBonus() {
        return 0.0;
    }

    //calculating the weekly salary
    public double calculateWeeklySalary() {
        return 0.0;
    }

    //calulating the annual earnings
    public double calculateAnnualEarnings() {
        return 0;
    }

    //displaying the data
    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Designation: " + designation);
    }

}

//derived class Hourly Employee
//constructor
class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    //parametrised constructor
    public HourlyEmployee(int employeeId, String employeeName, String designation, double hourlyRate, int hoursWorked) {
        super(employeeId, employeeName, designation);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    //get methods
    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    //set methods
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateWeeklySalary() {
        return hourlyRate * hoursWorked;
    }

     @Override
    public double calculateBonus() {
        return 0.0;
    }
    
    public double calculateAnnualEarnings() {
        return 0;
    }

    //displaying data
    @Override
    public void displayEmployeeDetails() {
        super.displayEmployeeDetails();
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Weekly Salary: " + calculateWeeklySalary());
    }

}

//derived class Salary employee
//constructor
class SalariedEmployee extends Employee {
    private double monthlySalary;

    //parameterised constructor
    public SalariedEmployee(int employeeId, String employeeName, String designation, double monthlySalary) {
        super(employeeId, employeeName, designation);
        this.monthlySalary = monthlySalary;
    }

    //get method
    public double getMonthlySalary() {
        return monthlySalary;
    }

    //set method
    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateWeeklySalary() {
        return monthlySalary / 4;
    }
    
    @Override
    public double calculateBonus() {
        return 0.05 * monthlySalary; 
    }

       public double calculateAnnualEarnings() {
        return 0;
    }

    @Override
    public void displayEmployeeDetails() {
        super.displayEmployeeDetails();
        System.out.println("Monthly Salary: " + monthlySalary);
        System.out.println("Weekly Salary: " + calculateWeeklySalary());
    }
}

//extended class Executive employee
class ExecutiveEmployee extends SalariedEmployee {
    private double bonusPercentage;

    public ExecutiveEmployee(int employeeId, String employeeName, String designation, double monthlySalary, double bonusPercentage) {
        super(employeeId, employeeName, designation, monthlySalary);
        this.bonusPercentage = bonusPercentage;
    }

    public double getBonusPercentage() {
        return bonusPercentage;
    }

    public void setBonusPercentage(double bonusPercentage) {
        this.bonusPercentage = bonusPercentage;
    }

    @Override
    public double calculateBonus() {
        // Override bonus calculation for executive employees
        return super.calculateBonus() + (bonusPercentage / 100) * getMonthlySalary();
    }

    @Override
    public void displayEmployeeDetails() {
        super.displayEmployeeDetails();
        System.out.println("Bonus Percentage: " + bonusPercentage + "%");
        System.out.println("Bonus Amount: " + calculateBonus());
    }
}

public class EmployeePayRoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// Create an Hourly Employee
        System.out.println("Enter details for Hourly Employee:");
        System.out.print("Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Designation: ");
        String designation = scanner.nextLine();
        System.out.print("Hourly Rate: ");
        double hourlyRate = scanner.nextDouble();
        System.out.print("Hours Worked: ");
        int hoursWorked = scanner.nextInt();
        HourlyEmployee hourlyEmployee = new HourlyEmployee(id, name, designation, hourlyRate, hoursWorked);
        hourlyEmployee.displayEmployeeDetails();;
        System.out.println("Bonus: " + hourlyEmployee.calculateBonus());

        // Create a Salaried Employee
        System.out.println("\nEnter details for Salaried Employee:");
        System.out.print("Employee ID: ");
        id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Employee Name: ");
        name = scanner.nextLine();
        System.out.print("Designation: ");
        designation = scanner.nextLine();
        System.out.print("Monthly Salary: ");
        double salary = scanner.nextDouble();
        SalariedEmployee salariedEmployee = new SalariedEmployee(id, name, designation, salary);
        salariedEmployee.displayEmployeeDetails();
        System.out.println("Bonus: " + salariedEmployee.calculateBonus());

        // Create an Executive Employee
        System.out.println("\nEnter details for Executive Employee:");
        System.out.print("Employee ID: ");
        id = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Employee Name: ");
        name = scanner.nextLine();
        System.out.print("Designation: ");
        designation = scanner.nextLine();
        System.out.print("Monthly Salary: ");
        salary = scanner.nextDouble();
        System.out.print("Bonus Percentage: ");
        double bonusPercentage = scanner.nextDouble();
        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee(id, name, designation, salary, bonusPercentage);
        executiveEmployee.displayEmployeeDetails();
        System.out.println("Bonus: " + executiveEmployee.calculateBonus());
        scanner.close();
    }
}
 