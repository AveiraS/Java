package com.example.demo.controller;

import com.example.demo.dto.SchoolDto;
import com.example.demo.service.SchoolServiceImpl;
import com.example.demo.service.StudentServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер школы, работает от сервиса {@link SchoolServiceImpl}
 */
@RestController
public class SchoolController {
    private SchoolServiceImpl service;

    public SchoolController(SchoolServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "Получить школу по id",
            responses = {@ApiResponse(responseCode = "200", description = "Школа получена")})
    @GetMapping(path = "/getSch")
    @ResponseStatus(code = HttpStatus.OK)
    public SchoolDto getById(@Parameter(description = "id школы", required = true) int id) {
        return service.getSchoolDtoById((int) id);
    }
}
