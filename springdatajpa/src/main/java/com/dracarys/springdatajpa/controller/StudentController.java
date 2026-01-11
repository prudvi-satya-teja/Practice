package com.dracarys.springdatajpa.controller;
import com.dracarys.springdatajpa.entity.Student;
import com.dracarys.springdatajpa.service.StudentService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;


@RestController
public class StudentController {

    StudentService studentService;

    @Autowired
    StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add-students")
    public ResponseEntity<Void> addStudents(@RequestBody List<Student> students) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/add-student")
    public ResponseEntity<Void> addStudent(@RequestBody Student student) {
        throw new NullPointerException();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudentByID(@PathVariable Long id) {
            throw new CustomException(HttpStatus.BAD_GATEWAY, "get student by id error");
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> deleteStudentByID(@PathVariable Long id) {
        boolean deleted = studentService.deleteStudentByID(id);
        if(!deleted)  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ExceptionHandler(CustomException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "response status handled")
    public Void handleCustomException(HttpServletResponse response, Exception ex) throws IOException {
//        System.out.println(ex.getStatus().value());
//        System.out.println(ex.getMessage());
//        return ResponseEntity.status(ex.getStatus()).body("not bad from controller level");
//          response.sendError(HttpStatus.BAD_GATEWAY.value(), "Hello");
//
//        return null;
        return null;
    }

//
//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException ex) {
//        System.out.println(ex);
//        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "not bad from controller level", new Date());
//        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(errorResponse);
//    }

}
