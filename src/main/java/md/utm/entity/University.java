package md.utm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class University {
  private Integer id;
  private String shortName;
  private String fullName;
  private String address;
}
