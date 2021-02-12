package com.example.demo.director;

import com.example.demo.database.student.dto.StudentDto;
import com.example.demo.student.StudentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DirectorServiceImpl implements DirectorService {
    StudentService studentService;

    public StudentDto returnStudentById(int id) throws IllegalArgumentException{
        //Логика проверки запроса
        if (id <= 0)
            throw new IllegalArgumentException("Invalid id = " + id + "; Must be positive.");
       return studentService.getStudentInfo(id);
    }

    public List<StudentDto> returnAllStudent(int id) throws IllegalArgumentException{
        if (id <= 0)
            throw new IllegalArgumentException("Invalid id = " + id + "; Must be positive.");
        //Логика проверки запроса
       return studentService.takeAllStudentInSchool(id);
    }

    public boolean addStudentInSchool(StudentDto studentDto, int schoolId) throws IllegalArgumentException{
        if (studentDto == null)
            throw new IllegalArgumentException("Invalid student, can't be null");
        if (schoolId <= 0)
            throw new IllegalArgumentException("Invalid id = " + schoolId + "; Must be positive.");
        //Логика проверки запроса
        studentService.addStudentInSchool(studentDto);
        return true;
    }

    public List<StudentDto> returnAllStudent() throws IllegalArgumentException{
        //Логика проверки запроса
//        return studentService.getAllStudent();
        return null;
    }

    public void deleteStudentById(int id) throws IllegalArgumentException{
        //Логика проверки запроса
        if (id <= 0)
            throw new IllegalArgumentException("Invalid id = " + id + "; Must be positive.");
//        studentService.deleteStudent(id);
    }
}
