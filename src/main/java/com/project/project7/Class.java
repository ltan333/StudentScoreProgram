/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.project7;
import com.project.validation.Input;
import java.util.Scanner;

/**
 *
 * @author Ann
 */
public class Class {
    private String code;
    private String name;
    private int grade;
    private Scanner scan = new Scanner(System.in);

    public Class() {
    }

    public Class(String code, String name, int grade) {
        this.code = code;
        this.name = name;
        this.grade = grade;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Class{" + "Code=" + code + ", Name=" + name + ", Grade=" + grade +'}';
    }
    
    /**
     * Input Student Information.
     * @return Status boolean
     */
    public boolean input(){
        //Cho nhap cac gia tri bang ham build san
        String lName = Input.inputAndCheckNotEmpty("Enter Class Name: ", "Error, Empty String!", this.scan);
        int lGrade = (int)Input.inputAndCheckPositiveNumber("Enter Grade: ", "Error, Only Number!", this.scan, false);
        //ID duoc tao tu dong khong can nhap
        this.setCode("CLASS"+StudentManagement.generateId());
        //Set cac gia tri vao obj
        this.setName(lName);
        this.setGrade(lGrade);
        return true;
    }
    
    /**
     * Edit Student Information.
     * @return Status boolean
     */
    public boolean edit(){
        //Tuong tu nhung khong can auto ID
        String lName = Input.inputAndCheckNotEmpty("Enter Class Name: ", "Error, Empty String!", this.scan);
        int lGrade = (int)Input.inputAndCheckPositiveNumber("Enter Grade: ", "Error, Only Number!", this.scan, false);
        
        this.setName(lName);
        this.setGrade(lGrade);
        return true;
    }
}
