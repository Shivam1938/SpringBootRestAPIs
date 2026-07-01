package com.springboot.CRUD_springboot.controller;

import com.springboot.CRUD_springboot.entity.Student;
import com.springboot.CRUD_springboot.service.StudentService;
import com.springboot.CRUD_springboot.utilities.ApiResponse.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController{

    private final StudentService studentService;

    @PostMapping("")
    public ResponseEntity<ApiResponse<Student>> createStudent(@RequestBody Student studentReq) {
        Student studentRes = studentService.createStudent(studentReq);

        ApiResponse<Student> response =
                new ApiResponse<>("Student created successfully", studentRes);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);

    }

    @GetMapping("")
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents() {
        List<Student> studentList = studentService.getAllStudents();

        ApiResponse<List<Student>>
            response = new ApiResponse<>("Students fetched successfully", studentList);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);

        ApiResponse<Student>
            response = new ApiResponse<>("Student found with id = " + id, student);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> updateStudent(@RequestBody Student studentReq, @PathVariable Long id) {
        Student studentRes = studentService.updateStudent(studentReq, id);

        ApiResponse<Student> response =
                new ApiResponse<>("Student updated successfully", studentRes);

        return ResponseEntity
                .ok(response);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Student>> deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);

        ApiResponse<Student> response =
                new ApiResponse<>("Student deleted successfully", null);

        return ResponseEntity.ok(response);

    }
}
