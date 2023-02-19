package com.codercampus.assignment4;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class FileService {

    private final String file = "student-master-list.csv";
    public Integer lineCounter(){
        try (BufferedReader lineReader = new BufferedReader(new FileReader(file))){
            Integer numOfLine = 0;
            // Skip the header
            lineReader.readLine();
            while (lineReader.readLine() != null) {
                numOfLine++;
            }
            return numOfLine;
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Student[] studentExtractor(Student[] students){
        try(BufferedReader studentReader = new BufferedReader(new FileReader(file))){
            //Skip the header
            studentReader.readLine();
            String line;
            Integer studentsIndex = 0;
            while ((line = studentReader.readLine()) != null) {
                if(!line.equals("")){
                    String[] studentDetail = line.split(",");
                    Student person = new Student(Integer.parseInt(studentDetail[0]),studentDetail[1],studentDetail[2],Integer.parseInt(studentDetail[3]));
                    students[studentsIndex] = person;
                    studentsIndex++;
                }

            }

            return students;
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Note should refactor to separate the file writing to one writer and the sorting into separate methods
    public void studentWriter(Student[] students, String fileName){

        try(BufferedWriter subject = new BufferedWriter(new FileWriter(fileName))){
            subject.write("Student ID,Student Name,Course,Grade\n");

            for (Student student : students) {
                if (student != null) {
                    subject.write(student.toString());
                }

            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
