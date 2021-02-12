package com.example.demo.map;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
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
