package Main.EmployeeManagementExercise.Base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Employee {
    private static final String EMPLOYEE_REGEX = "(?<lastName>\\w+),\\s*(?<firstName>\\w+),\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4}),\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?\\n";
    protected String firstName;
    protected String lastName;
    protected final Matcher peopleMatcher;
    public static Pattern PEOPLE_PATTERN = Pattern.compile(EMPLOYEE_REGEX);

    protected Employee()
    {
        this.peopleMatcher = null;
    }
    public Employee(String text) {
        peopleMatcher = Employee.PEOPLE_PATTERN.matcher(text);
        if (peopleMatcher.find())
        {
            this.firstName = peopleMatcher.group("firstName");
            this.lastName = peopleMatcher.group("lastName");
        }
    }

    public abstract int getSalary();

    public String getEmployeeFullName()
    {
        return this.firstName + " " + this.lastName;
    }

    public static final class DummyEmployee extends Employee{
        @Override
        public int getSalary() {
            return 0;
        }
    }
}
