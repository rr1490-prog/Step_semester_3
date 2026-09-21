
package encapsulation_access_control.class_problems;

public class Scorecard {

    private final boolean[] results;
    private int answersRecorded;
    private int score;

    Scorecard(int totalQuestions) {
        if (totalQuestions < 0) {
            totalQuestions = 0;
        }

        results = new boolean[totalQuestions];
        answersRecorded = 0;
        score = 0;
    }

    void recordAnswer(boolean isCorrect) {
        if (answersRecorded >= results.length) {
            System.out.println("Answer rejected: question limit reached");
            return;
        }

        results[answersRecorded] = isCorrect;
        answersRecorded++;

        if (isCorrect) {
            score++;
        }
    }

    int getScore() {
        return score;
    }

    public static void main(String[] args) {

        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Final score: " + sc.getScore());
    }
}
