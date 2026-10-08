import java.util.Scanner;

class Student {
    // Data members
    String studentName;
    int rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    public Student(String studentName, int rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    public double calculateFee() {
        return courseCredits * 1500.0;
    }

    public double calculateFee(double costPerCredit) {
        return courseCredits * costPerCredit;
    }

    public boolean checkEligibility() {
        return marks >= 50.0;
    }


    public double calculateScholarship() {
        double fee = calculateFee();
        if (marks >= 85.0) {
            return 0.20 * fee; 
        } else if (marks >= 70.0 && marks <= 84.0) {
            return 0.10 * fee; 
        } else {
            return 0.0; 
        }
    }


    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }


    public void displayDetails() {
        System.out.println("\n--- Student Registration Details ---");
        System.out.println("Student Name   : " + studentName.toUpperCase()); 
        System.out.println("Roll Number    : " + rollNumber);
        System.out.println("Marks          : " + marks);
        System.out.println("Course Name    : " + courseName.trim()); 
        System.out.println("Course Credits : " + courseCredits);
        System.out.println("Eligibility    : " + (checkEligibility() ? "Eligible" : "Not Eligible"));
        System.out.println("Total Fee      : Rs. " + calculateFee());
        System.out.println("Scholarship    : Rs. " + calculateScholarship());
        System.out.println("Final Fee      : Rs. " + calculateFinalFee());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine(); 

        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();

        System.out.print("Enter Course Credits: ");
        int credits = sc.nextInt();


        Student student = new Student(name, roll, marks, course, credits);


        if (student.checkEligibility()) {
            System.out.println("\nStudent is eligible for course registration!");
            student.displayDetails();
        } else {
            System.out.println("\nRegistration Failed: Student is not eligible for registration due to insufficient marks.");
        }

        sc.close();
    }
}