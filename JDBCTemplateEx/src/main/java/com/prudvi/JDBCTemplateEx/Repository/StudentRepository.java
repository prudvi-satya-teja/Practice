package com.prudvi.JDBCTemplateEx.Repository;


import com.prudvi.JDBCTemplateEx.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class StudentRepository {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTable() {
        jdbcTemplate.execute("Create table faculty(id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(25), age INT)");
    }

    public List<Student> getData() {
        List<Student> l = jdbcTemplate.query("select * from faculty", (rs , rowNum) -> {
            Student s = new Student();
            s.setName(rs.getString("name"));
            s.setId(rs.getInt("id"));
            s.setAge(rs.getInt("age"));
            return s;
        });
        return l;

    }

    public List<String> getAllNames() {
        return jdbcTemplate.queryForList("select name from faculty", String.class);
    }

    public Student getById(int id) {
        return jdbcTemplate.queryForObject("select * from faculty where id  = ? ", new Object[]{id}, (rs, rowNum) -> {
            Student s = new Student();
            s.setName(rs.getString("name"));
            s.setId(rs.getInt("id"));
            s.setAge(rs.getInt("age"));
            return s;
        });
    }
}
