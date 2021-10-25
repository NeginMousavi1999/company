import model.Employee;
import service.EmployeeService;

import java.sql.SQLException;
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
        showResult();
    }

/*    private static void showAllElements(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    private static void showAllEmployees() throws SQLException {
        showAllElements(employeeService.returnAll());
    }*/

    private static void showResult() throws SQLException {

        List<List<Employee>> allEmployeesGroupByEntryYear = employeeService.returnAllEmployeesGroupByEntryYear();

        for (List<Employee> listOfEmployees : allEmployeesGroupByEntryYear) {
            printDash();
            Employee employeeTest = listOfEmployees.get(listOfEmployees.size() - 1);
            int entryYear = employeeTest.getEntryYear();
            System.out.printf("----------------------- %d -----------------------\n", entryYear);
            double maxSalary = employeeTest.getSalary();
            System.out.println("\t********** from 1 millions to 5 millions **********");
            printEmployee(1000000, 5000000, listOfEmployees);
            System.out.println();
            System.out.println("\t********* from 5 millions to 10 millions **********");
            printEmployee(5000000, 10000000, listOfEmployees);
            System.out.println();
            System.out.println("\t****************** more than 10 *******************");
            printEmployee(10000000, (int) maxSalary, listOfEmployees);
            System.out.println();
        }
        printDash();
    }

    private static void printEmployee(int low, int high, List<Employee> employees) {
        for (Employee employee : employees) {
            if (employee.getSalary() > low && employee.getSalary() <= high)
                System.out.println("\t" + employee);
        }
    }

    private static void printDash() {
        System.out.println("----------------------------------------------------");
    }
}
