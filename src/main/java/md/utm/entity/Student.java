package md.utm.entity;

public class Student {

  private String idnp;
  private String fistName;
  private String lastName;
  private String email;

  public Student(String idnp, String fistName, String lastName, String email) {
    this.idnp = idnp;
    this.fistName = fistName;
    this.lastName = lastName;
    this.email = email;
  }

  public String getIdnp() {
    return idnp;
  }

  public void setIdnp(String idnp) {
    this.idnp = idnp;
  }

  public String getFistName() {
    return fistName;
  }

  public void setFistName(String fistName) {
    this.fistName = fistName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Student{" +
        "idnp='" + idnp + '\'' +
        ", fistName='" + fistName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
