package information;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;

public class GenderController {

    @FXML
    private TextField fx_1;

    @FXML
    private TextField fx_2;

    @FXML
    private Button fx_3;

    @FXML
    private Label fx_4;

    @FXML
    private void button() throws ClassNotFoundException, SQLException {
        String data = "提示信息";
        String chose_student = fx_1.getText();
        String new_gender = fx_2.getText();
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");// 建议写上，不写也不会报错
        // 2. 获取数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义sql
        Statement stmt = conn.createStatement();
        String sql = "update Student_management.student set sex=? where sno=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,new_gender);
        pst.setString(2,chose_student);
        int result = pst.executeUpdate();
        if(result == 1){
            data = "修改成功";
        }
        else {
            data = "修改失败";
        }
        stmt.close();
        conn.close();
        fx_4.setText(data);
    }

}

