package sadd_delete;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;

public class SdeleteController{

    @FXML
    private TextField fx_1;

    @FXML
    private Button fx_2;

    @FXML
    private Label fx_3;

    @FXML
    private void button() throws ClassNotFoundException, SQLException {
        String data = "提示信息";
        String delete_sno = fx_1.getText();

        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");// 建议写上，不写也不会报错
        // 2. 获取数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义sql
        Statement stmt = conn.createStatement();
        String sql = "call student_management.delete_student(?)";
        //String sql = "DELETE FROM student_management.student where sno = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,delete_sno);
        int result = pst.executeUpdate();
        data = "删除学生成功";
        stmt.close();
        conn.close();
        fx_3.setText(data);
    }

}

