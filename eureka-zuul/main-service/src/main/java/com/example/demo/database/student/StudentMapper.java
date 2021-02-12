package com.example.demo.database.student;

import com.example.demo.database.student.dto.StudentDto;
import com.example.demo.database.student.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Интерфес конвертирует сущность в дто и наоборот
 */
@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
    StudentDto mapToDto(Student entity);

    Student mapToStudent(StudentDto dto);
}
