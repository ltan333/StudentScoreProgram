/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.project7;

import com.project.validation.Input;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Me
 */
public class Student {

    private String id;
    private String name;
    private String addr;
    private Class classs;
    private Scanner scan = new Scanner(System.in);

    public Student() {
    }

    public Student(String id, String name, String addr, Class classs) {
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.classs = classs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Class getClasss() {
        return classs;
    }

    public void setClasss(Class classs) {
        this.classs = classs;
    }

    @Override
    public String toString() {
        return "Student{" + "ID=" + id + ", Name=" + name + ", Address=" + addr + ", Class=" + classs.getCode() + '}';
    }

    /**
     * Input Student Information
     * @param classList List of Class
     * @return status boolean
     */
    public boolean input(LinkedList<Class> classList) {
        //Nhap ten bang ham build san
        String localName = Input.inputAndCheckString("Enter Name: ", "Invalid Name, Please Only Aphabet Characters!", this.scan);
        //Nhap ma lop va tim xem no co ton tai khong
        String lClassCode = Input.inputAndCheckNotEmpty("Enter Class Code: ", "Error, Empty String!", this.scan);
        Class lClass = StudentManagement.findClassByCode(lClassCode, classList);
        //Neu khong ton tai thi bao loi va out
        if (!lClass.getCode().equalsIgnoreCase(lClassCode)) {
            System.out.println("Error, Class Not Found!");
            return false;
        }
        //Nhap Addr
        String lAddr = Input.inputAndCheckNotEmpty("Enter Address: ", "Error, Empty String!", this.scan);
        //Thong tin ok het thi set vao obj
        //Auto tao ra ID
        this.setId("S" + StudentManagement.generateId());
        this.setName(localName);
        this.setClasss(lClass);
        this.setAddr(lAddr);
        //Thanh cong
        return true;
    }

    /**
     * Edit Student Information
     * @param classList List of Class
     * @return status boolean
     */
    public boolean edit(LinkedList<Class> classList) {
        //Tuong Tu nhung khong thay doi ID
        String localName = Input.inputAndCheckString("Enter Name: ", "Invalid Name, Please Only Aphabet Characters!", this.scan);
        String lClassCode = Input.inputAndCheckNotEmpty("Enter Class Code: ", "Error, Empty String!", this.scan);
        Class lClass = StudentManagement.findClassByCode(lClassCode, classList);
        if (!lClass.getCode().equalsIgnoreCase(lClassCode)) {
            System.out.println("Error, Class Not Found!");
            return false;
        }
        String lAddr = Input.inputAndCheckNotEmpty("Enter Address: ", "Error, Empty String!", this.scan);
        this.setName(localName);
        this.setClasss(lClass);
        this.setAddr(lAddr);
        return true;
    }
}
