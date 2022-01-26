package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "vũ kiều anh", "hà nội"));
        students.add(new Student(2, "nguyễn minh quân", "hà nội"));
        students.add(new Student(3, "đặng huy hoàng", "đà nẵng"));
        students. add(new Student(4, "nguyễn khánh tùng", "hà nội"));
        students.add(new Student(5, "nguyễn khắc nhật", "hà nội"));

        writeToFile("src/com/company/WriteStudent", students);

        List<Student> studentsDataFromFile = readDataFromFile("src/com/company/WriteStudent");
        for (Student student: students) {
            System.out.println(student);
        }

    }
    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return students;
    }

    public static void writeToFile (String path, List<Student> students){
        try {
            FileOutputStream fos= new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
