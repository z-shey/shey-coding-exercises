import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SS {
    public static void main(String[] args) {
        // 数据库连接参数
//        String url = "jdbc:sqlserver://192.168.136.144;databaseName=Algorithm_SQL;ssl=required;sslProtocol=TLSv1.2";
        String url = "jdbc:sqlserver://192.168.136.144;databaseName=Algorithm_SQL;encrypt=false";

        String user = "sa";
        String password = "Root123";


        // 加载数据库驱动
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到数据库驱动类");
            e.printStackTrace();
            return;
        }

        // 连接数据库
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("成功连接到数据库");

            // 执行查询
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM ALG.Alumni")) {
                while (rs.next()) {
                    // 处理查询结果
                    System.out.println(rs.getString("columnName"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
