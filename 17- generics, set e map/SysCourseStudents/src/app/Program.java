package app;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.Student;
import service.Course;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How many students for Course A? ");
        int ca = sc.nextInt();
        Set<Student> courseA = getStudentCod(ca, sc);

        System.out.println("How many students for Course B? ");
        int cb = sc.nextInt();
        Set<Student> courseB = getStudentCod(cb, sc);

        System.out.println("How many students for Course C? ");
        int cc = sc.nextInt();
        Set<Student> courseC = getStudentCod(cc, sc);

        Course course = new Course();

        Set<Student> all = course.totalStudents(courseA, courseB, courseC);

        System.out.println("Total students: " + all.size());

    }

    public static Set<Student> getStudentCod(int contador, Scanner sc) {
        if (contador < 0) {
            throw new IllegalArgumentException("Without students");
        }
        Set<Student> set = new HashSet<>();
        for (int i = 0; i < contador; i++) {
            int cod = sc.nextInt();
            set.add(new Student(cod));
        }
        return set;
    }
}
