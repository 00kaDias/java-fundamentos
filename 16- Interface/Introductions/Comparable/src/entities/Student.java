package entities;

public class Student implements Comparable<Student> {
    private String name;
    private Double grade;

    public Student(String name, Double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

@Override
public int compareTo(Student other) {
    return -grade.compareTo(other.getGrade());
}
}
