package com.example.demo.service;

import com.example.demo.entity.School;
import com.example.demo.entity.Student;
import com.example.demo.map.StudentMapper;
import com.example.demo.dto.StudentDto;

import com.example.demo.repository.SchoolRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Класс StudentServiceImpl обертка над репозеторным слоем, которая принимает
 * запросы из внешнего мира и выполняет операции CRUD над таблицей Students.
 */
@Transactional
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private SchoolRepository schoolRepository;
	private StudentRepository studentRepository;
	private StudentMapper mapper;
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public StudentDto getStudentById(int id) throws NoSuchElementException {
		return studentRepository.findById(id).map(mapper.INSTANCE::mapToDto).orElseThrow(
				() -> new NoSuchElementException("Не найден ученик с id = " + id));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<StudentDto> getAllStudent() {
		return (studentRepository
				.findAll())
				.stream()
				.map(mapper.INSTANCE::mapToDto)
				.collect(Collectors.toList());
	}

	@Async
	public void abc() {
		while (true) {
			try {
				TimeUnit.SECONDS.sleep(10);
				System.out.println("Do work");
			} catch (InterruptedException ex) {
				System.out.println("Thread was interrupted");
				break;
			}
		}
	}

	public static synchronized void rewie() {
	}

	public void rew() {
		synchronized(this) {

		}
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
		School school = schoolRepository.findById(schoolId).orElseThrow(
				() -> new NoSuchElementException("Не найдена школа с id = " + schoolId));
		Student student = mapper.INSTANCE.mapToStudent(studentDto);
		student.setSchool(school);
		try {
			studentRepository.save(student);
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("Can't save student - " + studentDto);
		}
		return true;
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