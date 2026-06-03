package Student;

import java.util.List;

public class Student {

    private String name;
    private char group;
    private int course;
    private List<Integer> grades;

    public Student(String name, char group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public double getAverageGrade() {
        int sum = 0;

        for (Integer grade : grades) {
            sum += grade;
        }

        return (double) sum / grades.size();
    }

    public void nextCourse() {
        if (getAverageGrade() >= 3) {
            course++;
        }
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Имя студента: " + name +
                ", группа: " + group +
                ", курс: " + course +
                ", средний балл: " + getAverageGrade();
    }
}

