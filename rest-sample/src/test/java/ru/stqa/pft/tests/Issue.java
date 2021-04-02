package ru.stqa.pft.tests;

import java.util.Objects;

public class Issue {
  private int id;
  private String subject;
  private String description;
  private String state;

  public int getId() {
    return id;
  }

  public Issue withId(int id) {
    this.id = id;
    return this;
  }

  public String getSubject() {
    return subject;
  }

  public Issue withSubject(String subject) {
    this.subject = subject;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Issue withDescription(String description) {
    this.description = description;
    return this;
  }

  public String getState() {
    return state;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Issue issue = (Issue) o;
    return id == issue.id && Objects.equals(subject, issue.subject) && Objects.equals(description, issue.description) && Objects.equals(state, issue.state);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, subject, description, state);
  }

  public Issue withState(String stateName) {
    this.state = stateName;
    return this;
  }
}
