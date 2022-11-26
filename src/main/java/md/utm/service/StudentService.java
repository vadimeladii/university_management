package md.utm.service;

import java.util.List;
import md.utm.entity.Student;

public interface StudentService {

  List<Student> findAll();

  Student findByIdnp(String idnp);

  List<Student> findGreaterThan(float media);

  void save(Student student);

  void update(String idnp, Student student);

  void delete(String idnp);
}
