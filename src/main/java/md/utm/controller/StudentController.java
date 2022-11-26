package md.utm.controller;

import java.util.List;
import md.utm.entity.Student;
import md.utm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {

  @Autowired
  private StudentService studentService;

  @GetMapping
  public List<Student> getAll() {
    return studentService.findAll();
  }

  @GetMapping("/{idnp}")
  public Student getByIdnp(@PathVariable String idnp) {
    return studentService.findByIdnp(idnp);
  }

  @GetMapping("greaterThan")
  public List<Student> getGreaterThan(@RequestParam float media) {
    return studentService.findGreaterThan(media);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void save(@RequestBody Student student) {
      studentService.save(student);
  }

  @PutMapping("/{idnp}")
  public void update(@PathVariable String idnp, @RequestBody Student student) {
    studentService.update(idnp, student);
  }

  @DeleteMapping("/{idnp}")
  public void delete(@PathVariable String idnp) {
    studentService.delete(idnp);
  }
}
