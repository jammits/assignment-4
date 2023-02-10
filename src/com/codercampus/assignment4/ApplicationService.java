package com.codercampus.assignment4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;

public class ApplicationService {
    public Student[] studentCreation() {
        FileService service = new FileService();
        return service.studentExtractor(new Student[service.lineCounter()]);
    }

    public void csvCreator(Student[] students){
        FileService service = new FileService();
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student person1, Student person2) {
                if(person1 == null || person2 == null){
                    return 0;
                }
                else{
                    return person1.compareTo(person2);
                }
            }
        });

        service.studentWriter(students);
    }

}
