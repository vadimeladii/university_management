package md.utm.controller;

import com.google.common.collect.Lists;
import java.util.List;
import md.utm.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {

  public static List<Student> studentList = Lists.newArrayList(
      new Student("2012031536710", "Test", "test", "test@gmail.com"),
      new Student("2012031536711", "Test1", "test2", "test1@gmail.com"),
      new Student("2012031536712", "Test2", "test3", "tes2@gmail.com")
  );

//  static {
//    List<Student> studentList = new ArrayList();
//    studentList.add(new Student("2012031536710", "Test", "test", "test@gmail.com"));
//    studentList.add(new Student("2012031536711", "Test1", "test2", "test1@gmail.com"));
//    studentList.add(new Student("2012031536712", "Test2", "test3", "tes2@gmail.com"));
//  }

//  queryParam /student?name=test
//  pathParam /student/2012035464342
//  body {}

  @GetMapping
  public List<Student> getAll() {
    return studentList;
  }

  @GetMapping("/{idnp}")
  public Student getByIdnp(@PathVariable String idnp) {
    for (Student s: studentList) {
      if(s.getIdnp().equals(idnp)) {
        return s;
      }
    }
    return null;
  }

  @PostMapping
  public Student createStudent(@RequestBody Student student) {
      studentList.add(student);
      return student;
  }
}
