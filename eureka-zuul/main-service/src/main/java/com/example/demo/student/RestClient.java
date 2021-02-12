package com.example.demo.student;

import com.example.demo.database.student.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("student-service/students")
public interface RestClient {

    @RequestMapping("/info/{id}")
    StudentDto takeStudentInfo(@PathVariable int id);

    @RequestMapping("/new")
    void makeNewStudent(@RequestBody StudentDto studentDto);

    @RequestMapping("all/{id}")
    List<StudentDto> getAllStudent(@PathVariable int id);
}
