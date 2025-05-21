package com.example.UDG.services;

import com.example.UDG.Models.StudentModel;
import com.example.UDG.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public ArrayList<StudentModel> findAllStudents(){
        return (ArrayList<StudentModel>) studentRepository.findAll();
    }

    public Optional<StudentModel> findById(Long id){
        return studentRepository.findById(id);
    }

    public StudentModel saveStudent(StudentModel student){
        return studentRepository.save(student);
    }

    public ArrayList<StudentModel> findByName(String name){
        return studentRepository.findByName(name);
    }

    public ArrayList<StudentModel> findByCode(Integer code){
        return studentRepository.findByCode(code);
    }

    public boolean deleteStudent(Long id){
        try{
            studentRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}