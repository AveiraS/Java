package com.example.demo.parent;

import com.example.demo.controller.ParentController;
import com.example.demo.database.student.dto.StudentDto;

/**
 * Интерфейс обработки и проверки запросов от контроллера {@link ParentController}
 */
public interface ParentService {
    /**
     * Получить ученика по id, если запрос был корректный
     * @param id
     * @return
     * @throws IllegalArgumentException если id <= 0
     */
    StudentDto returnStudentById(int id) throws IllegalArgumentException;
}
