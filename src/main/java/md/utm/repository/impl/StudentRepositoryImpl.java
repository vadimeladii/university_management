package md.utm.repository.impl;

import java.util.List;
import md.utm.entity.Student;
import md.utm.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public void save(Student student) {
    jdbcTemplate.update(
        "insert into student values (?, ?, ?, ?, ?)",
        student.getIdnp(), student.getFistName(), student.getLastName(),
        student.getEmail(), student.getMedia());
  }

  @Override
  public List<Student> findAll() {
    return jdbcTemplate.query("select * from student", (student, rowNum) ->
        new Student(
            student.getString("idnp"),
            student.getString("first_name"),
            student.getString("last_name"),
            student.getString("email"),
            student.getFloat("media")
        ));
  }

  @Override
  public Student findByIdnp(String idnp) {
    return jdbcTemplate.queryForObject("select * from student where idnp = ?",
        new Object[]{idnp},
        (student, rowNum) ->
        new Student(
            student.getString("idnp"),
            student.getString("first_name"),
            student.getString("last_name"),
            student.getString("email"),
            student.getFloat("media")
        ));
  }

  @Override
  public List<Student> findGreaterThan(float media) {
    return jdbcTemplate.query("select * from student where media > ?",
        new Object[]{media},
        (student, rowNum) ->
        new Student(
            student.getString("idnp"),
            student.getString("first_name"),
            student.getString("last_name"),
            student.getString("email"),
            student.getFloat("media")
        ));
  }

  @Override
  public void update(String idnp, Student student) {
    jdbcTemplate.update(
        "update student set first_name = ?, last_name = ?, email = ?, media = ? where idnp = ?",
        student.getFistName(), student.getLastName(), student.getEmail(), student.getMedia(), idnp);
  }

  @Override
  public void delete(String idnp) {
    jdbcTemplate.update(
        "delete from student where idnp = ?", idnp);
  }
}
