/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.project7;

import java.util.LinkedList;
import java.util.Scanner;
import com.project.validation.Input;

/**
 *
 * @author Ann
 */
public class Score {
    private String id;
    private Student student;
    private Course course;
    private double score;
    private Scanner scan = new Scanner(System.in);

    public Score() {
    }

    public Score(String id, Student student, Course course, double score) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.score = score;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Score{" + "ID=" + id + ", Student=" + student.getName() + ", Course=" + course.getCode() + ", Score=" + score + '}';
    }
    
    
    
    /**
     * Input Score For Student.
     * @param stuList List of Student
     * @param courseList List of Course
     * @return Status boolean
     */
    public boolean input(LinkedList<Student> stuList, LinkedList<Course> courseList) {
        //Nhap vao ID de xac dinh diem cua sinh vien nao
        String lStudenId = Input.inputAndCheckNotEmpty("Enter Studen ID: ", "Error, Empty String!", this.scan);
        //Tim kiem sv do
        Student lStudent= StudentManagement.findStudentById(lStudenId, stuList);
        //Check xem co tim thay khong
        if(!lStudent.getId().equalsIgnoreCase(lStudenId)){
            //Neu khong thi bao loi roi out
            System.out.println("Student Not Exist!");
            return false;
        }
        //Tuong tu voi mon hoc
        String lCourseCode = Input.inputAndCheckNotEmpty("Enter Course Code: ", "Error, Empty String!", this.scan);
        Course lCourse = StudentManagement.findCourseByCode(lCourseCode, courseList);
        if(!lCourse.getCode().equalsIgnoreCase(lCourseCode)){
            System.out.println("Course Not Exist!");
            return false;
        }
        //Nhap diem
        double lScore = Input.inputAndCheckPositiveNumber("Enter Score: ", "Error, Positive Number Only!", this.scan, true);
        //Cac thong tin ok het thi set vao obj
        this.setStudent(lStudent);
        this.setCourse(lCourse);
        //Auto ID khong can nhap
        this.setId("SCORE"+StudentManagement.generateId());
        this.setScore(lScore);
        //Tat ca ok thi tra ve true va out
        return true;
    }
    
    /**
     * Edit Score For Student.
     * @param stuList List of Student
     * @param courseList List of Course
     * @return Status boolean
     */
    public boolean edit() {
        //Chi cho edit diem so, cac thong tin con lai de nguyen
        double lScore = Input.inputAndCheckPositiveNumber("Enter Score: ", "Error, Positive Number Only!", this.scan, true);
        this.setScore(lScore);
        return true;
    }
}
