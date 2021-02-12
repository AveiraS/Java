package com.example.demo.database.service;

import com.example.demo.database.StudentDto;

import java.util.List;
import java.util.NoSuchElementException;

/**
 *  * Интерфейс методов операций CRUD над таблицей Student
 */
public interface DatabaseService {
    /**
     * Извлекает объект по его идентификатору.
     * @param id пользователя, по которому будет производиться поиск.
     * @return StudentDto конвертированный объект, который дублирует студента таблицы Students
     * @throws NoSuchElementException если не был найден элемент с заданным id
     */
    StudentDto getStudentById(int id);
    /**
     * Возвращает коллекцию, содержащую всех студентов таблицы Students, конвертированных в StudentDto
     * @return коллекцию studentDtoList, которые предсталяют дубликаты студентов таблицы Students
     */
    List<StudentDto> getAllStudent();
    /**
     * Сохраняет студента таблицы Student в таблицу Students.
     * Сущность Student будет заполнена идентичными из StudentDTO полями.
     * @param studentDto объект, который будет конвертирован в Student
     * @return true, если новый студент успешно добавлен в таблицу
     */
    boolean addStudent(StudentDto studentDto);
    /**
     * Сохраняет студента таблицы Student в таблицу Students.
     * Сущность Student будет заполнена идентичными из StudentDTO полями.
     * @param studentDto объект, который будет конвертирован в Student
     * @param schoolId id школы
     * @return true, если новый студент успешно добавлен в таблицу
     */
    boolean addStudentWithSchool(StudentDto studentDto, int schoolId);
    /**
     * Обновляет ранее добавленного студента таблицы Student, через конвертацию объекта StudentDto
     * @param studentDto объект, который будет конвертирован в Student
     */
    void updateStudent(StudentDto studentDto);
    /**
     * Удаляет студента таблицы Student через переданный идентификатор
     * и StudentDto объект (нет)
     * @param id идентификатор удаляемого студента.
     * @throws NoSuchElementException если ученик по переданному id не существует
     */
    void deleteStudent(int id);

    public List<StudentDto> getAllStudentBySchoolId(int id);
}