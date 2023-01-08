/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.project7;

import com.project.validation.Input;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author Ann
 */
public class StudentManagement {

    //Khai bao bien nay de auto generate ID khong bi trung nhau
    private static AtomicLong idCounter = new AtomicLong();
    //List sinh vien, luu tru tat ca sinh vien trong chuong trinh
    private LinkedList<Student> students = new LinkedList<>();
    //List lop, luu tru tat ca lop trong chuong trinh
    private LinkedList<Class> classes = new LinkedList<>();
    //List mon hoc, luu tru tat ca mon hoc trong chuong trinh
    private LinkedList<Course> courses = new LinkedList<>();
    //List diem so, luu tru tat ca diem so trong chuong trinh
    private LinkedList<Score> scores = new LinkedList<>();
    private Scanner scan = new Scanner(System.in);

    /**
     * Create New Student.
     *
     * @param classList List of Class
     */
    public void createStudent(LinkedList<Class> classList) {
        System.out.println("==============> CREATE NEW STUDENT <==============");
        Student student = new Student();
        try {
            //Su dung ham input cua obj de nhap thong tin va nhan ve status
            boolean status = student.input(classList);
            //Neu staut = false la nhap thong tin that bai, bao loi va ket thuc
            if (!status) {
                return;
            }
            //Neu true thi bao thang cong va them vao list luu tru
            this.students.add(student);
            System.out.println("Student Created");
        } catch (Exception e) {
            System.out.println("Sometimes Went Wrong!");
        }
    }

    /**
     * Create New Class.
     */
    public void createClass() {
        //Tuong tu ham tao khac
        System.out.println("==============> CREATE NEW CLASS <==============");
        Class clss = new Class();
        try {
            boolean status = clss.input();
            if (!status) {
                return;
            }
            this.classes.add(clss);
            System.out.println("Class Created");
        } catch (Exception e) {
            System.out.println("Sometimes Went Wrong!");
        }
    }

    /**
     * Create New Course.
     *
     */
    public void createCourse() {
        //Tuong tu ham tao khac
        System.out.println("==============> CREATE NEW COURSE <==============");
        Course c = new Course();
        try {
            boolean status = c.input();
            if (!status) {
                return;
            }
            this.courses.add(c);
            System.out.println("Course Created");
        } catch (Exception e) {
            System.out.println("Sometimes Went Wrong!");
        }
    }

    /**
     * Create New Score.
     *
     * @param stuList List of Student
     * @param courseList List of Course
     */
    public void createScore(LinkedList<Student> stuList, LinkedList<Course> courseList) {
        System.out.println("==============> CREATE NEW SCORE <==============");
        Score score = new Score();
        try {
            //Su dung ham input cua obj de nhap thong tin va nhan ve status
            boolean status = score.input(stuList, courseList);
            //Neu staut = false la nhap thong tin that bai, bao loi va ket thuc
            if (!status) {
                return;
            }
            //Neu true thi bao thang cong va them vao list luu tru
            this.scores.add(score);
            System.out.println("Score Created");
        } catch (Exception e) {
            System.out.println("Sometimes Went Wrong!");
        }
    }

    /**
     * Edit A Student.
     *
     * @param stuList List of Student
     */
    public void editStudent(LinkedList<Student> stuList) {
        System.out.println("==============> EDIT A STUDENT <==============");
        //Nhap ma de xac dinh can edit sinh vien nao
        String stuID = Input.inputAndCheckNotEmpty("Enter Student Id: ", "Error, Empty String!", scan);
        //Tim xem sinh vien do co ton tai khong
        for (int i = 0; i < stuList.size(); i++) {
            //Neu co thi cho edit lai thong tin
            if (stuList.get(i).getId().equalsIgnoreCase(stuID)) {
                boolean status = stuList.get(i).edit(classes);
                //Kiem tra thong tin edit dung dinh dang khong
                if (!status) {
                    //Neu khon bao loi, ket thuc
                    return;
                }
                //Neu OK
                System.out.println("Infomation Updated");
                return;
            }
        }
    }

