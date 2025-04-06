public class Exam extends Assessment {
    private int questions;
    private int missed;

    // Constructor
    public Exam(int questions, int missed) {
        if (questions <= 0) {
            throw new IllegalArgumentException("Number of questions cannot be zero or negative.");
        }
        this.questions = questions;
        this.missed = missed;
        calculateScore();
    }

    // Method to calculate the score
    private void calculateScore() {
        double pointsEach = 100.0 / questions;  // Points per question
        int score = (int) Math.round(100 - (missed * pointsEach));
        setScore(score);
    }

    // Method to get points for each question
    public double getPointsEach() {
        return 100.0 / questions;
    }
}
