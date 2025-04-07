
/**
 * Contains the information of the students here and tests the gradebook and student classes
 *
 * @author Johann Mansfield
 * @version 2/23/25
 */
public class GradeBookTester {
    public static void main(String[] args) {
        GradeBook gb = new GradeBook();

        gb.addStudent("John", "Doe", new int[]{70, 80, 90, 85, 80});
        gb.addStudent("Jane", "Smith", new int[]{85, 75, 80, 90, 95});
        gb.addStudent("Alice", "Brown", new int[]{88, 92, 76, 85, 89});
        gb.addStudent("Bob", "Johnson", new int[]{60, 70, 75, 80, 85});
        gb.addStudent("Charlie", "Davis", new int[]{90, 88, 92, 85, 87});

        gb.printGradeBook();

        System.out.println("\nRenaming Jane Smith to Emily White");
        gb.renameStudent("Jane Smith", "Emily", "White");
        gb.printGradeBook();

        System.out.println("\nUpdating Emily White's Q3 score to 95");
        gb.updateQuizScore("Emily White", 3, 95);
        gb.printGradeBook();

        System.out.println("\nReplacing Alice Brown with Mark Green");
        gb.replaceStudent("Alice Brown", "Mark", "Green", new int[]{76, 85, 90, 88, 80});
        gb.printGradeBook();

        System.out.println("\nInserting Lucas Scott before Bob Johnson");
        gb.insertStudentBefore("Bob Johnson", "Lucas", "Scott", new int[]{88, 77, 85, 79, 91});
        gb.printGradeBook();

        System.out.println("\nRemoving Charlie Davis");
        gb.deleteStudent("Charlie Davis");
        gb.printGradeBook();
    }
}


