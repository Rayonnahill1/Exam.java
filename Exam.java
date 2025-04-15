public class Exam extends Assessment {
    private int questions;
    private int missed;

    // Constructor
    public Exam(String questionsInput, String missedInput) {
        try {
            questions = Integer.parseInt(questionsInput);
            if (questions <= 0) {
                throw new IllegalArgumentException("Number of questions must be greater than zero.");
            }

            missed = Integer.parseInt(missedInput);
            if (missed < 0 || missed > questions) {
                throw new IllegalArgumentException("Number of missed questions must be between 0 and the number of questions.");
            }

            calculateScore();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Both values must be valid integers.");
        }
    }

    // Method to calculate the score
    private void calculateScore() {
        double pointsEach = 100.0 / questions;
        int score = (int) Math.round(100 - (missed * pointsEach));
        setScore(score);
    }

    public double getPointsEach() {
        return 100.0 / questions;
    }
}
