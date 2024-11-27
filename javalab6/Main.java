import CIE.Personal;
import CIE.Internals;
import SEE.External;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        External[] students = new External[n];
        Internals[] internals = new Internals[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for student " + (i + 1));
            System.out.print("USN: ");
            String usn = scanner.next();
            System.out.print("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Semester: ");
            int sem = scanner.nextInt();

            students[i] = new External(usn, name, sem);
            internals[i] = new Internals();

            System.out.println("Enter internal marks for 5 courses:");
            int[] intMarks = new int[5];
            for (int j = 0; j < 5; j++) {
                intMarks[j] = scanner.nextInt();
            }
            internals[i].setMarks(intMarks);

            System.out.println("Enter SEE marks for 5 courses:");
            int[] extMarks = new int[5];
            for (int j = 0; j < 5; j++) {
                extMarks[j] = scanner.nextInt();
            }
            students[i].setMarks(extMarks);
        }

        System.out.println("Final Marks of Students:");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + " - USN: " + students[i].usn + ", Name: " + students[i].name + ", Semester: " + students[i].sem);
            System.out.println("Course-wise Final Marks:");
            for (int j = 0; j < 5; j++) {
                int finalMark = internals[i].internalMarks[j] + (students[i].externalMarks[j] / 2);
                System.out.println("Course " + (j + 1) + ": " + finalMark);
            }
        }
    }
}
