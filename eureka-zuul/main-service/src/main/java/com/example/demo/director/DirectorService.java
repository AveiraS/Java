package com.example.demo.director;

import com.example.demo.controller.DirectorController;
import com.example.demo.database.student.dto.StudentDto;

import java.util.List;

/**
 * Интерфейс обработки и проверки запросов от контроллера {@link DirectorController}
 */
public interface DirectorService {
    /**
     * Возвращает ученика по переданному id, если запрос был корректным
     * @param id
     * @return
     * @throws IllegalArgumentException если id <= 0
     */
    StudentDto returnStudentById(int id) throws IllegalArgumentException;

    /**
     *
     * @param id
     * @throws IllegalArgumentException
     */
    void deleteStudentById(int id) throws IllegalArgumentException;

    /**
     *
     * @param id
     * @return
     * @throws IllegalArgumentException
     */
    List<StudentDto> returnAllStudent(int id) throws IllegalArgumentException;

    /**
     *
     * @return
     * @throws IllegalArgumentException
     */
    List<StudentDto> returnAllStudent() throws IllegalArgumentException;

    /**
     *
     * @param studentDto
     * @param schoolId
     * @return
     * @throws IllegalArgumentException
     */
    boolean addStudentInSchool(StudentDto studentDto, int schoolId) throws IllegalArgumentException;
}
