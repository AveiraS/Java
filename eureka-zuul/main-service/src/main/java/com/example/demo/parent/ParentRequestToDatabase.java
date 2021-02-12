package com.example.demo.parent;

import com.example.demo.database.school.repository.SchoolRepository;
import com.example.demo.database.student.dto.StudentDto;

import java.util.NoSuchElementException;


/**
 * Интерфейс взаимодействует с репозеторием {@link SchoolRepository}
 */
public interface ParentRequestToDatabase {
    /**
     * Извлекает объект по его идентификатору.
     * @param id пользователя, по которому будет производиться поиск.
     * @return StudentDto конвертированный объект, который дублирует студента таблицы Students
     * @throws NoSuchElementException если не был найден элемент с заданным id
     */
    StudentDto getStudentById(int id);
}
