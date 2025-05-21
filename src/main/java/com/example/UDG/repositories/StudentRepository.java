package com.example.UDG.repositories;

import com.example.UDG.Models.StudentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface StudentRepository extends CrudRepository<StudentModel, Long> {
    public abstract ArrayList<StudentModel> findByCode(Integer code);
    public abstract ArrayList<StudentModel> findByName(String name);
}
