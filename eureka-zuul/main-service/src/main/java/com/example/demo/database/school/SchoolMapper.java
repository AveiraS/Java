package com.example.demo.database.school;

import com.example.demo.database.school.dto.SchoolDto;
import com.example.demo.database.school.entity.School;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Интерфес конвертирует сущность в дто и наоборот
 */
@Mapper(componentModel = "spring")
public interface SchoolMapper {
    SchoolMapper INSTANCE = Mappers.getMapper(SchoolMapper.class);
    SchoolDto mapToDto(School entity);

    School mapToStudent(SchoolDto dto);
}
