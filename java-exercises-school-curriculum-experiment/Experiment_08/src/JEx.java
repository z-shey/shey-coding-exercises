import java.sql.*;

public class JEx {

    public static void main(String[] args) {
        String URL = "jdbc:jtds:sqlserver://192.168.136.144";
        String DATABASE = "Employees";
        String USERNAME = "sa";
        String PASSWORD = "Root123";

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {

            // Create database if it doesn't exist
            statement.executeUpdate("IF NOT EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = '" + DATABASE + "') CREATE DATABASE " + DATABASE);

            // Use the database
            connection.setCatalog(DATABASE);

            // Create table if it doesn't exist
            String createTableQuery = "IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'employee') " +
                    "CREATE TABLE employee (sno INT, name VARCHAR(255), post VARCHAR(255), salary VARCHAR(255));";
            statement.executeUpdate(createTableQuery);

            // Prepare the insert statement
            String insertDataQuery = "INSERT INTO employee (sno, name, post, salary) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertDataQuery);

            // Insert multiple data
            Object[][] data = {
                    {1, "张三", "工程师", 5000},
                    {2, "李四", "工程师", 5000},
                    {3, "李四", "工程师", 5000}
            };
            for (int i = 0; i < data.length; i++) {
                preparedStatement.setObject(1, data[i][0]);  // 第一个参数
                preparedStatement.setObject(2, data[i][1]);  // 第二个参数
                preparedStatement.setObject(3, data[i][2]);  // 第三个参数
                preparedStatement.setObject(4, data[i][3]);  // 第四个参数
                preparedStatement.addBatch();
            }

            // Execute the batch insert
            preparedStatement.executeBatch();

            // Query data from table
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee");

            while (resultSet.next()) {
                int sno = resultSet.getInt("sno");
                String name = resultSet.getString("name");
                String post = resultSet.getString("post");
                String salary = resultSet.getString("salary");
                System.out.println("sno: " + sno + ", Name: " + name + ", Post: " + post + ", Salary: " + salary);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
