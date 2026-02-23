package com.example.studentregistraction.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.studentregistraction.dto.StudentCreateRequest;
import com.example.studentregistraction.dto.StudentResponse;
import com.example.studentregistraction.entity.Student;
import com.example.studentregistraction.exception.ResourceNotFoundException;
import com.example.studentregistraction.repository.StudentRepository;
import com.example.studentregistraction.service.StudentService;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentResponse create(StudentCreateRequest req) {
        
        validateAge(req.getAge());

        Student student =  new Student();
        student.setStudentCode(req.getStudentCode());
        student.setFullName(req.getFullName());
        student.setEmail(req.getEmail());
        student.setAge(req.getAge());
        student.setCreatedAt(new Date());

        studentRepository.save(student);

        return null;
    }

    @Override
    @Transactional
    public void deleteByCode(String studentCode) { 

        if (!studentRepository.existsByStudentCode(studentCode)) {
            throw new ResourceNotFoundException("Cannot delete. Student not found with code: " + studentCode);
        }

        studentRepository.deleteByStudentCode(studentCode);
    }

    @Override
    public StudentResponse findByCode(String studentCode) {
        
        StudentResponse studentResponse = new StudentResponse();
        Optional<Student> student = studentRepository.findByStudentCode(studentCode);

        if (student.isEmpty()) {
            throw new ResourceNotFoundException("Student not found with code: " + studentCode);
        }

        studentResponse.setFullName(student.get().getFullName());
        studentResponse.setEmail(student.get().getEmail());
        studentResponse.setAge(student.get().getAge());

        return studentResponse;
    }

    @Override
    public List<StudentResponse> searchByName(String keyword) {
        List<Student> students = studentRepository.findByFullNameContainingIgnoreCase(keyword);

        if (students.isEmpty()) {
            // Just throw the exception; no need for a return statement here
            throw new ResourceNotFoundException("Student not found with keyword: " + keyword);
        }

        List<StudentResponse> studentResponses = new ArrayList<>();
        
        for (Student student : students) {
            // You must map the Student entity data to your StudentResponse DTO
            StudentResponse response = new StudentResponse();
            response.setFullName(student.getFullName());
            response.setEmail(student.getEmail());
            response.setAge(student.getAge());
            
            studentResponses.add(response);
        }

        return studentResponses; // Return the populated list
    }

    @Override
    public StudentResponse updateByCode(String studentCode, StudentCreateRequest req) {
        
        Optional<Student> student = studentRepository.findByStudentCode(studentCode);

        if (student.isEmpty()) {
            throw new ResourceNotFoundException("Student not found with code: " + studentCode);
        }

        validateAge(req.getAge());

        Student updaStudent = student.get();
        updaStudent.setFullName(req.getFullName());
        updaStudent.setEmail(req.getEmail());
        updaStudent.setAge(req.getAge());

        studentRepository.saveAndFlush(updaStudent);

        return null;
    }

    private void validateAge(int age) {
        if(age < 10 || age > 80) {
            throw new com.example.studentregistraction.exception.BadRequestException("Age must be between 10 and 80. Provided: " + age);
        }
    }

}
