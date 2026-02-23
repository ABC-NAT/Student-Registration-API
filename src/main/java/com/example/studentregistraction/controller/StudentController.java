package com.example.studentregistraction.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentregistraction.dto.StudentCreateRequest;
import com.example.studentregistraction.dto.StudentResponse;
import com.example.studentregistraction.service.StudentService;

@RestController
@RequestMapping("api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponse> create(@RequestBody StudentCreateRequest req) {

        StudentResponse studentResponse = studentService.create(req);

        return new ResponseEntity<>(studentResponse,HttpStatus.CREATED);

    }

    // 1. GET by Student Code: /api/students/STU001
    @GetMapping("/{studentCode}")
    public ResponseEntity<StudentResponse> findByCode(@PathVariable String studentCode) {

        return ResponseEntity.ok(studentService.findByCode(studentCode));
    }

    // 2. Search by Name: /api/students/search?keyword=John
    @GetMapping("/search")
    public ResponseEntity<List<StudentResponse>> searchByName(@RequestParam String keyword) {
        return ResponseEntity.ok(studentService.searchByName(keyword));
    }

    @PutMapping("/{studentCode}")
    public ResponseEntity<StudentResponse> updateByCode(@PathVariable String studentCode, @RequestBody StudentCreateRequest updateRequest) {
        
        StudentResponse response = studentService.updateByCode(studentCode, updateRequest);

        return ResponseEntity.ok(response);
        
    }

    @DeleteMapping("/{studentCode}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByCode(@PathVariable String studentCode) {
        studentService.deleteByCode(studentCode);
    }


}
