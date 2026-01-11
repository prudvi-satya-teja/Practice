package com.dracarys.springjdbc.repository;


import com.dracarys.springjdbc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.createTable();
    }

    public void createTable() {
        jdbcTemplate.execute("create table IF NOT EXISTS student(id INTEGER AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), email VARCHAR(50))");
    }
    
    // get all student
    public List<Student> getAllStudents() {
        String sql = "select * from student";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setEmail(rs.getString("email"));
            return student;
        });
    }

    // insert
    public void insertStudent(Student student) {
        String sql = "insert into student(name, email) values(?, ?)";
        int cnt = jdbcTemplate.update(sql, student.getName(), student.getEmail());
        System.out.println(cnt+ "rows affected");
    }

    // update
    public void updateStudent(Student student, int id) {
        String sql = "update student set name = ?, email = ? where id = ?";
        jdbcTemplate.update(sql, student.getName(), student.getEmail(), id);
    }

    // delete
    public void deleteStudent(int id) {
        String sql = "delete from student where id = ?";
        jdbcTemplate.update(sql, id);
    }

    // get all students
    public Student getStudentById(int id) {
        String sql = "select * from student where id = ?";
//        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Student.class), id);
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Student.class));

    }

    // use all methods for jdbcTemplate
}
