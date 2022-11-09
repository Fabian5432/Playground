import EmployeeManagementExercise.EmployeeManagement;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class EmployeeManagementTests {

    @Test
    public void ShouldReturnSalary()
    {
        EmployeeManagement employeeManagementExercise = new EmployeeManagement();
        int salary = employeeManagementExercise.getEmployeeSalary();
        assertNotNull(salary);
    }
}
