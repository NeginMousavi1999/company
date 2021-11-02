package service;

import dao.EmployeeDao;
import model.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Negin Mousavi
 */
public class EmployeeService {
    EmployeeDao employeeDao = new EmployeeDao();
    int nowYear = 1400;

    public EmployeeService() throws SQLException, ClassNotFoundException {
    }

    public List<Employee> readSortedEmployeesByEntryYear() throws SQLException {
        return employeeDao.readAllSortedByEntryYear();
    }

    public List<Integer> returnUniqueEntryYearOfLastFiveYears() throws SQLException {
        return employeeDao.findAllUniqueEntryYear(nowYear, 5);
    }

}
