package com.example.demo.controller;

import com.example.demo.director.DirectorService;
import com.example.demo.database.student.dto.StudentDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DirectorController {
    DirectorService acceptEvents;

    @Operation(summary = "Получить ученика по id",
            responses = {@ApiResponse(responseCode = "200", description = "Ученик получен")})
    @GetMapping(path = "/getStudent")
    @ResponseStatus(code = HttpStatus.OK)
    public StudentDto getById(@Parameter(description = "id ученика", required = true) int id) {
        return acceptEvents.returnStudentById(id);
    }

    @Operation(summary = "Получить список всех учеников")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Список получен")})
    @GetMapping("/getAllStudent")
    @ResponseStatus(code = HttpStatus.OK)
    public List<StudentDto> getAllStudent(@Parameter(description = "id школы", required = true) int id) {
        return acceptEvents.returnAllStudent(id);
    }

    @Operation(summary = "Удалить ученика",
            responses = {@ApiResponse(responseCode = "200", description = "Модель удалена")})
    @GetMapping(path = "/deleteStudent")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@Parameter(description = "id школы", required = true) int id) {
        acceptEvents.deleteStudentById(id);
    }

    @Operation(summary = "Добавить школьника вместе со школой")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Школьник добавлен")})
    @GetMapping("/addS")
    @ResponseStatus(code = HttpStatus.OK)
    public void addStudentWithSchool(StudentDto studentDto, int schoolId) {
        acceptEvents.addStudentInSchool(studentDto, schoolId);
    }

    @Operation(summary = "Получить список всех школьников")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Список получен")})
    @GetMapping("/getAll")
    @ResponseStatus(code = HttpStatus.OK)
    public List<StudentDto> getAllUsersLocation() {
        return acceptEvents.returnAllStudent();
    }
}
