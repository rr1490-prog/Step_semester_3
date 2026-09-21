
package oop_fundamental_2.class_problems;

public class Course {

    String code;
    String title;
    int credits;
    int labCredits;

    Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    int totalCredits() {
        return credits + labCredits;
    }

    public static void main(String[] args) {

        Course course1 = new Course("CSE101", "Java Programming", 3, 1);
        Course course2 = new Course("CSE102", "Data Structures", 4);

        System.out.println(course1.title + ": " + course1.totalCredits() + " credits");
        System.out.println(course2.title + ": " + course2.totalCredits() + " credits");
    }
}
