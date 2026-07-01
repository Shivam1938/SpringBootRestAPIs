package com.springboot.CRUD_springboot.service;

import com.springboot.CRUD_springboot.entity.Student;
import com.springboot.CRUD_springboot.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student createStudent(Student studentReq) {
        Optional<Student> existingStudent =
                studentRepository.findById(studentReq.getId());

        if (existingStudent.isPresent()) {
            throw new RuntimeException("Student already exists with id: " + studentReq.getId());
        }
        return studentRepository.save(studentReq);
    }

    public List<Student> getAllStudents(){
        List<Student> studentList = studentRepository.findAll();

        if(studentList.isEmpty()){
            throw new RuntimeException("No students found");
        }

        return studentList;
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with id: " + id));
    }

    public Student updateStudent(Student studentReq, Long id) {

        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with id: " + id));

        existingStudent.setName(studentReq.getName());
        existingStudent.setAge(studentReq.getAge());
        existingStudent.setEmail(studentReq.getEmail());
        existingStudent.setRollNo(studentReq.getRollNo());
        existingStudent.setSubject(studentReq.getSubject());

        return studentRepository.save(existingStudent);
    }

    public void deleteStudentById(Long id) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found with id: " + id));

        if (studentRepository.existsById(id)) {
            studentRepository.delete(existingStudent);
        }
    }

}
