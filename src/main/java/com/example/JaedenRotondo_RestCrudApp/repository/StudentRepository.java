package com.example.JaedenRotondo_RestCrudApp.repository;

import com.example.JaedenRotondo_RestCrudApp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
