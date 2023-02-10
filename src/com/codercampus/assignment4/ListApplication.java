package com.codercampus.assignment4;

public class ListApplication {
    public static void main(String[] args){

        ApplicationService service = new ApplicationService();
        Student[] students = service.studentCreation();
        service.csvCreator(students);

    }
}
