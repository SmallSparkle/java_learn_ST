package ru.stqa.pft.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import org.hibernate.query.Query;
import ru.stqa.pft.mantis.models.User;
import ru.stqa.pft.mantis.models.Users;

import java.util.List;

public class DbHelper {

  private final SessionFactory sessionFactory;

  public DbHelper() {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
  }

  public Users users() {
    Session session = getSession();
    List<User> result = session.createQuery("from User").list();
    session.getTransaction().commit();
    session.close();
    return new Users(result);
  }

  public void deleteUser(int id) {
    User user = new User();
    user.setId(id);
    Session session = getSession();
    session.delete(user);
    session.getTransaction().commit();
    session.close();
  }


  private Session getSession() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    return session;
  }

}
