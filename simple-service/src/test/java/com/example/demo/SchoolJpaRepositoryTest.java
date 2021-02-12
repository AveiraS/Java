package com.example.demo;

import com.example.demo.entity.School;
import com.example.demo.repository.SchoolRepository;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class SchoolJpaRepositoryTest {

    @Autowired
    SchoolRepository repository;

    @Autowired
    TestEntityManager testEntity;

    @Before
    public void run() {
        repository.deleteAll();
    }

    @Test
    @DisplayName("Проверка на пустой репозиторий")
    public void find_no_school_if_repository_is_empty() {
        Iterable<School> students = repository.findAll();

        assertThat(students).isEmpty();
    }

    @Test
    @DisplayName("Добавление школы")
    public void add_school() {
        School student = testEntity.persist(new School());
        student.setName("eng");
        testEntity.flush();
        Assertions.assertTrue( repository.findById(student.getSchoolId()).isPresent());
    }

    @Test
    @DisplayName("Поиск всех школ")
    public void find_all_schools() {
        School school1 = new School();
        testEntity.persist(school1);

        School school2 = new School();
        testEntity.persist(school2);

        School school3 = new School();
        testEntity.persist(school3);

        Iterable<School> students = repository.findAll();

        assertThat(students).hasSize(3).contains(school1, school2, school3);
    }

    @Test
    @DisplayName("Поиск школы по id")
    public void find_school_by_id() {
        School school = new School();
        school.setName("eng");
        testEntity.persist(school);

        School student2 = new School();
        student2.setName("math");
        testEntity.persist(student2);

        School foundStudent = repository.findById(school.getSchoolId()).get();

        assertThat(foundStudent).isEqualTo(school);
    }


    @Test
    @DisplayName("Обновление школы по id")
    public void update_school_by_id() {
        School orig = new School();
        orig.setName("Name");
        testEntity.persist(orig);

        School change = repository.findById(orig.getSchoolId()).get();
        change.setName("NewName");
        repository.save(change);

        School check = repository.findById(orig.getSchoolId()).get();

        assertThat(check.getSchoolId()).isEqualTo(orig.getSchoolId());
        assertThat(check.getName()).isEqualTo("NewName");
    }

    @Test
    @DisplayName("Удаление школы по id")
    public void delete_school_by_id() {
        School school1 = new School();
        testEntity.persist(school1);

        School school2 = new School();
        testEntity.persist(school2);

        School school3 = new School();
        testEntity.persist(school3);

        repository.deleteById(school2.getSchoolId());

        Iterable<School> students = repository.findAll();

        assertThat(students).hasSize(2).contains(school1, school3);
    }

    @Test
    @DisplayName("Удаление всех школ")
    public void delete_all_schools() {
        testEntity.persist(new School());
        testEntity.persist(new School());

        repository.deleteAll();

        assertThat(repository.findAll()).isEmpty();
    }
}
