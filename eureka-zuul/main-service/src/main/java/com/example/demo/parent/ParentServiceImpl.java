package com.example.demo.parent;

import com.example.demo.database.student.dto.StudentDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ParentServiceImpl implements ParentService {
//    ParentRequestToDatabase parentService;

    public StudentDto returnStudentById(int id) throws IllegalArgumentException{
        if (id <= 0)
            throw new IllegalArgumentException("Invalid id = " + id + "; Must be positive.");
        //Логика проверки запроса
        return null;
    }
}
