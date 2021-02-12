package com.example.demo.service;

import com.example.demo.map.SchoolMapper;
import com.example.demo.dto.SchoolDto;

import com.example.demo.repository.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * Класс SchoolServiceImpl обертка над репозеторным слоем, которая принимает
 * запросы из внешнего мира и выполняет операции CRUD над таблицей Schools
 */
@Service
public class SchoolServiceImpl implements SchoolService {

    private SchoolRepository schoolRepository;
    private SchoolMapper mapper;

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public SchoolDto getSchoolDtoById(int id) throws NoSuchElementException{
        return schoolRepository.findById(id).map(mapper.INSTANCE::mapToDto).orElseThrow(() -> new NoSuchElementException("Не найдена школа с id = " + id));
    }
}
