package com.example.demo.dto;

import com.example.demo.entity.School;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * StudentDto это объект передачи данных на стороне сервера,
 * содержит всю информацию, которую мы хотим показать конечному пользователю.
 */

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentDto {
    int id;
    String name;
    SchoolDto school;
}
