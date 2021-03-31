package ru.stqa.pft.mantis.models;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Users extends ForwardingSet<User> {

  private Set<User> delegate;

  public Users(Collection<User> contact) {
    this.delegate = new HashSet<User>(contact);
  }

  public Users() {
    this.delegate = new HashSet<User>();
  }

  @Override
  protected Set<User> delegate() {
    return delegate;
  }
}
