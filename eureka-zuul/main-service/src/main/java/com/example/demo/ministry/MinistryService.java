package com.example.demo.ministry;

import com.example.demo.controller.MinistryController;
import com.example.demo.database.school.dto.SchoolDto;

import java.util.List;

/**
 * Интерфейс обработки и проверки запросов от контроллера {@link MinistryController}
 */
public interface MinistryService {
    SchoolDto returnSchoolById(int id);

    void deleteSchoolById(int id);

    List<SchoolDto> returnAllSchool();
}
