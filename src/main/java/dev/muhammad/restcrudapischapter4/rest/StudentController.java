package dev.muhammad.restcrudapischapter4.rest;

import dev.muhammad.restcrudapischapter4.exceptions.StudentNotFoundException;
import dev.muhammad.restcrudapischapter4.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class StudentController {
    private List<Student> list = new ArrayList<>();

    @PostConstruct
    public void createDatabase() {
        list.add(new Student("Muhammad", "Karimov", 20));
        list.add(new Student("Ali", "BoAli", 34));
        list.add(new Student("Mike", "Tyson", 50));
    }

    @PostMapping("/students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(
            @RequestBody Student student
    ) {
        list.add(student);

        return student;
    }

    @GetMapping("/students")
    public List<Student> showStudents() {
        return list;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable(name = "id") int id) {
        if (id >= list.size() || id < 0) {
            throw  new StudentNotFoundException("Student not found " + id);
        }

        return list.get(id);
    }

}
