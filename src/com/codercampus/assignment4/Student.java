package com.codercampus.assignment4;

public class Student implements Comparable<Student>{
    private Integer studentId;
    private String studentName;
    private String course;
    private Integer grade;

    public Student(Integer studentId, String studentName, String course, Integer grade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
        this.grade = grade;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String toString(){
        return this.studentId.toString()+","+this.studentName+","+this.course+","+this.grade.toString()+"\n";
    }
    @Override
    //Sort student on grade then on name if same grade implementation for comparable<T>
    public int compareTo(Student that) {
        if(that == null){
           return 0;
        }
        else if (that.grade.compareTo(this.grade) == 0) {
            return that.studentName.compareTo(this.studentName);
        }
        else {
            return that.grade.compareTo(this.grade);
        }
    }
}

