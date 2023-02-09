package com.codercampus.assignment4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class ApplicationService {
    public Student[] studentCreation() {
        FileService service = new FileService();
        return service.studentExtractor(new Student[service.lineCounter()]);
    }

    public Student[] csvCreator(Student[] studentBySubject){
        FileService service = new FileService();
        Student[] sortedStudent = service.sortBySubject(studentBySubject);


        //need method to count number of different classes available to students to know how many csvs to create; return integer of classes
        //Note need to separate student by subject into their own arrays then do a sort on each array
        //dynamically create number of array based on different subjects
    }

}
