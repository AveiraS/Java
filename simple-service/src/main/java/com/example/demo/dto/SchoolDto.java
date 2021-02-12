package com.example.demo.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * SchoolDto это объект для передачи данных на стороне сервера,
 * содержит всю информацию, которую мы хотим показать конечному пользователю.
 */

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SchoolDto {
    int schoolId;
    String name;
}
