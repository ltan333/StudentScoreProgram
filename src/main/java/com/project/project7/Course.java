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
public class Course {

    private String code;
    private String name;
    private String major;
    private Scanner scan = new Scanner(System.in);

    public Course() {
    }

    public Course(String code, String name, String major) {
        this.code = code;
        this.name = name;
        this.major = major;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Course{" + "Code=" + code + ", Name=" + name + ", Major=" + major + '}';
    }

    /**
     * Input Course Information.
     *
     * @return Status boolean
     */
    public boolean input() {
        //Cho nhap cac gia tri bang ham build san
        String lName = Input.inputAndCheckNotEmpty("Enter Course Name: ", "Error, Empty String!", this.scan);
        String lMajor = Input.inputAndCheckNotEmpty("Enter Major: ", "Error, Empty String!", this.scan);
        //Code duoc tao tu dong khong can nhap
        this.setCode("COURSE" + StudentManagement.generateId());
        this.setName(lName);
        this.setMajor(lMajor);
        return true;
    }

    public boolean edit() {
        //TUong tu nhung khong can auto id
        String lName = Input.inputAndCheckNotEmpty("Enter Course Name: ", "Error, Empty String!", this.scan);
        String lMajor = Input.inputAndCheckNotEmpty("Enter Major: ", "Error, Empty String!", this.scan);

        this.setName(lName);
        this.setMajor(lMajor);
        return true;
    }
}
