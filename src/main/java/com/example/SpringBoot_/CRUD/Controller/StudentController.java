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
    public StudentModel getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }
    @PostMapping
    public StudentModel createStudent(@RequestBody StudentModel studentModel) {
        return studentService.createStudent(studentModel);
    }
    @PutMapping("/{id}")
    public StudentModel updateStudent(@PathVariable Integer id, @RequestBody StudentModel studentModel) {
        return studentService.updateStudent(id, studentModel);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }
}
