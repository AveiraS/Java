package com.example.demo.database.student.dto;

import com.example.demo.database.school.dto.SchoolDto;
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
    int schoolId;
    String first_name;
    String last_name;
    SchoolDto school;
}
