import service.EmployeeService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Negin Mousavi
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    static EmployeeService employeeService;

    static {
        try {
            employeeService = new EmployeeService();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    public Main() throws SQLException, ClassNotFoundException {

    }

    public static void main(String[] args) throws SQLException {
        showAllEmployees();
    }

    private static void showAllElements(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    private static void showAllEmployees() throws SQLException {
        showAllElements(employeeService.returnAll());
    }
}
