import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentPhoneBook {

    static class Student {
        private String email;
        private String phoneNumber;

        public Student(String email, String phoneNumber) {
            this.email = email;
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        @Override
        public String toString() {
            return "Email: " + email + ", Phone Number: " + phoneNumber;
        }
    }

    private HashMap<String, Student> phoneBook;

    public StudentPhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addStudent(String studentId, String email, String phoneNumber) {
        if (phoneBook.containsKey(studentId)) {
            System.out.println("Student ID already exists. Use a unique ID.");
        } else {
            phoneBook.put(studentId, new Student(email, phoneNumber));
            System.out.println("Student added successfully.");
        }
    }

    public void searchStudent(String studentId) {
        Student student = phoneBook.get(studentId);
        if (student != null) {
            System.out.println("Student ID: " + studentId + ", " + student);
        } else {
            System.out.println("Student not found.");
        }
    }

    public void retrieveAllStudents() {
        if (phoneBook.isEmpty()) {
            System.out.println("Phone book is empty.");
        } else {
            System.out.println("All Students:");
            for (Map.Entry<String, Student> entry : phoneBook.entrySet()) {
                System.out.println("Student ID: " + entry.getKey() + ", " + entry.getValue());
            }
        }
    }

    public void deleteStudent(String studentId) {
        Student removed = phoneBook.remove(studentId);
        if (removed != null) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student ID not found.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentPhoneBook phoneBook = new StudentPhoneBook();
        boolean running = true;

        while (running) {
            System.out.println("\nStudent Phone Book Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student by ID");
            System.out.println("3. Retrieve All Students");
            System.out.println("4. Delete Student by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.print("Enter Student ID: ");
                    String addId = scanner.nextLine().trim();
                    System.out.print("Enter Email ID: ");
                    String addEmail = scanner.nextLine().trim();
                    System.out.print("Enter Phone Number: ");
                    String addPhone = scanner.nextLine().trim();
                    phoneBook.addStudent(addId, addEmail, addPhone);
                    break;

                case "2":
                    System.out.print("Enter Student ID to search: ");
                    String searchId = scanner.nextLine().trim();
                    phoneBook.searchStudent(searchId);
                    break;

                case "3":
                    phoneBook.retrieveAllStudents();
                    break;

                case "4":
                    System.out.print("Enter Student ID to delete: ");
                    String deleteId = scanner.nextLine().trim();
                    phoneBook.deleteStudent(deleteId);
                    break;

                case "5":
                    running = false;
                    System.out.println("Exiting Student Phone Book. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }

        scanner.close();
    }
}

