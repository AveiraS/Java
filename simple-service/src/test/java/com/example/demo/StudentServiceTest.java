package com.example.demo;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.map.StudentMapper;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import com.example.demo.service.StudentServiceImpl;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class StudentServiceTest {

    private StudentMapper mapper;

    private StudentService service;

    @MockBean
    StudentRepository repository;

    @Before
    public void before() {
        service = new StudentServiceImpl(repository);
    }

    @Test
    @DisplayName("Добавить школьникаDTO")
    public void add_student_dto() {
        StudentDto dto = StudentDto.builder()
                .name("Poll")
                .build();

        service.addStudent(dto);
        Mockito.verify(repository, Mockito.times(1)).save(mapper.INSTANCE.mapToStudent(dto));
    }

    @Test
    @DisplayName("Вернуть список школьниковDTO")
    public void get_all_student_dto() {
        List<Student> list = new ArrayList<>();

        Student dto = new Student(1, "Pol", null);
        Student dto2 = new Student(2, "As", null);
        Student dto3 = new Student(3, "Jo", null);

        list.add(dto);
        list.add(dto2);
        list.add(dto3);

        Mockito.when(repository.findAll()).thenReturn(list);

        List<StudentDto> empList = service.getAllStudent();
        Assertions.assertEquals(3, empList.size());
        Mockito.verify(repository, Mockito.times(1)).findAll();
    }

    @Test
    @DisplayName("Вернуть школьникаDTO по ID")
    public void get_student_dto_byId()
    {
        Mockito.when(repository.findById(1)).thenReturn(java.util.Optional.of(new Student(1, "Lo", null)));

        StudentDto dto = service.getStudentById(1);

        Assertions.assertEquals("Lo", dto.getName());
        Assertions.assertEquals(1, dto.getId());
    }
}
