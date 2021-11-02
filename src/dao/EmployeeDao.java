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

    public List<Employee> readAllSortedByEntryYear() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT * FROM employees ORDER BY entry_year;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                employees.add(create(resultSet));
        }
        return employees;
    }

    private Employee create(ResultSet resultSet) throws SQLException {
        return new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                resultSet.getInt(4), resultSet.getInt(5), resultSet.getInt(6));
    }

    public List<Integer> findAllUniqueEntryYear(int now, int from) throws SQLException {
        List<Integer> years = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT DISTINCT entry_year from employees WHERE entry_year>?-?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, now);
            preparedStatement.setInt(2, from);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                years.add(resultSet.getInt(1));
        }
        return years;
    }
}
