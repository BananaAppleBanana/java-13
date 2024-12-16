package week3.restimpl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import week3.restimpl.exception.ResourceNotFoundException;
import week3.restimpl.pojo.Student;
import week3.restimpl.pojo.dto.StudentDTO;
import week3.restimpl.service.StudentService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    @Value("${server.port}")
    private String port;

    private final StudentService ss;

    @Autowired
    public StudentController(StudentService ss) {
        this.ss = ss;
    }

    @GetMapping(value = "/students", params = {"name"})
    public ResponseEntity<List<StudentDTO>> getAllStudent1(@RequestParam(value = "name", required = false) String name) {
        return new ResponseEntity<>(
                ss.getAll().stream().map(s -> new StudentDTO(s.getName())).collect(Collectors.toList()),
                HttpStatus.OK
        );
    }
    @GetMapping(value = "/students", params = {"another-parameter"})
    public ResponseEntity<List<StudentDTO>> getAllStudent2(@RequestParam(value = "name", required = false) String name) {
        return new ResponseEntity<>(
                ss.getAll().stream().map(s -> new StudentDTO(s.getName())).collect(Collectors.toList()),
                HttpStatus.OK
        );
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("id") String id) {
        Student res = ss.getStudentById(id);
        if(res == null) {
            throw new ResourceNotFoundException("xxxxxx");
        }
        return new ResponseEntity<>(
                new StudentDTO(res.getName()),
                HttpStatus.OK
        );
    }

    @PostMapping("/students")
    public ResponseEntity<?> createStudent(@RequestBody StudentDTO studentDTO) {
        return null;
    }

    @GetMapping("/port")
    public String getPort() {
        return this.port;
    }
}
