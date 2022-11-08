package Main.EmployeeManagementExercise;
import Main.EmployeeManagementExercise.Base.Employee;

import java.text.NumberFormat;
import java.util.regex.Matcher;

public class EmployeeManagement {
    private final String employees = """
                Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
                Rubble, Barney, 2/2/1905, Manager, {orgSize=500,dr=10}
                Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=5}
                Rubble, Betty, 4/4/1915, CEO, {avgStockPrice=300}
                """;

    public int getEmployeeSalary()
    {
        Matcher employeeMatcher = Employee.PEOPLE_PATTERN.matcher(employees);
        int totalSalaries = 0;
        Employee employee = null;
        while (employeeMatcher.find()) {
            EmployeeFactory employeeFactory = new EmployeeFactory();
            employee = employeeFactory.CreateEmployee(employeeMatcher.group());
            if (employee != null) {
                totalSalaries += employee.getSalary();
            }
        }

        System.out.println(NumberFormat.getCurrencyInstance().format(totalSalaries));
        return totalSalaries;
    }
}
