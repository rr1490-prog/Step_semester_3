
package string.class_problems;

import java.util.Scanner;

public class CSVStudentRecordParser {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student record (name,rollno,department): ");
        String record = sc.nextLine();

        String[] data = record.split(",");

        if (data.length == 3) {

            String name = data[0].trim();
            String rollNo = data[1].trim();
            String department = data[2].trim();

            System.out.println("Name: " + name);
            System.out.println("Roll No: " + rollNo);
            System.out.println("Department: " + department);

        } else {
            System.out.println("Invalid student record.");
        }

        sc.close();
    }
}