    /**
     * Edit A Class.
     *
     * @param classList List of Class
     */
    public void editClass(LinkedList<Class> classList) {
        System.out.println("==============> EDIT A CLASS <==============");
        //Nhap ma de xac dinh can edit class nao
        String classCode = Input.inputAndCheckNotEmpty("Enter Class Code: ", "Error, Empty String!", scan);
        //Tim xem class do co ton tai khong
        for (int i = 0; i < classList.size(); i++) {
            //Neu co thi cho edit lai thong tin
            if (classList.get(i).getCode().equalsIgnoreCase(classCode)) {
                boolean status = classList.get(i).edit();
                //Kiem tra thong tin edit dung dinh dang khong
                if (!status) {
                    //Neu khong bao loi, ket thuc
                    return;
                }
                //Neu OK
                System.out.println("Infomation Updated");
                return;
            }
        }
    }

    /**
     * Edit A Course.
     *
     * @param courseList List of Course
     */
    public void editCourse(LinkedList<Course> courseList) {
        System.out.println("==============> EDIT A CLASS <==============");
        //Nhap ma de xac dinh can edit course nao
        String courseCode = Input.inputAndCheckNotEmpty("Enter Course Code: ", "Error, Empty String!", scan);
        //Tim xem course do co ton tai khong
        for (int i = 0; i < courseList.size(); i++) {
            //Neu co thi cho edit lai thong tin
            if (courseList.get(i).getCode().equalsIgnoreCase(courseCode)) {
                boolean status = courseList.get(i).edit();
                //Kiem tra thong tin edit dung dinh dang khong
                if (!status) {
                    //Neu khong bao loi, ket thuc
                    return;
                }
                //Neu OK
                System.out.println("Infomation Updated");
                return;
            }
        }
    }

    /**
     * Edit A Score.
     *
     * @param scoreList List of Score
     */
    public void editScore(LinkedList<Score> scoreList) {
        System.out.println("==============> EDIT A SCORE <==============");
        //Nhap ma de xac dinh can edit score nao
        String scoreId = Input.inputAndCheckNotEmpty("Enter Score Id: ", "Error, Empty String!", scan);
        //Tim xem course do co ton tai khong
        for (int i = 0; i < scoreList.size(); i++) {
            //Neu co thi cho edit lai thong tin
            if (scoreList.get(i).getId().equalsIgnoreCase(scoreId)) {
                System.out.println("Student Name: " + scoreList.get(i).getStudent().getName());
                System.out.println("Course: " + scoreList.get(i).getCourse().getName());
                System.out.println("Score: " + scoreList.get(i).getScore());
                boolean status = scoreList.get(i).edit();
                //Kiem tra thong tin edit dung dinh dang khong
                if (!status) {
                    //Neu khong bao loi, ket thuc
                    return;
                }
                //Neu OK
                System.out.println("Infomation Updated");
                return;
            }
        }
    }

    /**
     * Delete A Student.
     *
     * @param stuList List of Student
     */
    public void delStudent(LinkedList<Student> stuList) {
        System.out.println("==============> DELETE A STUDENT <==============");
        //Nhap ma nhan vien de xac dinh sinh vien muon xoa
        String studentID = Input.inputAndCheckNotEmpty("Enter Student Id: ", "Error, Empty String!", scan);
        //Tim nhan vien do
        for (int i = 0; i < stuList.size(); i++) {
            //Neu co ton tai thi in thong tin cho xem
            if (stuList.get(i).getId().equalsIgnoreCase(studentID)) {
                //Neu co thi in ra thong tin cho nguoi ta doc
                System.out.println("Student ID: " + stuList.get(i).getId());
                System.out.println("Name: " + stuList.get(i).getName());
                System.out.println("Address: " + stuList.get(i).getAddr());
                System.out.println("Class: " + stuList.get(i).getClasss().getCode());
                //Hoi co chac chan xoa sinh vien khong -> Dung mau nhap lieu viet san
                if (Input.inputYesOrNo("Are you sure to delete? (y/n): ", "Only type yes or no please!", scan)) {
                    //Neu yes thi xoa
                    stuList.remove(stuList.get(i));
                    //Thanh cong
                    System.out.println("Delete Success");
                    return;
                }
                //Neu No thi thoi
                System.out.println("");
                return;
            }
        }

    }

