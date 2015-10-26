package javase02.t05;

import java.util.*;

import static java.lang.System.out;

public class Main {

    public static void showStudentMarks(List<StudentGroup> listStudentGroup, Student student) {
        out.println(student);
        for(StudentGroup element:listStudentGroup)
            if( element.isContain(student) )
                out.println(" Disciplin=" + element.getDiscipline() + " mark=" + element.getStudentMark(student));

    }

    public static void main(String[] args) {

        Student student1 = new Student("Alexander","Kulakov");
        Student student2 = new Student("Sergey","Ivanov");
        Student student3 = new Student("Valery","Lagunov");
        Student student4 = new Student("Dmitry", "Peshkov");
        Student student5 = new Student("Dmitry", "Kulagin");
        Student student6 = new Student("Misha", "Izotov");

        List<StudentGroup> listStudentGroup = new ArrayList<StudentGroup>();

        StudentGroup studentGroup1 = new StudentGroup(Discipline.MATH,false);
        listStudentGroup.add(studentGroup1);

        StudentGroup studentGroup2 = new StudentGroup(Discipline.PHYSICS,true);
        listStudentGroup.add(studentGroup2);

        StudentGroup studentGroup3 = new StudentGroup(Discipline.CHEMISTRY,false);
        listStudentGroup.add(studentGroup3);

        studentGroup1.addStudent(student1, 3.3);
        studentGroup1.addStudent(student2, 4);
        studentGroup1.addStudent(student4, 5);
        studentGroup1.showStudents();
      //  out.println(studentGroup1.getType(student1));
      //  out.println(studentGroup1.getType(student2));
        out.println();


        studentGroup2.addStudent(student1, 3.4);
        studentGroup2.addStudent(student2, 4.2);
        studentGroup2.addStudent(student3, 4.2);
        studentGroup2.addStudent(student5, 3.9);
        studentGroup2.addStudent(student6, 3.9);
        studentGroup2.showStudents();
        out.println();


        studentGroup3.addStudent(student4, 3);
        studentGroup3.addStudent(student5, 5);
        studentGroup3.addStudent(student6, 5);
        studentGroup3.showStudents();
        out.println();


        out.println();
        showStudentMarks(listStudentGroup, student1);
        out.println();
        showStudentMarks(listStudentGroup, student4);
    }
}
