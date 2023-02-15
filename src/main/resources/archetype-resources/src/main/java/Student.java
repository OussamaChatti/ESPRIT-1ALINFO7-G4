import java.util.Scanner;

public class StudentManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static Student[] students = new Student[10]; //maximum of 10 students
    
    public static void main(String[] args) {
        boolean exit = false;
        while(!exit) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
            System.out.println();
        }
    }
    
    static void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.next();
        System.out.print("Enter student roll number: ");
        int rollNo = sc.nextInt();
        System.out.print("Enter student age: ");
        int age = sc.nextInt();
        System.out.print("Enter student address: ");
        String address = sc.next();
        students[Student.count++] = new Student(name, rollNo, age, address);
        System.out.println("Student added successfully!");
    }
    
    static void displayStudents() {
        if(Student.count == 0) {
            System.out.println("No students added yet!");
        } else {
            System.out.println("Student List:");
            for(int i=0; i<Student.count; i++) {
                System.out.println(students[i]);
            }
        }
    }
    
    static void searchStudent() {
        System.out.print("Enter student roll number to search: ");
        int rollNo = sc.nextInt();
        for(int i=0; i<Student.count; i++) {
            if(students[i].getRollNo() == rollNo) {
                System.out.println(students[i]);
                return;
            }
        }
        System.out.println("Student not found!");
    }
}

class Student {
    private String name;
    private int rollNo;
    private int age;
    private String address;
    static int count = 0;
    
    public Student(String name, int rollNo, int age, String address) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
        this.address = address;
    }
    
    public String getName() {
        return name;
    }
    
    public int getRollNo() {
        return rollNo;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getAddress() {
        return address;
    }
    
    @Override
    public String toString() {
        return "Name: " + name + ", Roll No: " + rollNo + ", Age: " + age + ", Address: " + address;
    }
}
