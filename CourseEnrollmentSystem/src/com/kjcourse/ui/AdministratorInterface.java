package com.kjcourse.ui;

import com.kjcourse.model.Course;
import com.kjcourse.model.Student;
import com.kjcourse.service.CourseManagement;
import com.kjcourse.util.DataValidator;
import com.kjcourse.util.InputValidator;

import java.util.Scanner;

/**
 * The @code AdministratorInterface class serves as the command-line interface (CLI)
 * for administrators to manage course enrollments and grade assignments.
 * 
 * It allows administrators to:
 * 
 *     Add new courses
 *     Enroll students in courses
 *     Assign grades to enrolled students
 *     Calculate a student's overall grade average
 *
 * This class uses @code Scanner for user input and delegates business logic
 * to the @link CourseManagement service class. Input validation is handled by
 * @link InputValidator and data lookup/creation by @link DataValidator.
 * 
 * Note:The system runs in a loop until the administrator chooses to exit./
 */

public class AdministratorInterface {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display Menu
            System.out.println("\n--- Course Enrollment and Grade Management System ---");
            System.out.println("1. Add New Course");
            System.out.println("2. Enroll Student in Course");
            System.out.println("3. Assign Grade to Student");
            System.out.println("4. Calculate Student's Overall Grade");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    // Add Course
                    String courseCode = InputValidator.readNonEmptyString("Enter Course Code: ");
                    if (DataValidator.findCourseByCode(courseCode) != null) {
                        System.out.println("Course already exists.");
                        break;
                    }
                    String courseName = InputValidator.readNonEmptyString("Enter Course Name: ");
                    int capacity = InputValidator.readInt("Enter Course Capacity: ");
                    CourseManagement.addCourse(courseCode, courseName, capacity);
                    System.out.println("Course added successfully.");
                    break;

                case "2":
                    // Enroll Student
                    String studentId = InputValidator.readNonEmptyString("Enter Student ID: ");
                    Student student = DataValidator.getOrCreateStudent(studentId);
                    String enrollCourseCode = InputValidator.readNonEmptyString("Enter Course Code to Enroll: ");
                    Course course = DataValidator.findCourseByCode(enrollCourseCode);
                    if (course == null) {
                        System.out.println("Course not found.");
                        break;
                    }
                    CourseManagement.enrollStudent(student, course);
                    break;

                case "3":
                    // Assign Grade
                    String gradeStudentId = InputValidator.readNonEmptyString("Enter Student ID: ");
                    Student gradeStudent = DataValidator.findStudentById(gradeStudentId);
                    if (gradeStudent == null) {
                        System.out.println("Student not found.");
                        break;
                    }
                    String gradeCourseCode = InputValidator.readNonEmptyString("Enter Course Code: ");
                    Course gradeCourse = DataValidator.findCourseByCode(gradeCourseCode);
                    if (gradeCourse == null) {
                        System.out.println("Course not found.");
                        break;
                    }
                    float grade = InputValidator.readFloat("Enter Grade (0.0 - 100.0): ");
                    CourseManagement.assignGrade(gradeStudent, gradeCourse, grade);
                    break;

                case "4":
                    // Calculate Overall Grade
                    String calcStudentId = InputValidator.readNonEmptyString("Enter Student ID: ");
                    Student calcStudent = DataValidator.findStudentById(calcStudentId);
                    if (calcStudent == null) {
                        System.out.println("Student not found.");
                        break;
                    }
                    float avg = CourseManagement.calculateOverallGrade(calcStudent);
                    System.out.println("Overall Grade: " + avg);
                    break;

                case "0":
                    System.out.println("Exiting the system.");
                    return;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
            
            scanner.close();
        }
    }
}
