import javax.swing.JOptionPane;

public class Runner {

    public static void main(String[] args) {
        String input;     // To hold input
        int questions = 0; // Default to 0
        int missed = 0;    // Default to 0

        // Get the number of questions on the exam
        try {
            input = JOptionPane.showInputDialog("How many questions are on the exam?");
            questions = Integer.parseInt(input);
            if (questions <= 0) {
                throw new IllegalArgumentException("Number of questions must be greater than zero.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input for number of questions. Please enter a valid integer.");
            System.exit(1);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(1);
        }

        // Get the number of questions the student missed
        try {
            input = JOptionPane.showInputDialog("How many questions did the student miss?");
            missed = Integer.parseInt(input);
            if (missed < 0 || missed > questions) {
                throw new IllegalArgumentException("Number of missed questions must be between 0 and the number of questions.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input for missed questions. Please enter a valid integer.");
            System.exit(1);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.exit(1);
        }

        // Create an Exam object
        Exam exam = new Exam(questions, missed);

        // Display the test results
        String message = "Each question counts " + exam.getPointsEach() + " points.\n";
        message += "The exam score is " + exam.getScore() + "\n";
        message += "The exam grade is " + exam.getGrade();
        JOptionPane.showMessageDialog(null, message);

        System.exit(0);
    }
}
