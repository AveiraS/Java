package com.example.demo.student;

import com.example.demo.controller.StudentController;
import com.example.demo.database.student.dto.StudentDto;

import java.util.List;

/**
 * Интерфейс для взаимодействия с контроллером {@link StudentController}
 */
public interface StudentService {
    /**
     * Возвращает студента по id
     * @param id уникальный идентификатор студента
     * @return студента
     * @throws IllegalArgumentException если id <= 0
     */
    StudentDto getStudentInfo(int id) throws IllegalArgumentException;

    /**
     * Добавляет студента, через обращение на другой сервис
     * @param studentDto студент
     * @throws IllegalArgumentException если id <= 0
     *                                  отсутствуют параментры last_name/first_name
     */
    void addStudentInSchool(StudentDto studentDto) throws IllegalArgumentException;

    List<StudentDto> takeAllStudentInSchool(int id) throws IllegalArgumentException;
}
