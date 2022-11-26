package md.utm.service.impl;

import java.util.List;
import md.utm.entity.Student;
import md.utm.exception.AlreadyExistException;
import md.utm.exception.NotFoundException;
import md.utm.repository.StudentRepository;
import md.utm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  private StudentRepository studentRepository;

  @Override
  public List<Student> findAll() {
    return studentRepository.findAll();
  }

  @Override
  public Student findByIdnp(String idnp) {
    if(!studentRepository.studentExist(idnp))
      throw new NotFoundException(
          "Student with idnp = " + idnp + " not found");

    return studentRepository.findByIdnp(idnp);
  }

  @Override
  public List<Student> findGreaterThan(float media) {
    return studentRepository.findGreaterThan(media);
  }

  @Override
  public void save(Student student) {
    if(studentRepository.studentExist(student.getIdnp()))
        throw new AlreadyExistException(
            "Student with idnp = " + student.getIdnp() + " already exist");

    studentRepository.save(student);
  }

  @Override
  public void update(String idnp, Student student) {
    studentRepository.update(idnp, student);
  }

  @Override
  public void delete(String idnp) {
    studentRepository.delete(idnp);
  }
}
