package EmployeeManagementExercise.Models;
import EmployeeManagementExercise.Base.Employee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Analyst extends Employee {
    private final int baseSalary = 2500;
    private final String analystRegex = "\\w+=(?<projectCount>\\w+)";
    private Pattern analystPattern;

    public Analyst(String text) {
        super(text);
        this.analystPattern = Pattern.compile(analystRegex);
    }

    @Override
    public int getSalary() {
        int salary;
        String details = peopleMatcher.group("details");
        Matcher analystMatcher = analystPattern.matcher(details);
        if(analystMatcher.find())
        {
            int projectCount = Integer.parseInt(analystMatcher.group("projectCount"));
            System.out.printf("projectCount: %s%n", projectCount);
            salary = baseSalary + projectCount * 2;
        }
        else {
            salary = baseSalary;
        }
        return salary;
    }
}
