package com.codercampus.assignment4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

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
                String[] studentDetail = line.split(",");
                Student person = new Student(Integer.parseInt(studentDetail[0]),studentDetail[1],studentDetail[2],Integer.parseInt(studentDetail[3]));
                students[studentsIndex] = person;
                studentsIndex++;
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

    public Student[] sortBySubject(Student[] students){
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student person1, Student person2) {
                if (person1.getCourse().compareTo(person2.getCourse()) == 0) {
                    return person1.compareTo(person2);
                }
                return person1.getCourse().compareTo(person2.getCourse());
            }
        });

        return students;

    }

    public Integer countSubject(Student[] students){
        
    }
}
