package model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Negin Mousavi
 */
@Setter
@Getter
public class Employee extends Person implements Comparable<Employee> {
    private int entryYear;
    private double salary;

    public Employee(int id, String personalCode, String fullName, int birthYear, int entryYear, double salary) {
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
    public int compareTo(Employee o) {
        if (this.entryYear == o.entryYear)
            return Double.compare(this.salary, o.salary);
        else if (this.entryYear < o.entryYear)
            return 1;
        else return -1;
    }
}
