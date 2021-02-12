package com.example.demo.entity;

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

	@Column(name="name")
    String name;

	@ManyToOne
	School school;
}
