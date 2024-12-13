package week3.restimpl.service;

import org.springframework.stereotype.Service;
import week3.restimpl.pojo.Student;

import java.util.List;

@Service
public interface StudentService {
    Student getStudentById(String id);
    List<Student> getAll();
}
