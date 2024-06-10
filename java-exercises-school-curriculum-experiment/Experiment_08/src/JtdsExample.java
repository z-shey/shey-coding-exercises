import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JtdsExample {

    public static void main(String[] args) {
        String URL = "jdbc:jtds:sqlserver://192.168.136.144/Algorithm_SQL";
        String USERNAME = "sa";
        String PASSWORD = "Root123";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM ALG.Alumni")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("sno");
                String name = resultSet.getString("email");
                System.out.println("ID: " + id + ", Name: " + name);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
