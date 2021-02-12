package com.example.demo.student;

import com.example.demo.database.school.dto.SchoolDto;
import com.example.demo.database.school.repository.SchoolRepository;

import java.util.NoSuchElementException;

/**
 * Интерфейс взаимодействует с репозеторием {@link SchoolRepository}
 */
public interface StudentRequestToDatabase {
    /**
     * Возвращает школу таблицы School через переданный идентификатор
     * @param id идентификатор возвращаемой школы.
     * @throws NoSuchElementException если школы по переданному id не существует
     */
    SchoolDto getSchoolById(int id);
}
