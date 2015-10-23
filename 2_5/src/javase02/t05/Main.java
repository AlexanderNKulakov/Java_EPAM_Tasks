package javase02.t05;

import java.util.Map;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
	    StudentGroup studentGroup1 = new StudentGroup(Discipline.MATH);
        StudentGroup studentGroup2 = new StudentGroup(Discipline.PHYSICS);

        studentGroup1.addStudent(new Student("Alexander","Kulakov"), "5");
        studentGroup1.addStudent(new Student("Sergey","Ivanov"), "3");
        studentGroup1.addStudent(new Student("Alexay","Petrov"), "4");

        for( Map.Entry<Student,String> entry : studentGroup1.entrySet() )
            out.println( entry.getKey() + " " + entry.getValue() );
        
    }
}
