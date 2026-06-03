package Student;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Student> students = new HashSet<>();

        students.add(new Student(
                "Alisa",
                'A',
                1,
                Arrays.asList(5, 4, 5, 4, 5)
        ));

        students.add(new Student(
                "Stas",
                'B',
                2,
                Arrays.asList(2, 2, 3, 2, 2)
        ));

        students.add(new Student(
                "Anna",
                'C',
                3,
                Arrays.asList(5, 5, 5, 4, 5)
        ));

        students.add(new Student(
                "Victor",
                'A',
                4,
                Arrays.asList(3, 3, 3, 3, 3)
        ));

        System.out.println("Все студенты:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\nСтуденты с баллом < 3:");
        printBadStudents(students);

        removeStudents(students);

        for (Student student : students) {
            student.nextCourse();
        }

        System.out.println("\nПеревод студентов на следующий курс:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("\nСтуденты по курсам:");
        for (int i = 1; i <= 5; i++) {
            printStudents(students, i);
        }
    }

    private static void printBadStudents(Set<Student> students) {

        for (Student student : students) {
            if (student.getAverageGrade() < 3) {
                System.out.println(student);
            }
        }
    }

    public static Set<Student> getRemovedStudents(Set<Student> students) {

        Set<Student> removed = new HashSet<>();

        for (Student student : students) {
            if (student.getAverageGrade() < 3) {
                removed.add(student);
            }
        }

        return removed;
    }

    public static void removeStudents(Set<Student> students) {

        students.removeIf(student -> student.getAverageGrade() < 3);
    }

    public static void printStudents(Set<Student> students, int course) {

        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName() + ", курс " + student.getCourse());;
            }
        }
    }



}

