package com.example.demo.database.student.entity;

import com.example.demo.database.school.entity.School;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

/**
 * Класс(Entity) Student будет соответствовать таблице "students" в базе данных
 */

@Entity
@Table(name="students")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    int id;

	@Column(name="first_name")
	String first_name;

	@Column(name="last_name")
	String last_name;

	@ManyToOne
	School school;
}
