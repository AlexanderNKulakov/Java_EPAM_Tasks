package javase02.t05;

import java.util.HashMap;

import java.util.Map;

/**
 * Created by akulakov on 23.10.2015.
 */
public class StudentGroup {
    private Discipline discipline;
    private Map<Student, String> students;

    public StudentGroup(Discipline discipline) {
        this.discipline = discipline;
        students = new HashMap<Student, String>();
    }

    public Map<Student, String> getStudents() {
        return students;
    }

    public void addStudent(Student student, String mark) {
        students.put(student,mark);
    }

}
