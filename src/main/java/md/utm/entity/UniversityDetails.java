package md.utm.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UniversityDetails {
  private Integer id;
  private String shortName;
  private String fullName;
  private String address;
  private List<Student> students;

  public UniversityDetails(Integer id, String shortName, String fullName, String address) {
    this.id = id;
    this.shortName = shortName;
    this.fullName = fullName;
    this.address = address;
  }
}
