package com.dracarys.springjdbc.repository;

import com.dracarys.springjdbc.entity.Student;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepositoryJDBC {

    public StudentRepositoryJDBC() {
        this.createTable();
    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/springboot", "root", "3495");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createTable() {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("create table IF NOT EXISTS Student(id INTEGER AUTO_INCREMENT PRIMARY KEY, name VARCHAR(30), email VARCHAR(30))");
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void insertStudent(Student student) {
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement("insert into  student(name, email) values(?,?)");
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            int cnt = pstmt.executeUpdate();
            System.out.println(cnt + "record inserted");
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student, int id) {
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement("update student set name = ?, email = ? where id = ?");
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            pstmt.setInt(3, id);
            int cnt = pstmt.executeUpdate();
            System.out.println(cnt);
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Student getStudentById(int id) {

        Student student = new Student();
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement("Select * from student where id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()) {
                student.setId(rs.getInt("id"));
                student.setName(rs.getString( "name"));
                student.setEmail(rs.getString("email"));
                return student;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from student");
            while(rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                students.add(student);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public void deleteStudent(int id) {
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement("delete from student where id = ?");
            pstmt.setInt(1, id);
            int cnt = pstmt.executeUpdate();
            System.out.println(cnt + "record deleted");
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }
}
