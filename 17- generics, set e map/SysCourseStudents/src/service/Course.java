package service;

import java.util.HashSet;
import java.util.Set;

import entities.Student;

public class Course {
    public Set<Student> totalStudents(Set<Student> courseA, Set<Student> courseB, Set<Student> courseC) {
        Set<Student> all = new HashSet<>();
        all.addAll(courseA);
        all.addAll(courseB);
        all.addAll(courseC);
        return all;

    }
}
