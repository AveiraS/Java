package com.example.demo.student;

import com.example.demo.database.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto returnStudentById(int id);

    void addStudent(StudentDto studentDto);

    List<StudentDto> takeAllBySchool(int id);
}
