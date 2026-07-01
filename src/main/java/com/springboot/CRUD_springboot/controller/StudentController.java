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

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Student>> createStudent(@RequestBody Student studentReq) {
        studentReq.setDeleted(false);
        Student studentRes = studentService.createStudent(studentReq);

        ApiResponse<Student> response =
                new ApiResponse<>("Student created successfully", studentRes);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);

    }

    @GetMapping("/get-all")
    public ResponseEntity<ApiResponse<List<Student>>> getAllStudents() {
        List<Student> studentList = studentService.getAllStudents();

        ApiResponse<List<Student>>
            response = new ApiResponse<>("Students fetched successfully", studentList);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/get")
    public ResponseEntity<ApiResponse<Student>> getStudentById(@RequestParam Long id) {
        Student student = studentService.getStudentById(id);

        ApiResponse<Student>
            response = new ApiResponse<>("Student found with id = " + id, student);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse<Student>> updateStudent(@RequestBody Student studentReq, @RequestParam Long id) {
        Student studentRes = studentService.updateStudent(studentReq, id);

        ApiResponse<Student> response =
                new ApiResponse<>("Student updated successfully", studentRes);

        return ResponseEntity
                .ok(response);


    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse<Student>> deleteStudentById(@RequestParam Long id) {
        studentService.deleteStudentById(id);

        ApiResponse<Student> response =
                new ApiResponse<>("Student deleted successfully", null);

        return ResponseEntity.ok(response);

    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<ApiResponse<String>> deleteStudentSoftly(@RequestParam Long id) {
        Boolean isDeleted = studentService.deleteStudentSoftly(id);

        if (isDeleted) {
            return ResponseEntity.ok(
                    new ApiResponse<>("Student soft deleted successfully", null)
            );
        }

        return ResponseEntity.badRequest().body(
                new ApiResponse<>("Student delete failed", null)
        );
    }
}