    /**
     * Delete A Score.
     *
     * @param scoreList List of Score
     */
    public void delScore(LinkedList<Score> scoreList) {
        System.out.println("==============> DELETE A SCORE <==============");
        //Nhap ma nhan vien de xac dinh sinh vien muon xoa
        String scoreId = Input.inputAndCheckNotEmpty("Enter Score Id: ", "Error, Empty String!", scan);
        //Tim nhan vien do
        for (int i = 0; i < scoreList.size(); i++) {
            //Neu co ton tai thi in thong tin cho xem
            if (scoreList.get(i).getId().equalsIgnoreCase(scoreId)) {
                //Neu co thi in ra thong tin cho nguoi ta doc
                System.out.println("Score ID: " + scoreList.get(i).getId());
                System.out.println("Student Name: " + scoreList.get(i).getStudent().getName());
                System.out.println("Course Name: " + scoreList.get(i).getCourse().getName());
                System.out.println("Score: " + scoreList.get(i).getScore());
                //Hoi co chac chan xoa sinh vien khong -> Dung mau nhap lieu viet san
                if (Input.inputYesOrNo("Are you sure to delete? (y/n): ", "Only type yes or no please!", scan)) {
                    //Neu yes thi xoa
                    scoreList.remove(scoreList.get(i));
                    //Thanh cong
                    System.out.println("Delete Success");
                    return;
                }
                //Neu No thi thoi
                System.out.println("");
                return;
            }
        }

    }

    /**
     * Delete A Course.
     *
     * @param courseList List of Course
     */
    public void delCourse(LinkedList<Course> courseList) {
        System.out.println("==============> DELETE A COURSE <==============");
        //Nhap ma nhan vien de xac dinh sinh vien muon xoa
        String courseCode = Input.inputAndCheckNotEmpty("Enter Course Code: ", "Error, Empty String!", scan);
        //Tim nhan vien do
        for (int i = 0; i < courseList.size(); i++) {
            //Neu co ton tai thi in thong tin cho xem
            if (courseList.get(i).getCode().equalsIgnoreCase(courseCode)) {
                //Neu co thi in ra thong tin cho nguoi ta doc
                System.out.println("Course Code: " + courseList.get(i).getCode());
                System.out.println("Course Name: " + courseList.get(i).getName());
                System.out.println("Major: " + courseList.get(i).getMajor());
                //Hoi co chac chan xoa sinh vien khong -> Dung mau nhap lieu viet san
                if (Input.inputYesOrNo("Are you sure to delete? (y/n): ", "Only type yes or no please!", scan)) {
                    //Neu yes thi xoa
                    courseList.remove(courseList.get(i));
                    //Thanh cong
                    System.out.println("Delete Success");
                    return;
                }
                //Neu No thi thoi
                System.out.println("");
                return;
            }
        }

    }

    /**
     * Delete A Class.
     *
     * @param classList List of Class
     */
    public void delClass(LinkedList<Class> classList) {
        System.out.println("==============> DELETE A CLASS <==============");
        //Nhap ma nhan vien de xac dinh sinh vien muon xoa
        String classCode = Input.inputAndCheckNotEmpty("Enter Class Code: ", "Error, Empty String!", scan);
        //Tim nhan vien do
        for (int i = 0; i < classList.size(); i++) {
            //Neu co ton tai thi in thong tin cho xem
            if (classList.get(i).getCode().equalsIgnoreCase(classCode)) {
                //Neu co thi in ra thong tin cho nguoi ta doc
                System.out.println("Class Code: " + classList.get(i).getCode());
                System.out.println("Class Name: " + classList.get(i).getName());
                System.out.println("Grade: " + classList.get(i).getGrade());
                //Hoi co chac chan xoa sinh vien khong -> Dung mau nhap lieu viet san
                if (Input.inputYesOrNo("Are you sure to delete? (y/n): ", "Only type yes or no please!", scan)) {
                    //Neu yes thi xoa
                    classList.remove(classList.get(i));
                    //Thanh cong
                    System.out.println("Delete Success");
                    return;
                }
                //Neu No thi thoi
                System.out.println("");
                return;
            }
        }

    }

