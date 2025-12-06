package com.example.SpringBoot_.CRUD.Service;

import com.example.SpringBoot_.CRUD.Model.StudentModel;
import com.example.SpringBoot_.CRUD.Repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<StudentModel> getAllStudents() {
        return studentRepo.findAll();
    }
    public StudentModel getStudentById(Integer id) {
        return studentRepo.findById(id).orElse(null);
    }
    public StudentModel createStudent(StudentModel studentModel) {
        return studentRepo.save(studentModel);
    }
    public StudentModel updateStudent(Integer id, StudentModel studentModel) {
        Optional<StudentModel> optionalStudent = studentRepo.findById(id);
        if(optionalStudent.isEmpty()) {
            return null;
        }
        StudentModel updateStudent = optionalStudent.get();
        updateStudent.setName(studentModel.getName());
        updateStudent.setAge(studentModel.getAge());
        updateStudent.setEmail(studentModel.getEmail());
        return studentRepo.save(updateStudent);
    }
    public boolean deleteStudent(Integer id) {
        if(!studentRepo.existsById(id)) {
            return false;
        }
        studentRepo.deleteById(id);
        return true;
    }
}
