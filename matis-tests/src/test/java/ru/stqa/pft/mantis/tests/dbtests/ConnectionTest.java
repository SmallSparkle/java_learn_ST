package ru.stqa.pft.mantis.tests.dbtests;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.models.UserData;
import ru.stqa.pft.mantis.models.Users;

import java.sql.*;

public class ConnectionTest {

  @Test
  public void testDbConnection() {

    Connection conn = null;
    try {
      conn =
              DriverManager.getConnection("jdbc:mysql://localhost:3306/bugtracker?user=root&password=");
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("select id, username, email");
      Users users = new Users();
      while (rs.next()) {
        users.add(new UserData().setId(rs.getInt("id"))
                        .setUsername(rs.getString("username"))
                        .setUsername(rs.getString("username"))
                        .setEmail(rs.getString("email")));
      }
      rs.close();
      st.close();
      conn.close();

      System.out.println(users);

    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }

  }
}
