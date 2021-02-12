package com.example.demo.controller;

import com.example.demo.parent.ParentService;
import com.example.demo.database.student.dto.StudentDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ParentController {
    ParentService acceptEvents;

    @Operation(summary = "Получить ученика по id",
            responses = {@ApiResponse(responseCode = "200", description = "Ученик получен")})
    @GetMapping(path = "/getOne")
    @ResponseStatus(code = HttpStatus.OK)
    public StudentDto getById(@Parameter(description = "id ученика", required = true) int id) {
        return acceptEvents.returnStudentById(id);
    }
}
