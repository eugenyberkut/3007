package logic;

import java.sql.*;

/**
 * Created by Yevhen on 30.07.2015.
 */
public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/3007", "eugeny", "nbuser");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM actor, film, actor_has_film " +
                            "WHERE actor_id=actor.id AND film_id=film.id");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String nazvanie = resultSet.getString("nazvanie");
                System.out.println(nazvanie + " : " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
