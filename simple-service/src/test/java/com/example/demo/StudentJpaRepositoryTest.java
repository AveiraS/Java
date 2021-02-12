package com.example.demo;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
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
public class StudentJpaRepositoryTest {

    @Autowired
    StudentRepository repository;

    @Autowired
    TestEntityManager testEntity;

    @Before
    public void run() {
        repository.deleteAll();
    }

    @Test
    @DisplayName("Проверка на пустой репозиторий")
    public void find_no_student_if_repository_is_empty() {
        Iterable<Student> students = repository.findAll();

        assertThat(students).isEmpty();
    }

    @Test
    @DisplayName("Добавление школьника")
    public void add_student() {
        Student student = testEntity.persist(new Student());
        student.setName("Poll");
        testEntity.flush();
        Assertions.assertTrue( !repository.findById(student.getId()).isPresent());
    }

    @Test
    @DisplayName("Поиск всех школьника")
    public void find_all_students() {
        Student student1 = new Student();
        testEntity.persist(student1);

        Student student2 = new Student();
        testEntity.persist(student2);

        Student student3 = new Student();
        testEntity.persist(student3);

        Iterable<Student> students = repository.findAll();

        assertThat(students).hasSize(3).contains(student1, student2, student3);
    }

    @Test
    @DisplayName("Поиск школьника по id")
    public void find_student_by_id() {
        Student student = new Student();
        student.setName("Alice");
        testEntity.persist(student);

        Student student2 = new Student();
        student2.setName("Poll");
        testEntity.persist(student2);

        Student foundStudent = repository.findById(student.getId()).get();

        assertThat(foundStudent).isEqualTo(student);
    }


    @Test
    @DisplayName("Обновление школьника по id")
    public void update_student_by_id() {
        Student orig = new Student();
        orig.setName("Name");
        testEntity.persist(orig);

        Student change = repository.findById(orig.getId()).get();
        change.setName("NewName");
        repository.save(change);

        Student checkTut = repository.findById(orig.getId()).get();

        assertThat(checkTut.getId()).isEqualTo(orig.getId());
        assertThat(checkTut.getName()).isEqualTo("NewName");
    }

    @Test
    @DisplayName("Удаление школьника по id")
    public void delete_student_by_id() {
        Student student1 = new Student();
        testEntity.persist(student1);

        Student student2 = new Student();
        testEntity.persist(student2);

        Student student3 = new Student();
        testEntity.persist(student3);

        repository.deleteById(student2.getId());

        Iterable<Student> students = repository.findAll();

        assertThat(students).hasSize(2).contains(student1, student3);
    }

    @Test
    @DisplayName("Удаление всех школьников")
    public void delete_all_students() {
        testEntity.persist(new Student());
        testEntity.persist(new Student());

        repository.deleteAll();

        assertThat(repository.findAll()).isEmpty();
    }
}
