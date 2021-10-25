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

    public EmployeeService() throws SQLException, ClassNotFoundException {
    }

    public List<Employee> readSortedEmployees() throws SQLException {
        return employeeDao.readAllSortedByEntryYear();
    }

    public List<Integer> returnUniqueEntryYear() throws SQLException {
        return employeeDao.findAllUniqueEntryYear();
    }

}
