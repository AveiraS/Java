package com.example.demo.controller;

import com.example.demo.database.student.dto.StudentDto;
import com.example.demo.student.RestClient;
import com.example.demo.student.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService acceptEvents;
    final RestClient restClient;

    @Operation(summary = "Получить ученика по id",
            responses = {@ApiResponse(responseCode = "200", description = "Ученик получен")})
    @GetMapping("/rest-info/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public StudentDto getStudentById(@Parameter(description = "id ученика", required = true)@PathVariable int id) {
        return acceptEvents.getStudentInfo(id);
    }

    @Operation(summary = "Добавить школьника")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Школьник добавлен")})
    @GetMapping("/rest-new")
    @ResponseStatus(code = HttpStatus.OK)
    public void addStudentWithSchool(StudentDto studentDto) {
        acceptEvents.addStudentInSchool(studentDto);
    }

    @Operation(summary = "Получить список всех учеников")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Список получен")})
    @GetMapping("/rest-all/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<StudentDto> getAllStudent(@Parameter(description = "id школы", required = true)@PathVariable int id) {
        return acceptEvents.takeAllStudentInSchool(id);
    }
}
