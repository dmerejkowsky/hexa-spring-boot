package fr.arolla.hexa;

import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class SqliteRepository implements Repository {
  private final Connection connection;


  public SqliteRepository() {
    try {
      connection = DriverManager.getConnection("jdbc:sqlite:facts.db");
    } catch (SQLException e) {
      throw new RuntimeException("Could not create connection: " + e);
    }
  }

  @Override
  public String getFactById(int id) {
    try {
      PreparedStatement statement = connection.prepareStatement("SELECT fact FROM facts WHERE id = ?");
      statement.setInt(1, id);
      ResultSet set = statement.executeQuery();
      if (set.isClosed()) {
        throw new NoSuchFactException(id);
      }
      return set.getString(1);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
