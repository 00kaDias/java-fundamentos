package app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.Student;

public class Program {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Ana", 8.5));
        students.add(new Student("Carlos", 6.0));
        students.add(new Student("Bia", 9.0));

        Collections.sort(students);
        for(Student sdt : students) {
            System.out.println(sdt.getName() + ", " + sdt.getGrade());
        }
    }

}