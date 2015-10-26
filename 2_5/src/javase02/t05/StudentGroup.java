package javase02.t05;

import java.util.HashMap;

import java.util.Map;
import static java.lang.System.out;

/**
 * Created by akulakov on 23.10.2015.
 */
public class StudentGroup <T> {
    private Discipline discipline;
    private Map<Student, T> students;
    private boolean isDouble;

    public StudentGroup(Discipline discipline, boolean isDouble) {
        this.discipline = discipline;
        this.isDouble = isDouble;
 //       if( this.isDouble )
   //         students = new HashMap<Student, double>();
  //      else
  //          students = new HashMap<Student, int>();
        students = new HashMap<Student, T>();
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public T getStudentMark(Student student) {
        return students.get(student);
    }

    public void addStudent(Student student, T mark) {
        students.put(student,mark);
    }


    public void showStudents() {
        out.println("Group " + discipline + " includes:");
        for( Map.Entry<Student,T> entry : students.entrySet() )
            out.println( entry.getKey() + " " + entry.getValue() );
    }

    public boolean isContain(Student student) {
        return students.containsKey(student);
    }
}
