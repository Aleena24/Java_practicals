import java.text.DecimalFormat;
import java.util.Scanner;

class Employee {
    private int employeeId;
    private String employeeName;
    private String designation;

    public Employee(int employeeId, String employeeName, String designation) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.designation = designation;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double calculateBonus() {
        // Default bonus calculation (can be overridden in subclasses)
        return 0.0;
    }

    public double calculateWeeklySalary() {
        // Default weekly salary calculation (can be overridden in subclasses)
        return 0.0;
    }

    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Designation: " + designation);
    }

    public double calculateAnnualEarnings() {
        return 0;
    }
}

class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public HourlyEmployee(int employeeId, String employeeName, String designation, double hourlyRate, int hoursWorked) {
        super(employeeId, employeeName, designation);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

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
    public void displayEmployeeDetails() {
        super.displayEmployeeDetails();
        System.out.println("Hourly Rate: " + hourlyRate);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Weekly Salary: " + formatCurrency(calculateWeeklySalary()));
    }

    @Override
    public double calculateBonus() {
        // Hourly employees may not have a bonus, so default to 0.0
        return 0.0;
    }

    private String formatCurrency(double amount) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return "$" + df.format(amount);
    }

    public void displayInfo() {
    }

    public String calculateAnnualEarnings() {
        return null;
    }
}

class SalariedEmployee extends Employee {
    private double monthlySalary;

    public SalariedEmployee(int employeeId, String employeeName, String designation, double monthlySalary) {
        super(employeeId, employeeName, designation);
        this.monthlySalary = monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateWeeklySalary() {
        return monthlySalary / 4;
    }

    @Override
    public void displayEmployeeDetails() {
        super.displayEmployeeDetails();
        System.out.println("Monthly Salary: " + formatCurrency(monthlySalary));
        System.out.println("Weekly Salary: " + formatCurrency(calculateWeeklySalary()));
    }

    protected String formatCurrency(double monthlySalary2) {
        return null;
    }

    @Override
    public double calculateBonus() {
        // Default bonus calculation for salaried employees (can be overridden in subclasses)
        return 0.05 * monthlySalary; // 5% of monthly salary as bonus
    }

    public void displayInfo() {
    }

    public String calculateAnnualEarnings() {
        return null;
    }
}

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
        System.out.println("Bonus Amount: " + formatCurrency(calculateBonus()));
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Collect data for HourlyEmployee
        System.out.println("Enter details for Hourly Employee:");
        System.out.print("Employee ID: ");
        int hourlyEmployeeId = scanner.nextInt();
        System.out.print("Employee Name: ");
        scanner.nextLine(); // Consume newline left by previous nextInt()
        String hourlyEmployeeName = scanner.nextLine();
        System.out.print("Designation: ");
        String hourlyEmployeeDesignation = scanner.nextLine();
        System.out.print("Hourly Rate: ");
        double hourlyRate = scanner.nextDouble();
        System.out.print("Hours Worked: ");
        int hoursWorked = scanner.nextInt();

        HourlyEmployee hourlyEmployee = new HourlyEmployee(hourlyEmployeeId, hourlyEmployeeName, hourlyEmployeeDesignation, hourlyRate, hoursWorked);

        // Collect data for SalariedEmployee
        System.out.println("\nEnter details for Salaried Employee:");
        System.out.print("Employee ID: ");
        int salariedEmployeeId = scanner.nextInt();
        System.out.print("Employee Name: ");
        scanner.nextLine(); // Consume newline left by previous nextInt()
        String salariedEmployeeName = scanner.nextLine();
        System.out.print("Designation: ");
        String salariedEmployeeDesignation = scanner.nextLine();
        System.out.print("Monthly Salary: ");
        double monthlySalary = scanner.nextDouble();

        SalariedEmployee salariedEmployee = new SalariedEmployee(salariedEmployeeId, salariedEmployeeName, salariedEmployeeDesignation, monthlySalary);

        // Collect data for ExecutiveEmployee
        System.out.println("\nEnter details for Executive Employee:");
        System.out.print("Employee ID: ");
        int executiveEmployeeId = scanner.nextInt();
        System.out.print("Employee Name: ");
        scanner.nextLine(); // Consume newline left by previous nextInt()
        String executiveEmployeeName = scanner.nextLine();
        System.out.print("Designation: ");
        String executiveEmployeeDesignation = scanner.nextLine();
        System.out.print("Monthly Salary: ");
        double executiveMonthlySalary = scanner.nextDouble();
        System.out.print("Bonus Percentage: ");
        double bonusPercentage = scanner.nextDouble();

        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee(executiveEmployeeId, executiveEmployeeName, executiveEmployeeDesignation, executiveMonthlySalary, bonusPercentage);

        scanner.nextLine();
        // Close the scanner
        scanner.close();
       

        System.out.println("Hourly Employee Details:");
        hourlyEmployee.displayEmployeeDetails();
        System.out.println();

        System.out.println("Salaried Employee Details:");
        salariedEmployee.displayEmployeeDetails();
        System.out.println();

        System.out.println("Executive Employee Details:");
        executiveEmployee.displayEmployeeDetails();
    }
}
