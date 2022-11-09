package EmployeeManagementExercise;

import EmployeeManagementExercise.Base.Employee;
import EmployeeManagementExercise.Models.Analyst;
import EmployeeManagementExercise.Models.CEO;
import EmployeeManagementExercise.Models.Manager;
import EmployeeManagementExercise.Models.Programmer;


import java.util.regex.Matcher;

public class EmployeeFactory {
    public Employee CreateEmployee(String text)
    {
        Matcher employeeMatcher = Employee.PEOPLE_PATTERN.matcher(text);
        if (employeeMatcher.find())
        {
            return switch (employeeMatcher.group("role"))
                    {
                        case "Programmer" -> new Programmer(text);
                        case "Manager" -> new Manager(text);
                        case "Analyst" -> new Analyst(text);
                        case "CEO" -> new CEO(text);
                        default -> new Employee.DummyEmployee();
                    };
        }
        else {
            return new Employee.DummyEmployee();
        }
    }
}
