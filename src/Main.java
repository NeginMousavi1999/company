import model.Employee;
import service.EmployeeService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Negin Mousavi
 */
public class Main {
    static EmployeeService employeeService;

    static {
        try {
            employeeService = new EmployeeService();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        showResults();
    }

    private static void showResults() throws SQLException {
        List<Employee> allEmployees = sortEmployeesBySalary(employeeService.readSortedEmployeesByEntryYear());

        List<Integer> years = employeeService.returnUniqueEntryYearOfLastFiveYears();

        for (Integer year : years) {
            List<Employee> employeesWithThisYear = returnEmployeesWithSpecificEntryYear(allEmployees, year);
            int maxSalary = employeesWithThisYear.get(employeesWithThisYear.size() - 1).getSalary();

            System.out.printf("------------------------- %d -------------------------\n", year);
            System.out.println("\t********** from 1 millions to 5 millions **********");
            printEmployeesInCategory(1000000, 5000000, employeesWithThisYear);
            System.out.println();
            System.out.println("\t********* from 5 millions to 10 millions **********");
            printEmployeesInCategory(5000000, 10000000, employeesWithThisYear);
            System.out.println();
            System.out.println("\t****************** more than 10 *******************");
            printEmployeesInCategory(10000000, maxSalary, employeesWithThisYear);
            System.out.println();

            printDash();
        }
    }

    private static List<Employee> sortEmployeesBySalary(List<Employee> employees) {
        Collections.sort(employees);
        return employees;
    }

    private static List<Employee> returnEmployeesWithSpecificEntryYear(List<Employee> employees, int year) {
        List<Employee> specificEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getEntryYear() == year)
                specificEmployees.add(employee);
        }
        return specificEmployees;
    }

    private static void printEmployeesInCategory(int low, int high, List<Employee> employees) {
        for (Employee employee : employees) {
            if (employee.getSalary() > low && employee.getSalary() <= high)
                System.out.println("\t" + employee);
        }
    }

    private static void printDash() {
        System.out.println("--------------------------------------------------------");
    }
}
