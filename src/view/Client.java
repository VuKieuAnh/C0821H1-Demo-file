package view;

import controller.StudentManager;
import model.Student;
import storage.IStudentFile;
import storage.StudentFileExcel;
import storage.StudentReadWriteFile;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        List<Student> c0821h1 = null;
        StudentReadWriteFile studentReadWriteFile = StudentReadWriteFile.getInstance();
        try {
            c0821h1 = studentReadWriteFile.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        IStudentFile studentFile = new StudentFileExcel();
        StudentManager studentManager = new StudentManager(studentFile);
        StudentManager ka = new StudentManager("Kieu Anh xinh", c0821h1);
        Student s = newStudent();
        try {
            ka.addNewStudent(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Student newStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Moi ban nhap Id");
        int id = scanner.nextInt();
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Moi ban nhap name");
        String name = scanner1.nextLine();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Moi ban nhap Add");
        String add = scanner2.nextLine();
        Student s = new Student(id, name, add);
        return s;
    }
}