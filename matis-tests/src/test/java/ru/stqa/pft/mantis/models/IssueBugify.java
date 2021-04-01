package ru.stqa.pft.mantis.models;

import java.util.Objects;

public class IssueBugify {
  private int id;
  private String subject;
  private String description;
  private String state;

  public int getId() {
    return id;
  }

  public IssueBugify withId(int id) {
    this.id = id;
    return this;
  }

  public String getSubject() {
    return subject;
  }

  public IssueBugify withSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public IssueBugify withDescription(String description) {
    this.description = description;
    return this;
  }

  public String getState() {
    return state;
  }

  public IssueBugify withState(String stateName) {
    this.state = stateName;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    IssueBugify that = (IssueBugify) o;
    return id == that.id && Objects.equals(subject, that.subject) && Objects.equals(description, that.description) && Objects.equals(state, that.state);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, subject, description, state);
  }
}
