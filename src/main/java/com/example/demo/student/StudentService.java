package com.example.demo.student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        // To-do: Logic
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId){
        // To-do: Logic
        studentRepository.deleteById(studentId);
    }
}
