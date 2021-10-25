package model;

import lombok.Data;

/**
 * @author Negin Mousavi
 */
@Data
public class Person {
    protected int id;
    protected String personalCode;
    protected String fullName;
    protected int birthYear;

    public Person(String personalCode, String fullName, int birthYear) {
        this.personalCode = personalCode;
        this.fullName = fullName;
        this.birthYear = birthYear;
    }

    public Person(int id, String personalCode, String fullName, int birthYear) {
        this(personalCode, fullName, birthYear);
        this.id = id;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", personalCode='" + personalCode + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthYear=" + birthYear + '\''
                ;
    }
}
