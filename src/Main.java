import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Constants and Data Storage
        final int MAX_STUDENTS = 10;
        int[] studentIds = new int[MAX_STUDENTS];
        String[] fullNames = new String[MAX_STUDENTS];
        int[] ages = new int[MAX_STUDENTS];
        String[] courses = new String[MAX_STUDENTS];
        double[] grades = new double[MAX_STUDENTS];
        boolean[] enrolledStatuses = new boolean[MAX_STUDENTS];

        int studentCount = 0; // Tracks the current number of registered students
        int choice = 0;

        System.out.println("=== Student Management System ===");

        // Main Menu Loop
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. View Statistics");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            // Basic check to prevent crash on non-integer input
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.next(); // Clear the invalid token
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left behind

            switch (choice) {
                case 1: // Add Student
                    if (studentCount >= MAX_STUDENTS) {
                        System.out.println("Error: The student list is full (Maximum " + MAX_STUDENTS + " students).");
                        break;
                    }

                    System.out.println("\n--- Add New Student ---");

                    System.out.print("Enter Student ID (Integer): ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter Full Name: ");
                    String name = scanner.nextLine();

                    // Validate Age
                    int age;
                    while (true) {
                        System.out.print("Enter Age: ");
                        age = scanner.nextInt();
                        if (age > 0) {
                            break;
                        }
                        System.out.println("Invalid age. Age must be a positive number.");
                    }
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();

                    // Validate Grade
                    double grade;
                    while (true) {
                        System.out.print("Enter Grade / Score (0.0 - 100.0): ");
                        grade = scanner.nextDouble();
                        if (grade >= 0.0 && grade <= 100.0) {
                            break;
                        }
                        System.out.println("Invalid grade. Score must be between 0 and 100.");
                    }

                    System.out.print("Is the student currently enrolled? (true/false): ");
                    boolean isEnrolled = scanner.nextBoolean();

                    // Store data into parallel arrays
                    studentIds[studentCount] = id;
                    fullNames[studentCount] = name;
                    ages[studentCount] = age;
                    courses[studentCount] = course;
                    grades[studentCount] = grade;
                    enrolledStatuses[studentCount] = isEnrolled;

                    studentCount++;
                    System.out.println("Student added successfully!");
                    break;

                case 2: // View All Students
                    if (studentCount == 0) {
                        System.out.println("\nNo student records found.");
                        break;
                    }

                    System.out.println("\n================================== STUDENT LIST ==================================");
                    System.out.printf("%-10s %-20s %-5s %-15s %-8s %-10s %-15s\n",
                            "ID", "Name", "Age", "Course", "Grade", "Enrolled", "Standing");
                    System.out.println("----------------------------------------------------------------------------------");

                    for (int i = 0; i < studentCount; i++) {
                        String standing;
                        if (grades[i] >= 90) {
                            standing = "Dean's Lister";
                        } else if (grades[i] >= 75) {
                            standing = "Passed";
                        } else {
                            standing = "Failed";
                        }

                        System.out.printf("%-10d %-20s %-5d %-15s %-8.2f %-10b %-15s\n",
                                studentIds[i], fullNames[i], ages[i], courses[i],
                                grades[i], enrolledStatuses[i], standing);
                    }
                    System.out.println("==================================================================================");
                    break;

                case 3: // Search by ID
                    if (studentCount == 0) {
                        System.out.println("\nNo student records available to search.");
                        break;
                    }

                    System.out.print("\nEnter Student ID to search: ");
                    int searchId = scanner.nextInt();
                    boolean found = false;

                    for (int i = 0; i < studentCount; i++) {
                        if (studentIds[i] == searchId) {
                            System.out.println("\nStudent Found:");
                            System.out.println("ID: " + studentIds[i]);
                            System.out.println("Name: " + fullNames[i]);
                            System.out.println("Age: " + ages[i]);
                            System.out.println("Course: " + courses[i]);
                            System.out.println("Grade: " + grades[i]);
                            System.out.println("Enrolled Status: " + enrolledStatuses[i]);
                            found = true;
                            break; // Match found, break loop
                        }
                    }

                    if (!found) {
                        System.out.println("Student with ID " + searchId + " not found.");
                    }
                    break;

                case 4: // View Statistics
                    if (studentCount == 0) {
                        System.out.println("\nNo records available to compute statistics.");
                        break;
                    }

                    double sum = 0;
                    double maxGrade = grades[0];
                    String topStudentName = fullNames[0];

                    for (int i = 0; i < studentCount; i++) {
                        sum += grades[i];

                        if (grades[i] > maxGrade) {
                            maxGrade = grades[i];
                            topStudentName = fullNames[i];
                        }
                    }

                    double average = sum / studentCount;

                    System.out.println("\n--- Class Statistics ---");
                    System.out.println("Total Number of Students: " + studentCount);
                    System.out.printf("Average Class Grade: %.2f\n", average);
                    System.out.printf("Top Student: %s (Grade: %.2f)\n", topStudentName, maxGrade);
                    break;

                case 5: // Exit
                    System.out.println("\nExiting program. Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose a number between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
