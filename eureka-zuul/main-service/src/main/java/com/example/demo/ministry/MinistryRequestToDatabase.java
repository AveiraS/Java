package com.example.demo.ministry;

import com.example.demo.database.school.dto.SchoolDto;
import com.example.demo.database.school.repository.SchoolRepository;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Интерфейс взаимодействует с репозеторием {@link SchoolRepository}
 */
public interface MinistryRequestToDatabase {
    /**
     * Извлекает объект по его идентификатору.
     * @param id школы, по которому будет производиться поиск.
     * @return SchoolDto конвертированный объект, который дублирует школу из таблицы Schools
     * @throws NoSuchElementException если школы с переданным id не существует
     */
    SchoolDto getSchoolById(int id);
    /**
     * Удаляет школу таблицы School через переданный идентификатор
     * @param id идентификатор удаляемй школы.
     * @throws NoSuchElementException если школы по переданному id не существует
     */
    void deleteSchool(int id);

    /**
     * Возвращает коллекцию, содержащую все школы таблицы Schools, конвертированных в SchoolDto
     * @return коллекцию schoolDtoList, которые предсталяют дубликаты школ таблицы Schools
     */
    List<SchoolDto> getAllSchool();
}
