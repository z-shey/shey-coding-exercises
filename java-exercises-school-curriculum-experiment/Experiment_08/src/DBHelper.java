
/**
 * 连接数据库的代码全部写到该类里面
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBHelper {
    /*
     * localhost:表示本地服务()
     * 1433：连接sqlserver的端口号
     */
    private static final String URL = "jdbc:sqlserver://192.168.136.129:1433;DatabaseName=Algorithm_SQL";//数据库名称
    private static final String CLASS_NAME = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    //	2.加载驱动/注册驱动:只需要执行一次
    static{
        try {
            Class.forName(CLASS_NAME);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * 3.得到连接对象的方法
     * 无参有返回值
     * @return con 连接对象
     */
    public static Connection getCon() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, "sa", "Root123");//"a"是数据库登录账户 "bc"是数据库登录密码
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 4.释放资源
     * @param con 连接对象
     * @param ps 执行对象
     * @param rs 结果集对象
     */
    public static void closeObj(Connection con,PreparedStatement ps,ResultSet rs) {
        try {
            if(con != null && !con.isClosed()) {
                con.close();
            }
            if(ps != null) {
                ps.close();
            }
            if(rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println(DBHelper.getCon());
    }
}