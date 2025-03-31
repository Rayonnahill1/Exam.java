public class Exam extends Assessment {
    private int questions;
    private int missed;

    // Constructor
    public Exam(int questions, int missed) {
        this.questions = questions;
        this.missed = missed;
        calculateScore();
    }

    // Method to calculate the score
    private void calculateScore() {
        double pointsEach = 100.0 / questions;
        int score = (int) Math.round(100 - (missed * pointsEach));
        setScore(score);
    }

    // Method to get points for each question
    public double getPointsEach() {
        return 100.0 / questions;
    }
}
