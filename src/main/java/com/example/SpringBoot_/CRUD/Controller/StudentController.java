package com.example.SpringBoot_.CRUD.Controller;

import com.example.SpringBoot_.CRUD.Model.StudentModel;
import com.example.SpringBoot_.CRUD.Service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Slf4j
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentModel> getAllStudents() {
        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentModel> getStudentById(@PathVariable Integer id) {
        StudentModel student = studentService.getStudentById(id);
        if(student==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
    @PostMapping
    public ResponseEntity<StudentModel> createStudent(@RequestBody StudentModel studentModel) {
        StudentModel created = studentService.createStudent(studentModel);
        return ResponseEntity.ok(created);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentModel> updateStudent(@PathVariable Integer id, @RequestBody StudentModel studentModel) {
        StudentModel update = studentService.updateStudent(id, studentModel);
        if(update==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(update);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        boolean deleted = studentService.deleteStudent(id);
        if(!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
