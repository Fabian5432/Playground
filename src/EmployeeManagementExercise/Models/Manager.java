package EmployeeManagementExercise.Models;

import EmployeeManagementExercise.Base.Employee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager extends Employee {
    private final int baseSalary = 3500;
    private final String managerRegex = "\\w+=(?<orgSize>\\w+),\\w+=(?<dr>\\w+)";
    private Pattern managerPattern;

    public Manager(String text) {
        super(text);
        this.managerPattern = Pattern.compile(managerRegex);
    }

    @Override
    public int getSalary() {
        int salary;
        String details = peopleMatcher.group("details");
        Matcher managerMatcher = managerPattern.matcher(details);
        if(managerMatcher.find())
        {
            int orgSize = Integer.parseInt(managerMatcher.group("orgSize"));
            int dr = Integer.parseInt(managerMatcher.group("dr"));
            System.out.printf("orgSize: %s dir: %s%n", orgSize, dr);
            salary = baseSalary + orgSize * dr;
        }
        else {
            salary = baseSalary;
        }
        return salary;
    }
}
