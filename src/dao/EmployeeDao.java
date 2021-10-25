package dao;

import model.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Negin Mousavi
 */
public class EmployeeDao extends BaseDao {
    public EmployeeDao() throws ClassNotFoundException, SQLException {
    }

/*    public List<Employee> readAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT * FROM employees;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                employees.add(create(resultSet));
        }
        return employees;
    }*/

    private Employee create(ResultSet resultSet) throws SQLException {
        return new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                resultSet.getInt(4), resultSet.getInt(5), resultSet.getDouble(6));
    }

    public List<Integer> findAllUniqueEntryYear() throws SQLException {
        List<Integer> years = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT DISTINCT entry_year from employees";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                years.add(resultSet.getInt(1));
        }
        return years;
    }

    public List<List<Employee>> returnAllEmployeesGroupByEntryYear() throws SQLException {
        List<Integer> years = findAllUniqueEntryYear();
        List<List<Employee>> listOfEmployeesGroupByEntryYear = new ArrayList<>();
        if (connection != null) {
            for (Integer year : years) {
                List<Employee> employees = new ArrayList<>();
                String sql = "SELECT * FROM employees WHERE entry_year=? ORDER BY salary;";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, year);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next())
                    employees.add(create(resultSet));
                listOfEmployeesGroupByEntryYear.add(employees);
            }
        }
        return listOfEmployeesGroupByEntryYear;
    }
}
