package md.utm.repository;

import java.util.List;
import md.utm.entity.University;
import md.utm.entity.UniversityDetails;

public interface UniversityRepository {

  List<University> findAll();

  UniversityDetails findById(Integer id);

  void save(University university);

  void update(Integer id, University university);

  void delete(Integer id);
}
