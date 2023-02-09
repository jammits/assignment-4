package com.codercampus.assignment4;

public class ListApplication {
    public static void main(String[] args){

        ApplicationService service = new ApplicationService();
        Student[] students = service.studentCreation();
        students = service.csvCreator(students);
        for (Student student : students) {
            System.out.printf("ID: %d , Student name: %s , Subject: %s , Grade: %d \n",student.getStudentId(),student.getStudentName(), student.getCourse(), student.getGrade());
        }
    }
}
