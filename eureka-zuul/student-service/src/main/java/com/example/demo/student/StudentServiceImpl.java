package com.example.demo.student;

import com.example.demo.database.StudentDto;
import com.example.demo.database.service.DatabaseService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentServiceImpl implements StudentService {
    DatabaseService studentService;

    public StudentDto returnStudentById(int id) throws IllegalArgumentException{
        if (id <= 0)
            throw new IllegalArgumentException("Invalid id = " + id + "; Must be positive.");
        return studentService.getStudentById(id);
    }

    @Override
    public void addStudent(StudentDto studentDto) {
        if (studentDto == null)
            throw new IllegalArgumentException("Invalid student, can't be null");
        studentService.addStudent(studentDto);
    }

    @Override
    public List<StudentDto> takeAllBySchool(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("Invalid id = " + id + "; Must be positive.");
        return studentService.getAllStudentBySchoolId(id);
    }
}
