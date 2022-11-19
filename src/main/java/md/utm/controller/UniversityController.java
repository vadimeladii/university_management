package md.utm.controller;

import java.util.List;
import md.utm.entity.University;
import md.utm.entity.UniversityDetails;
import md.utm.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("university")
public class UniversityController {

  @Autowired
  private UniversityRepository universityRepository;

  @GetMapping
  public List<University> getAll() {
    return universityRepository.findAll();
  }

  @GetMapping("/{id}")
  public UniversityDetails getById(@PathVariable Integer id) {
    return universityRepository.findById(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void save(@RequestBody University university) {
    universityRepository.save(university);
  }

  @PutMapping("/{id}")
  public void update(@PathVariable Integer id, @RequestBody University university) {
    universityRepository.update(id, university);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id) {
    universityRepository.delete(id);
  }
}
