
/**
 * Main operations for the student are done here
 *
 * @author Johann Mansfield
 * @version 2/23/25
 */
public class Student {
    private String firstName;
    private String lastName;
    private int[] quizScores;

    public Student(String firstName, String lastName, int[] scores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.quizScores = scores;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getQuizScore(int quizNum) {
        return quizScores[quizNum - 1];
    }

    public void setQuizScore(int quizNum, int newScore) {
        quizScores[quizNum - 1] = newScore;
    }

    public String toString() {
        String result = String.format("%-15s", getName());
        for (int score : quizScores) {
            result += String.format("%5d", score);
        }
        return result;
    }
}



