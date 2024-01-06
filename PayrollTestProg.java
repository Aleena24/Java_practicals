public class PayrollTestProg {
    public static void main(String[] args) {
        // Instantiate objects of each employee type
        HourlyEmployee hourlyEmployee = new HourlyEmployee(101, "Aleena", "Designer", 15.0, 20);
        SalariedEmployee salariedEmployee = new SalariedEmployee(202, "Aljo", "Accoutant", 5000.0);
        ExecutiveEmployee executiveEmployee = new ExecutiveEmployee(303, "Anjalo", "Medical Engineer", 8000.0, 15.0);

        // Set attributes for HourlyEmployee
        hourlyEmployee.setEmployeeId(101);
        hourlyEmployee.setEmployeeName("Aleena");
        hourlyEmployee.setDesignation("Designer");
        hourlyEmployee.setHourlyRate(15.0);
        hourlyEmployee.setHoursWorked(20);

        // Set attributes for SalariedEmployee
        salariedEmployee.setEmployeeId(202);
        salariedEmployee.setEmployeeName("Aljo");
        salariedEmployee.setDesignation("Accoutant");
        salariedEmployee.setMonthlySalary(5000.0);

        // Set attributes for ExecutiveEmployee
        executiveEmployee.setEmployeeId(303);
        executiveEmployee.setEmployeeName("Anjalo");
        executiveEmployee.setDesignation("Medical Engineer");
        executiveEmployee.setMonthlySalary(8000.0);
        executiveEmployee.setBonusPercentage(15.0);

        // Display detailed information for each employee
        System.out.println("Hourly Employee Details:");
        hourlyEmployee.displayInfo();
        System.out.println("Bonus: " + hourlyEmployee.calculateBonus());
        System.out.println("Annual Earnings: " + hourlyEmployee.calculateAnnualEarnings());
        System.out.println();

        System.out.println("Salaried Employee Details:");
        salariedEmployee.displayInfo();
        System.out.println("Bonus: " + salariedEmployee.calculateBonus());
        System.out.println("Annual Earnings: " + salariedEmployee.calculateAnnualEarnings());
        System.out.println();

        System.out.println("Executive Employee Details:");
        executiveEmployee.displayInfo();
        System.out.println("Bonus: " + executiveEmployee.calculateBonus());
        System.out.println("Annual Earnings: " + executiveEmployee.calculateAnnualEarnings());
        System.out.println();

        // Display total payroll
        double totalPayroll = calculateTotalPayroll(hourlyEmployee, salariedEmployee, executiveEmployee);
        System.out.println("Total Payroll: " + totalPayroll);
    }

    // Calculate total payroll for all employees
    private static double calculateTotalPayroll(Employee... employees) {
        double totalPayroll = 0;
        for (Employee employee : employees) {
            totalPayroll += employee.calculateAnnualEarnings();
        }
        return totalPayroll;
    }
}
