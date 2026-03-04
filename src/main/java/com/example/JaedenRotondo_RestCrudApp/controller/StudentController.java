package com.example.JaedenRotondo_RestCrudApp.controller;

import com.example.JaedenRotondo_RestCrudApp.StudentService;
import com.example.JaedenRotondo_RestCrudApp.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/students")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> findAll(){
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Student> findById(@PathVariable int id){
        return Optional.ofNullable(studentService.findById(id));
    }

    @PostMapping
    public Student save(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    public Student update(@RequestBody Student student, @PathVariable int id){
        return studentService.updateStudent(student, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        Student student = studentService.findById(id);
        if(student != null){
            studentService.delete(student);
        }
    }

}
