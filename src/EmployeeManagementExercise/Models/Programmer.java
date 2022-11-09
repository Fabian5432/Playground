package EmployeeManagementExercise.Models;

import EmployeeManagementExercise.Base.Employee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Programmer extends Employee {
    private final int baseSalary = 3000;
    private final String programmerRegex = "\\w+=(?<locpd>\\w+),\\w+=(?<yoe>\\w+),\\w+=(?<iq>\\w+)";
    private Pattern programmerPattern;

    public Programmer(String text) {
        super(text);
        this.programmerPattern = Pattern.compile(programmerRegex);
    }

    @Override
    public int getSalary() {
        int salary;
        String details = peopleMatcher.group("details");
        Matcher programmerMatcher = programmerPattern.matcher(details);
        if(programmerMatcher.find())
        {
            int locpd = Integer.parseInt(programmerMatcher.group("locpd"));
            int yoe = Integer.parseInt(programmerMatcher.group("yoe"));
            int iq = Integer.parseInt(programmerMatcher.group("iq"));
            System.out.printf("Employee name:%s loc:%s yoe: %s iq: %s%n", getEmployeeFullName(), locpd, yoe, iq);
            salary = baseSalary + locpd * yoe * iq;
        }
        else {
            salary = baseSalary;
        }
        return salary;
    }
}
