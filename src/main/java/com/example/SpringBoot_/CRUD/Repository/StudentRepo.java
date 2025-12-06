package com.example.SpringBoot_.CRUD.Repository;

import com.example.SpringBoot_.CRUD.Model.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentModel, Integer> {

}
