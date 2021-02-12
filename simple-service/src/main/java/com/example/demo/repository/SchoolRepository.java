package com.example.demo.repository;

import com.example.demo.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Данный интерфейс наследуется от JpaRepository – это интерфейс фреймворка
 * Spring Data предоставляющий набор стандартных методов JPA для работы с БД.
 */
public interface SchoolRepository extends JpaRepository<School, Integer> {
}
