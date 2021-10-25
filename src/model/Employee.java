package model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Negin Mousavi
 */
@Setter
@Getter
public class Employee extends Person {
    private int entryYear;
    private double salary;

/*    public Employee(String personalCode, String fullName, int birthYear, int entryYear, double salary) {
        super(personalCode, fullName, birthYear);
        this.salary = salary;
        this.entryYear = entryYear;
    }*/

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
}
