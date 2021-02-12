package com.example.demo.database.service;

import com.example.demo.database.school.SchoolMapper;
import com.example.demo.database.school.dto.SchoolDto;
import com.example.demo.database.school.repository.SchoolRepository;
import com.example.demo.ministry.MinistryRequestToDatabase;
import com.example.demo.student.StudentRequestToDatabase;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DatabaseService implements StudentRequestToDatabase, MinistryRequestToDatabase {
    SchoolRepository schoolRepository;
    SchoolMapper mapper;

    @Override
    public SchoolDto getSchoolById(int id) throws NoSuchElementException {
        return schoolRepository.findById(id).map(mapper.INSTANCE::mapToDto).orElseThrow(() -> new NoSuchElementException("Не найдена школа с id = " + id));
    }


    @Override
    public void deleteSchool(int id) throws NoSuchElementException {
        try {
            schoolRepository.deleteById(id);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Can't delete school - " + id);
        }
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<SchoolDto> getAllSchool() {
        return (schoolRepository
                .findAll())
                .stream()
                .map(mapper.INSTANCE::mapToDto)
                .collect(Collectors.toList());
    }
}
