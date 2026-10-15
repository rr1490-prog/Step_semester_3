
package polymorphism.class_problems;

import java.util.Scanner;

abstract class Question {

    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    Question(String questionText, String correctAnswer,
             String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double grade();

    abstract String getType();
}

class MCQQuestion extends Question {

    MCQQuestion(String q, String correct, String student, double points) {
        super(q, correct, student, points);
    }

    @Override
    double grade() {
        return studentAnswer.equalsIgnoreCase(correctAnswer)
                ? points : 0;
    }

    @Override
    String getType() {
        return "MCQ";
    }
}

class TrueFalseQuestion extends Question {

    TrueFalseQuestion(String q, String correct,
                      String student, double points) {
        super(q, correct, student, points);
    }

    @Override
    double grade() {
        return studentAnswer.equalsIgnoreCase(correctAnswer)
                ? points : 0;
    }

    @Override
    String getType() {
        return "TF";
    }
}

class EssayQuestion extends Question {

    EssayQuestion(String q, String correct, String student,
                  double points) {
        super(q, correct, student, points);
    }

    @Override
    double grade() {

        String[] keywords = correctAnswer.split(",");
        int matched = 0;

        for (String keyword : keywords) {
            if (studentAnswer.toLowerCase()
                    .contains(keyword.trim().toLowerCase())) {
                matched++;
            }
        }

        if (matched >= 2) {
            return points * 0.75;
        } else if (matched == 1) {
            return points * 0.50;
        } else {
            return 0;
        }
    }

    @Override
    String getType() {
        return "ESSAY";
    }
}

public class ExaminationGrader {

    static String clean(String text) {
        text = text.trim();

        if (text.startsWith("\"") && text.endsWith("\"")) {
            return text.substring(1, text.length() - 1);
        }

        return text;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double totalScore = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            sc.skip("\\s+");

            String questionText = clean(sc.findInLine("\"[^\"]*\""));
            String correctAnswer = clean(sc.findInLine("\"[^\"]*\""));
            String studentAnswer = clean(sc.findInLine("\"[^\"]*\""));

            double points = sc.nextDouble();

            Question question;

            switch (type) {
                case "MCQ":
                    question = new MCQQuestion(
                        questionText, correctAnswer, studentAnswer, points
                    );
                    break;

                case "TF":
                    question = new TrueFalseQuestion(
                        questionText, correctAnswer, studentAnswer, points
                    );
                    break;

                case "ESSAY":
                    question = new EssayQuestion(
                        questionText, correctAnswer, studentAnswer, points
                    );
                    break;

                default:
                    continue;
            }

            double score = question.grade();

            System.out.printf("%s: %.2f%n", question.getType(), score);
            totalScore += score;
        }

        System.out.printf("Total Score: %.2f%n", totalScore);

        sc.close();
    }
}

