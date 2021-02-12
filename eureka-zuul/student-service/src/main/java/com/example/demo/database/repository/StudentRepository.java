package com.example.demo.database.repository;

import com.example.demo.database.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Данный интерфейс наследуется от JpaRepository – это интерфейс фреймворка
 * Spring Data предоставляющий набор стандартных методов JPA для работы с БД.
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
}