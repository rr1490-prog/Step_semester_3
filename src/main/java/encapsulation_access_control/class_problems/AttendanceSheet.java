
package encapsulation_access_control.class_problems;

public class AttendanceSheet {

    private final String[] presentStudents;
    private int presentCount;

    AttendanceSheet(int maximumClassSize) {
        if (maximumClassSize < 0) {
            maximumClassSize = 0;
        }

        presentStudents = new String[maximumClassSize];
        presentCount = 0;
    }

    void markPresent(String name) {

        if (name == null || name.isEmpty()) {
            System.out.println("Invalid student name");
            return;
        }

        if (isPresent(name)) {
            System.out.println("Student already marked present");
            return;
        }

        if (presentCount >= presentStudents.length) {
            System.out.println("Attendance rejected: class limit reached");
            return;
        }

        presentStudents[presentCount] = name;
        presentCount++;

        System.out.println(name + " marked present");
    }

    int getPresentCount() {
        return presentCount;
    }

    boolean isPresent(String name) {

        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("Ben present: " + sheet.isPresent("Ben"));
        System.out.println("Chen present: " + sheet.isPresent("Chen"));
    }
}
