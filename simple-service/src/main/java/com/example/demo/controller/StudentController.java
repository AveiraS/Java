package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.service.StudentServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер школьника, работает от сервиса {@link StudentServiceImpl}
 */
@RestController
public class StudentController {

    private StudentServiceImpl service;

    public StudentController(StudentServiceImpl service) {
        this.service = service;
    }

    @Operation(summary = "Получить школьника по id",
    responses = {@ApiResponse(responseCode = "200", description = "Школьник получен")})
    @GetMapping(path = "/get")
    @ResponseStatus(code = HttpStatus.OK)
    public StudentDto getById(@Parameter(description = "id школьника", required = true) int id) {
        return service.getStudentById(id);
    }

    @Operation(summary = "Добавить школьника")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Модель записана")})
    @PostMapping(path = "/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@Parameter(description = "Модель для записи в БД", required = true) @RequestBody StudentDto dto) {
        service.addStudent(dto);
    }

    @Operation(summary = "Получить список всех школьников")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Список получен")})
    @GetMapping("/getAll")
    @ResponseStatus(code = HttpStatus.OK)
    public List<StudentDto> getAllUsersLocation() {
        return service.getAllStudent();
    }

    @Operation(summary = "Добавить школьника вместе со школой")
    @ApiResponses({@ApiResponse(responseCode = "201", description = "Школьник добавлен")})
    @GetMapping("/addS")
    @ResponseStatus(code = HttpStatus.OK)
    public void addStudentWithSchool(StudentDto studentDto, int schoolId) {
        service.addStudentWithSchool(studentDto, schoolId);
    }

    @Operation(summary = "Запустить метод в потоке")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Поток выполнен")})
    @PostMapping(path = "/thread")
    @ResponseStatus(code = HttpStatus.OK)
    public void startThread() throws InterruptedException {
        Thread thread = new Thread(() -> {
            service.abc();
        });
        System.out.println("Thread start");
        thread.start();

        Thread.sleep(100);
        thread.interrupt();

        thread.join();
        System.out.println("Thread finished");
    }
}
