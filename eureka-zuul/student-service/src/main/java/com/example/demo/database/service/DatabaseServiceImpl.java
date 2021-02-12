package com.example.demo.database.service;

import com.example.demo.database.StudentDto;
import com.example.demo.database.repository.StudentRepository;
import com.example.demo.student.StudentMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * Класс StudentServiceImpl обертка над репозеторным слоем, которая принимает
 * запросы и выполняет операции CRUD над таблицей Students.
 */
@Transactional
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DatabaseServiceImpl implements DatabaseService {
	StudentRepository studentRepository;
	StudentMapper mapper;

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public StudentDto getStudentById(int id) throws NoSuchElementException {
		return studentRepository.findById(id).map(mapper.INSTANCE::mapToDto).orElseThrow(
				() -> new NoSuchElementException("Не найден ученик с id = " + id));
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<StudentDto> getAllStudent() {
		return (studentRepository
				.findAll())
				.stream()
				.map(mapper.INSTANCE::mapToDto)
				.collect(Collectors.toList());
	}

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<StudentDto> getAllStudentBySchoolId(int id) {
		List<StudentDto> list = getAllStudent();
		list.removeIf(dto -> dto.getSchoolId() != id);
		return list;
	}

	@Override
	public boolean addStudent(StudentDto studentDto) {
		try {
			studentRepository.save(mapper.INSTANCE.mapToStudent(studentDto));
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("Can't save student - " + studentDto);
		}
		return true;
	}

	@Override
	public boolean addStudentWithSchool(StudentDto studentDto, int schoolId) {
		return false;
	}

	@Override
	public void updateStudent(StudentDto studentDto) {
		try {
			studentRepository.save(mapper.INSTANCE.mapToStudent(studentDto));
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("Can't update student - " + studentDto);
		}
	}

	@Override
	public void deleteStudent(int id) throws NoSuchElementException {
		try {
			studentRepository.deleteById(id);
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("Can't delete student - " + id);
		}
	}
}