package com.example.demo.student;

import com.example.demo.student.exception.BadRequestException;
import com.example.demo.student.exception.StudentNotFoundException;
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
        Boolean existsEmail = studentRepository
                .selectExistsEmail(student.getEmail());
        if(existsEmail) {
            throw new BadRequestException(
                    "The email " + student.getEmail() + "is already taken"
            );
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId){
        if(!studentRepository.existsById(studentId)){
            throw new StudentNotFoundException(
                    "The requested Id: " + studentId + " does not exist"
            );
        }
        studentRepository.deleteById(studentId);
    }
}
