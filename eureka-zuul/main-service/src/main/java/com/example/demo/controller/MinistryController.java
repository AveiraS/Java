package com.example.demo.controller;

import com.example.demo.ministry.MinistryService;
import com.example.demo.database.school.dto.SchoolDto;
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
public class MinistryController {
    MinistryService acceptEvents;

    @Operation(summary = "Получить школу по id",
            responses = {@ApiResponse(responseCode = "200", description = "Школа получена")})
    @GetMapping(path = "/getSchool")
    @ResponseStatus(code = HttpStatus.OK)
    public SchoolDto getById(@Parameter(description = "id школы", required = true) int id) {
        return acceptEvents.returnSchoolById(id);
    }

    @Operation(summary = "Получить список всех школ")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Список получен")})
    @GetMapping("/getAllSchool")
    @ResponseStatus(code = HttpStatus.OK)
    public List<SchoolDto> getAllUsersLocation() {
        return acceptEvents.returnAllSchool();
    }

    @Operation(summary = "Удалить школу",
    responses = {@ApiResponse(responseCode = "200", description = "Модель удалена")})
    @GetMapping(path = "/deleteSchool")
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@Parameter(description = "id школы", required = true) int id) {
            acceptEvents.deleteSchoolById(id);
    }
}
