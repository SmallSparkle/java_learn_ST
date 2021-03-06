package ru.stqa.pft.mantis.models;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mantis_user_table")
public class User {

  @Id
  @Column(name = "id")
  private int id;

  @Column(name ="username")
  private String username;

  @Column(name ="email")
  private String email;

  @Column(name ="enabled", columnDefinition = "TINYINT")
  @Type(type = "org.hibernate.type.NumericBooleanType")
  private boolean status;

  public int getId() {
    return id;
  }

  public User setId(int id) {
    this.id = id;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public User setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public User setEmail(String email) {
    this.email = email;
    return this;
  }

  public boolean isStatus() {
    return status;
  }

  public User setStatus(boolean status) {
    this.status = status;
    return this;
  }

  @Override
  public String toString() {
    return "UserData{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            '}';
  }
}
