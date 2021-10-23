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

    public List<Employee> readAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        if (connection != null) {
            String sql = "SELECT * FROM employees;";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                employees.add(create(resultSet));
        }
        return employees;
    }

    private Employee create(ResultSet resultSet) throws SQLException {
        return new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                resultSet.getInt(4), resultSet.getInt(5), resultSet.getDouble(6));
    }

}
