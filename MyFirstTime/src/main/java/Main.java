import java.sql.*;

public class Main {
    private static String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static String LOGIN = "root";
    private static String PASSWORD = "root";
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
             statement.execute("CREATE TABLE `mydbtest`.`cars` (\n" +
                     "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                     "  `brand` VARCHAR(45) NOT NULL,\n" +
                     "  `year` INT NULL,\n" +
                     "  `color` VARCHAR(45) NOT NULL,\n" +
                     "  PRIMARY KEY (`id`),\n" +
                     "  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);\n");
             statement.execute("INSERT INTO cars (brand, year, color) VALUES ('BMW', 2007, 'black');");
             statement.execute("SELECT * FROM cars");
             ResultSet rs = statement.executeQuery("SELECT * FROM cars");
             while (rs.next()) {
                 int id = rs.getInt("id");
                 String brand = rs.getString("brand");
                 int year = rs.getInt("year");
                 String color = rs.getString("color");
             }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
