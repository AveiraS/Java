package com.example.demo.student;

import com.example.demo.database.student.dto.StudentDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRequestToDatabase databaseService;
    private final RestClient restClient;


    @Override
    public StudentDto getStudentInfo(int id) throws IllegalArgumentException{
        if (id <= 0)
            throw new IllegalArgumentException("Invalid id = " + id + "; Must be positive.");
        return restClient.takeStudentInfo(id);
    }

    @Override
    public void addStudentInSchool(StudentDto studentDto) throws IllegalArgumentException{
        if (studentDto == null)
            throw new IllegalArgumentException("Invalid student, can't be null");
        if (studentDto.getSchoolId() <= 0)
            throw new IllegalArgumentException("Invalid id = " + studentDto.getSchoolId() + "; Must be positive.");
        if (databaseService.getSchoolById(studentDto.getSchoolId()) == null)
            throw new NoSuchElementException("There is no school with id = " + studentDto.getSchoolId());
        restClient.makeNewStudent(studentDto);
    }

    @Override
    public List<StudentDto> takeAllStudentInSchool(int id) throws IllegalArgumentException {
        if (id <= 0)
            throw new IllegalArgumentException("Invalid id = " + id + "; Must be positive.");
        return restClient.getAllStudent(id);
    }
}
