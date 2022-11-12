package md.utm.repository;

import java.util.List;
import md.utm.entity.Student;

public interface StudentRepository {

  void save(Student student);

  List<Student> findAll();

  Student findByIdnp(String idnp);

  List<Student> findGreaterThan(float media);

  void update(String idnp, Student student);

  void delete(String idnp);
}
