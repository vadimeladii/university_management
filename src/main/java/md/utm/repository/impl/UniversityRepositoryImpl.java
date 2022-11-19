package md.utm.repository.impl;

import java.util.List;
import md.utm.entity.Student;
import md.utm.entity.University;
import md.utm.entity.UniversityDetails;
import md.utm.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UniversityRepositoryImpl implements UniversityRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<University> findAll() {
    return jdbcTemplate.query("select * from university", (result, rowNum) ->
        new University(
            result.getInt("id"),
            result.getString("short_name"),
            result.getString("full_name"),
            result.getString("address")
        ));
  }

  @Override
  public UniversityDetails findById(Integer id) {
    UniversityDetails universityDetails =
        jdbcTemplate.queryForObject("select * from university where id = ?",
        new Object[]{id},
        (result, rowNum) ->
            new UniversityDetails(
                result.getInt("id"),
                result.getString("short_name"),
                result.getString("full_name"),
                result.getString("address")
            ));

    List<Student> students = jdbcTemplate.query("select * from student where university_id = ?",
        new Object[]{id},
        (result, rowNum) ->
            new Student(
                result.getString("idnp"),
                result.getString("first_name"),
                result.getString("last_name"),
                result.getString("email"),
                result.getFloat("media"),
                result.getInt("university_id")
            ));

    universityDetails.setStudents(students);

    return universityDetails;
  }

  @Override
  public void save(University university) {
    jdbcTemplate.update(
        "insert into university values (?, ?, ?, ?)",
        university.getId(), university.getShortName(), university.getFullName(),
        university.getAddress());
  }

  @Override
  public void update(Integer id, University university) {
    jdbcTemplate.update(
        "update university set short_name = ?, full_name = ?, address = ?  where id = ?",
        university.getShortName(), university.getFullName(), university.getAddress(), id);
  }

  @Override
  public void delete(Integer id) {
    jdbcTemplate.update(
        "delete from university where id = ?", id);
  }
}
