package com.example.demo.director;

import com.example.demo.database.school.repository.SchoolRepository;
import com.example.demo.database.student.dto.StudentDto;

import java.util.List;
import java.util.NoSuchElementException;


/**
 * Интерфейс взаимодействует с репозеторием {@link SchoolRepository}
 */
public interface DirectorRequestToDatabase {

    /**
     * Извлекает объект по его идентификатору.
     * @param id пользователя, по которому будет производиться поиск.
     * @return StudentDto конвертированный объект, который дублирует студента таблицы Students
     * @throws NoSuchElementException если не был найден элемент с заданным id
     */
    StudentDto getStudentById(int id);

    /**
     * Удаляет студента таблицы Student через переданный идентификатор
     * и StudentDto объект (нет)
     * @param id идентификатор удаляемого студента.
     * @throws NoSuchElementException если ученик по переданному id не существует
     */
    void deleteStudent(int id);

    /**
     * Возвращает коллекцию, содержащую всех студентов таблицы Students, конвертированных в StudentDto
     * @return коллекцию studentDtoList, которые предсталяют дубликаты студентов таблицы Students
     */
    List<StudentDto> getAllStudent();

    /**
     * Сохраняет студента таблицы Student в таблицу Students.
     * Сущность Student будет заполнена идентичными из StudentDTO полями.
     * @param studentDto объект, который будет конвертирован в Student
     * @param schoolId id школы
     * @return true, если новый студент успешно добавлен в таблицу
     */
    boolean addStudentWithSchool(StudentDto studentDto, int schoolId);

    /**
     * Возвращает коллекцию, содержащую всех студентов таблицы Students,
     * принадлежащих школе с заданным id
     * @param id школы
     * @return коллекцию studentDtoList, которые предсталяют дубликаты студентов таблицы Students
     */
    List<StudentDto> getAllStudentBySchoolId(int id);
}
