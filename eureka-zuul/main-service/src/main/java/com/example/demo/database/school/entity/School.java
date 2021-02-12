package com.example.demo.database.school.entity;

import com.example.demo.database.student.entity.Student;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

/**
 * Класс(Entity) School будет соответствовать таблице "schools" в базе данных
 */
@Entity
@Table(name="schools")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="school_id")
    int schoolId;

    @Column(name="name")
    String name;

    @OneToMany(mappedBy="school")
    List<Student> students;
}
