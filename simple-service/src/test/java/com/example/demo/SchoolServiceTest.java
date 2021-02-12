package com.example.demo;

import com.example.demo.dto.SchoolDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.School;
import com.example.demo.entity.Student;
import com.example.demo.map.SchoolMapper;
import com.example.demo.map.StudentMapper;
import com.example.demo.repository.SchoolRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.SchoolService;
import com.example.demo.service.SchoolServiceImpl;
import com.example.demo.service.StudentService;
import com.example.demo.service.StudentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SchoolServiceTest {

    private SchoolMapper mapper;

    private SchoolService service;

    @MockBean
    SchoolRepository repository;

    @Before
    public void before() {
        service = new SchoolServiceImpl(repository);
    }

    @Test
    @DisplayName("Вернуть школуDTO по ID")
    public void get_school_dto_byId()
    {
        Mockito.when(repository.findById(1)).thenReturn(java.util.Optional.of(new School(1, "eng", null)));

        SchoolDto dto = service.getSchoolDtoById(1);

        Assertions.assertEquals("eng", dto.getName());
        Assertions.assertEquals(1, dto.getSchoolId());
    }
}