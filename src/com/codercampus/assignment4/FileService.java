package com.codercampus.assignment4;

import java.io.*;


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

    public void studentWriter(Student[] students){

        try(BufferedWriter subject1 = new BufferedWriter(new FileWriter("course1.csv")); BufferedWriter subject2 = new BufferedWriter(new FileWriter("course2.csv"));
        BufferedWriter subject3 = new BufferedWriter(new FileWriter("course3.csv"))){
            for(Student student: students){
                if(student != null){
                    if(student.getCourse().matches("^COMPSCI.[0-9]+")){
                        subject1.write(student.toString());
                    }
                    else if(student.getCourse().matches("^APMTH.[0-9]+")){
                        subject2.write(student.toString());
                    }
                    else if (student.getCourse().matches("^STAT.[0-9]+")) {
                        subject3.write(student.toString());
                    }
                }
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
