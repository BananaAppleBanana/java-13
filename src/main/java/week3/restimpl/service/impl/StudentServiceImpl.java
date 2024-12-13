package week3.restimpl.service.impl;

import org.springframework.stereotype.Service;
import week3.restimpl.pojo.Student;
import week3.restimpl.service.StudentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    private final Map<String, Student> students = new HashMap<>();

    public StudentServiceImpl() {
        students.put("2", new Student("2", "student2"));
        students.put("1", new Student("1", "student1"));
    }

    @Override
    public Student getStudentById(String id) {
        return students.get(id);
    }

    @Override
    public List<Student> getAll() {
        return new ArrayList<>(students.values());
    }
}
