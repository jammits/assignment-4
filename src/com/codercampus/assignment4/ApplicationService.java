package com.codercampus.assignment4;


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

        Student[] compSci = new Student[students.length];
        Student[] stat = new Student[students.length];
        Student[] ampth = new Student[students.length];
        int csCnt = 0, statCnt = 0, ampthCnt = 0;

        for(Student student: students){
            if(student != null){
                if(student.getCourse().matches("^COMPSCI.[0-9]+")){
                    compSci[csCnt++] = student;
                }
                else if(student.getCourse().matches("^APMTH.[0-9]+")){
                    ampth[ampthCnt++] = student;
                }
                else if (student.getCourse().matches("^STAT.[0-9]+")) {
                    stat[statCnt++] = student;
                }
            }
        }

        service.studentWriter(compSci,"course1.csv");
        service.studentWriter(ampth,"course2.csv");
        service.studentWriter(stat,"course3.csv");
    }

}
