package com.example.demo.controller;

import com.example.demo.database.StudentDto;
import com.example.demo.student.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//@RequestMapping("/api")
public class StudentController {

    StudentService acceptEvents;

    @Operation(summary = "Получить ученика по id",
            responses = {@ApiResponse(responseCode = "200", description = "Ученик получен")})
    @GetMapping(path = "/info/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public StudentDto takeStudentInfo(@PathVariable int id) {
        return acceptEvents.returnStudentById(id);
    }

    @Operation(summary = "Добавить школьника")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Школьник добавлен")})
    @PostMapping("/new")
    @ResponseStatus(code = HttpStatus.OK)
    public void makeNewStudent(@RequestBody StudentDto studentDto) {
        acceptEvents.addStudent(studentDto);
    }

    @Operation(summary = "Получить список всех учеников в школе")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Список получен")})
    @GetMapping("/all/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<StudentDto> getAllStudent(@Parameter(description = "id школы", required = true)@PathVariable int id) {
        return acceptEvents.takeAllBySchool(id);
    }
}