    /**
     * Search Function.
     *
     * @param option 1 Student, 2 Class, 3 Course, 4 Score, other error
     */
    public void search(int option) {
        System.out.println("==============> SEARCHING <==============");
        //Bien de check co tim duoc ket qua khong.
        boolean isFound = false;
        //Nhap key de tim kiem
        System.out.print("Enter Key Word: ");
        String key = scan.nextLine();
        //option la tim cai gi, 1 Student, 2 Class, 3 Course, 4 Score
        switch (option) {
            case 1 -> {
                //Tim trong Student list
                for (Student e : students) {
                    //Neu tim thay thi in thong tin ra
                    if (e.getId().toLowerCase().contains(key.toLowerCase()) || e.getName().toLowerCase().contains(key.toLowerCase()) || e.getClasss().getCode().toLowerCase().contains(key.toLowerCase())) {
                        System.out.println("-------------------------------------------");
                        System.out.println("Student ID: " + e.getId());
                        System.out.println("Name: " + e.getName());
                        System.out.println("Class: " + e.getClasss().getCode());
                        System.out.println("Address: " + e.getAddr());
                        //Da thay ket qua thi sua bien check lai thanh true
                        isFound = true;
                    }
                }
            }
            case 2 -> {
                //Tim trong Class list
                for (Class e : classes) {
                    //Neu tim thay thi in thong tin ra
                    if (e.getCode().toLowerCase().contains(key.toLowerCase()) || e.getName().toLowerCase().contains(key.toLowerCase())) {
                        System.out.println("-------------------------------------------");
                        System.out.println("Class Code: " + e.getCode());
                        System.out.println("Class Name: " + e.getName());
                        System.out.println("Grade: " + e.getGrade());
                        //Da thay ket qua thi sua bien check lai thanh true
                        isFound = true;
                    }
                }
            }
            case 3 -> {
                //Tim trong course list
                for (Course e : courses) {
                    //Neu tim thay thi in thong tin ra
                    if (e.getCode().toLowerCase().contains(key.toLowerCase()) || e.getName().toLowerCase().contains(key.toLowerCase()) || e.getMajor().toLowerCase().contains(key.toLowerCase())) {
                        System.out.println("-------------------------------------------");
                        System.out.println("Course Code: " + e.getCode());
                        System.out.println("Course Name: " + e.getName());
                        System.out.println("Major: " + e.getMajor());
                        //Da thay ket qua thi sua bien check lai thanh true
                        isFound = true;
                    }
                }
            }
            case 4 -> {
                //Tim trong score list
                for (Score e : scores) {
                    //Neu tim thay thi in thong tin ra
                    if (e.getId().toLowerCase().contains(key.toLowerCase()) || e.getStudent().getName().toLowerCase().contains(key.toLowerCase()) || e.getCourse().getCode().toLowerCase().contains(key.toLowerCase()) || (e.getScore() + "").toLowerCase().contains(key.toLowerCase())) {
                        System.out.println("-------------------------------------------");
                        System.out.println("Score Id: " + e.getId());
                        System.out.println("Student Name: " + e.getStudent().getName());
                        System.out.println("Course Code: " + e.getCourse().getCode());
                        System.out.println("Score: " + e.getScore());
                        //Da thay ket qua thi sua bien check lai thanh true
                        isFound = true;
                    }
                }
            }
            //option khon ton tai
            default ->
                System.out.println("Invalid Option!");
        }
        //Neu khong co ket qua thi bien check van false, thi in ra khong tim thay
        if (!isFound) {
            System.out.println("Not Found!");
        }
    }

