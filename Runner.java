import javax.swing.JOptionPane;

public class Runner {
    public static void main(String[] args) {
        String questionsInput = JOptionPane.showInputDialog("How many questions are on the exam?");
        String missedInput = JOptionPane.showInputDialog("How many questions did the student miss?");

        Exam exam;

        try {
            exam = new Exam(questionsInput, missedInput);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(1);
            return;
        }

        String message = "Each question counts " + exam.getPointsEach() + " points.\n";
        message += "The exam score is " + exam.getScore() + "\n";
        message += "The exam grade is " + exam.getGrade();
        JOptionPane.showMessageDialog(null, message);

        System.exit(0);
    }
}
