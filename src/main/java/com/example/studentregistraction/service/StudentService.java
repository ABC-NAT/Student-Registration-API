package com.example.studentregistraction.service;

import java.util.List;


import com.example.studentregistraction.dto.StudentCreateRequest;
import com.example.studentregistraction.dto.StudentResponse;

public interface StudentService {

    StudentResponse create(StudentCreateRequest req);

    StudentResponse updateByCode(String studentCode, StudentCreateRequest req);

    StudentResponse findByCode(String studentCode);

    List<StudentResponse> searchByName(String keyword);

    void deleteByCode(String studentCode);

}
