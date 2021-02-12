package com.example.demo.service;

import com.example.demo.dto.SchoolDto;

import java.util.NoSuchElementException;

/**
 * Интерфейс методов операций CRUD над таблицей Schools
 */
public interface SchoolService {
    /**
     * Извлекает объект по его идентификатору.
     * @param id школы, по которому будет производиться поиск.
     * @return SchoolDto конвертированный объект, который дублирует школу из таблицы Schools
     * @throws NoSuchElementException если школы с переданным id не существует
     */
    public SchoolDto getSchoolDtoById(int id);
}
