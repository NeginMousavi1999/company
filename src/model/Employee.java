package model;


import lombok.Data;

/**
 * @author Negin Mousavi
 */
@Data
public class Employee extends Person implements Comparable<Employee> {
    private int entryYear;
    private int salary;

    public Employee(int id, String personalCode, String fullName, int birthYear, int entryYear, int salary) {
        super(id, personalCode, fullName, birthYear);
        this.salary = salary;
        this.entryYear = entryYear;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                ", entryYear=" + entryYear +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee otherEmployee) {
        if (this.entryYear == otherEmployee.entryYear)
            return Double.compare(this.salary, otherEmployee.salary);
        else return Integer.compare(this.entryYear, otherEmployee.entryYear);
    }
}
