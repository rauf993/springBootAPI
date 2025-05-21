package com.example.UDG.controlles;

import com.example.UDG.Models.StudentModel;
import com.example.UDG.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping()
    public ArrayList<StudentModel> findAllStudents(){
        return studentService.findAllStudents();
    }

    @GetMapping(path = "/{id}")
    public Optional<StudentModel> findStudentById(@PathVariable Long id){
        return studentService.findById(id);
    }

    @GetMapping(path = "/search")
    public ArrayList<StudentModel> findByName(@RequestParam String name){
        return studentService.findByName(name);
    }

    @PostMapping
    public StudentModel saveStudent(@RequestBody StudentModel student){
        return studentService.saveStudent(student);
    }

    @PutMapping(path = "/{id}")
    public StudentModel updateStudent(@PathVariable Long id, @RequestBody StudentModel student){
        student.setId(id);
        return studentService.saveStudent(student);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteStudent(@PathVariable Long id){
        boolean ok = studentService.deleteStudent(id);
        if(ok){
            return "Student with id " + id + " was deleted";
        }else{
            return "Error deleting student with id " + id;
        }
    }
}