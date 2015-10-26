package javase02.t05;

import static java.lang.System.out;

/**
 * Created by akulakov on 23.10.2015.
 */
public class Student {
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
       return firstName + " " + lastName;
    }
}