    /**
     * Show Menu and RUN.
     */
    public void mainMenu() {
        try {
            Scanner scan = new Scanner(System.in);
            int choose;
            do {
                System.out.print("==============> STUDENT SCORE MANAGEMENT SYSTEM <=============="
                        + "\n1. Create New Student"
                        + "\n2. Create New Class"
                        + "\n3. Create New Course"
                        + "\n4. Create New Score"
                        + "\n5. Edit Student"
                        + "\n6. Edit Class"
                        + "\n7. Edit Course"
                        + "\n8. Edit Score"
                        + "\n9. Delete Student"
                        + "\n10. Delete Class"
                        + "\n11. Delete Course"
                        + "\n12. Delete Score"
                        + "\n13. Show All Student"
                        + "\n14. Show All Class"
                        + "\n15. Show All Course"
                        + "\n16. Show All Score"
                        + "\n17. Search Student"
                        + "\n18. Search Class"
                        + "\n19. Search Course"
                        + "\n20. Search Score"
                        + "\n21. Exit"
                        + "\n   Please choose: ");
                choose = scan.nextInt();
                scan.nextLine();
                switch (choose) {
                    case 1 ->
                        createStudent(classes);
                    case 2 ->
                        createClass();
                    case 3 ->
                        createCourse();
                    case 4 ->
                        createScore(students, courses);
                    case 5 ->
                        editStudent(students);
                    case 6 ->
                        editClass(classes);
                    case 7 ->
                        editCourse(courses);
                    case 8 ->
                        editScore(scores);
                    case 9 ->
                        delStudent(students);
                    case 10 ->
                        delClass(classes);
                    case 11 ->
                        delCourse(courses);
                    case 12 ->
                        delScore(scores);
                    case 13 ->
                        showAllStudent(students);
                    case 14 ->
                        showAllClass(classes);
                    case 15 ->
                        showAllCourse(courses);
                    case 16 ->
                        showAllScore(scores);
                    case 17 ->
                        search(1);
                    case 18 ->
                        search(2);
                    case 19 ->
                        search(3);
                    case 20 ->
                        search(4);
                    case 21 ->
                        System.out.println("---Powered by Me!---");
                    default -> //Nhập ko đúng case thì hiện cái này.
                        System.out.println("Invalid option!");
                }
                //Nhập đúng case thì lập lại.
            } while (choose > 0 && choose < 22);
        } catch (InputMismatchException e) {
            //Nhập chữ hay &%*^ thì cho nhập lại luôn.
            System.out.println("Invalid option!");
            mainMenu();
        }
    }

    /**
     * Show all Student.
     *
     * @param stuList List of Student
     */
    public static void showAllStudent(LinkedList<Student> stuList) {
        System.out.println("==============> SHOW ALL STUDENT <==============");
        //Quet het list va in ra thong tin bang ham toString cua obj
        for (Student e : stuList) {
            System.out.println(e.toString());
        }
    }

    /**
     * Show all Class.
     *
     * @param classList List of Class
     */
    public static void showAllClass(LinkedList<Class> classList) {
        System.out.println("==============> SHOW ALL CLASS <==============");
        //Quet het list va in ra thong tin bang ham toString cua obj

        for (Class e : classList) {
            System.out.println(e.toString());
        }
    }

    /**
     * Show all Course.
     *
     * @param courseList List of Course
     */
    public static void showAllCourse(LinkedList<Course> courseList) {
        System.out.println("==============> SHOW ALL COURSE <==============");
        //Quet het list va in ra thong tin bang ham toString cua obj

        for (Course e : courseList) {
            System.out.println(e.toString());
        }
    }

    /**
     * Show all Score.
     *
     * @param scoreList List of Score
     */
    public static void showAllScore(LinkedList<Score> scoreList) {
        System.out.println("==============> SHOW ALL SCORE <==============");
        //Quet het list va in ra thong tin bang ham toString cua obj

        for (Score e : scoreList) {
            System.out.println(e.toString());
        }
    }

    /**
     * Auto Generate Unique ID.
     *
     * @return Unique ID
     */
    public static String generateId() {
        //Random 1 so chua 4 chu so
        String randomID = ThreadLocalRandom.current().nextInt(1000, 9998 + 1) + "";
        //Ghep 4 so vua random voi 1 so duy nhat cua bien idCounter da tao o tren -> Khong bao gio bi trung
        return randomID + String.valueOf(idCounter.getAndIncrement());
    }

    /**
     * Find Student By Student Id.
     *
     * @param id Student Id
     * @param stuList List of Student
     * @return Student Found or Empty Student
     */
    public static Student findStudentById(String id, LinkedList<Student> stuList) {
        for (Student c : stuList) {
            if (c.getId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return new Student("", "", "", new Class());
    }

    /**
     * Find Class By Class Code.
     *
     * @param code Class Code
     * @param classList List of Class
     * @return Class Found or Empty Class
     */
    public static Class findClassByCode(String code, LinkedList<Class> classList) {
        for (Class c : classList) {
            if (c.getCode().equalsIgnoreCase(code)) {
                return c;
            }
        }
        return new Class("", "", 0);
    }

    /**
     * Find Course By Course Code.
     *
     * @param code Course Code
     * @param courseList List of Course
     * @return Course Found or Empty Course
     */
    public static Course findCourseByCode(String code, LinkedList<Course> courseList) {
        for (Course c : courseList) {
            if (c.getCode().equalsIgnoreCase(code)) {
                return c;
            }
        }
        return new Course("", "", "");
    }

}
