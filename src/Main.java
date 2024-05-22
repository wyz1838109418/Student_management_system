import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");// 建议写上，不写也不会报错
        // 2. 获取数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义sql
        String sql = "SELECT * FROM Student_management.student";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        // 4. 获取执行sql的对象 Statement
        rs.next();
        String id = rs.getString("sno");
        System.out.println(id);
        // 7. 释放资源
        stmt.close();
        conn.close();
    }
}