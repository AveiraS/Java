package com.example.demo.database;

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
    String first_name;
    String last_name;
    int schoolId;
}
