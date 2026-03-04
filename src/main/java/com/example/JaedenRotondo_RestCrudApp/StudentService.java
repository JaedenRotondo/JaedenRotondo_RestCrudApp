package com.example.JaedenRotondo_RestCrudApp;

import com.example.JaedenRotondo_RestCrudApp.entity.Student;
import com.example.JaedenRotondo_RestCrudApp.repository.StudentRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Student findById(Integer id){
        return studentRepository.findById(id).orElse(null);
    }

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }
    public Student updateStudent(Student updatedStudent, Integer id) {
        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return null;
        }

        student.setName(updatedStudent.getName());
        student.setFees(updatedStudent.getFees());
        student.setSubName(updatedStudent.getSubName());
        return studentRepository.save(student);
    }

    public void delete(Student student) {
        studentRepository.delete(student);
    }

}
