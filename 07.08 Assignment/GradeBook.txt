
/**
 * The main class where all of the operations of the gradebook are happening
 *
 * @author Johann Mansfield
 * @version 2/23/25
 */
import java.util.ArrayList;
public class GradeBook {
    private ArrayList<Student> students;

    public GradeBook() {
        students = new ArrayList<Student>();
    }

    public void addStudent(String firstName, String lastName, int[] scores) {
        students.add(new Student(firstName, lastName, scores));
    }

    public void printGradeBook() {
        System.out.println("\nGrade Book:");
        System.out.printf("%-15s %5s %5s %5s %5s\n", "Student Name", "Q1", "Q2", "Q3", "Q4");
        System.out.println("============================================");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void renameStudent(String oldName, String newFirst, String newLast) {
        for (Student s : students) {
            if (s.getName().equals(oldName)) {
                s.setName(newFirst, newLast);
                return;
            }
        }
    }

    public void updateQuizScore(String name, int quizNum, int newScore) {
        for (Student s : students) {
            if (s.getName().equals(name)) {
                s.setQuizScore(quizNum, newScore);
                return;
            }
        }
    }

    public void replaceStudent(String oldName, String newFirst, String newLast, int[] newScores) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(oldName)) {
                students.set(i, new Student(newFirst, newLast, newScores));
                return;
            }
        }
    }

    public void insertStudentBefore(String existingName, String firstName, String lastName, int[] scores) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(existingName)) {
                students.add(i, new Student(firstName, lastName, scores));
                return;
            }
        }
    }

    public void deleteStudent(String name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(name)) {
                students.remove(i);
                return;
            }
        }
    }
}


