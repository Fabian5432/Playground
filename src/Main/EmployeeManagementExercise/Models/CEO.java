package Main.EmployeeManagementExercise.Models;

import Main.EmployeeManagementExercise.Base.Employee;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CEO extends Employee {
    private final int baseSalary = 5000;
    private final String ceoRegex = "\\w+=(?<avgStockPrice>\\w+)";
    private Pattern ceoPattern;

    public CEO(String text) {
        super(text);
        this.ceoPattern = Pattern.compile(ceoRegex);
    }

    @Override
    public int getSalary() {
        int salary;
        String details = peopleMatcher.group("details");
        Matcher ceoMatcher = ceoPattern.matcher(details);
        if(ceoMatcher.find())
        {
            int avgStockPrice = Integer.parseInt(ceoMatcher.group("avgStockPrice"));
            System.out.printf("avgStockPrice: %s%n", avgStockPrice);
            salary = baseSalary + avgStockPrice;
        }
        else {
            salary = baseSalary;
        }
        return salary;
    }
}
