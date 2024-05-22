package sadd_delete;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;

public class SaddController {

    @FXML
    private TextField fx_1;

    @FXML
    private TextField fx_2;

    @FXML
    private TextField fx_3;

    @FXML
    private TextField fx_4;

    @FXML
    private TextField fx_5;

    @FXML
    private TextField fx_6;

    @FXML
    private Button fx_10;

    @FXML
    private TextField fx_7;

    @FXML
    private TextField fx_8;

    @FXML
    private TextField fx_9;

    @FXML
    private Label fx_11;

    @FXML
    private void button() throws ClassNotFoundException, SQLException {
        String data = "提示信息";
        String new_sno = fx_1.getText();
        String new_sname = fx_2.getText();
        String new_sex = fx_3.getText();
        String nage = fx_4.getText();
        int new_age = Integer.parseInt(nage);
        String new_racial = fx_5.getText();
        String new_picture = fx_6.getText();
        String new_contact = fx_7.getText();
        String new_total_credits = fx_8.getText();
        int new_credits = Integer.parseInt(new_total_credits);
        String new_major = fx_9.getText();

        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");// 建议写上，不写也不会报错
        // 2. 获取数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义sql
        Statement stmt = conn.createStatement();
        String sql = "INSERT INTO student_management.student(sno,sname,sex,age,racial,picture,contact,total_credits,major) VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,new_sno);
        pst.setString(2,new_sname);
        pst.setString(3,new_sex);
        pst.setInt(4,new_age);
        pst.setString(5,new_racial);
        pst.setString(6,new_picture);
        pst.setString(7,new_contact);
        pst.setInt(8,new_credits);
        pst.setString(9,new_major);
        int result = pst.executeUpdate();
        if(result == 1){
            data = "添加学生成功";
        }
        else {
            data = "添加学生失败";
        }
        stmt.close();
        conn.close();
        fx_11.setText(data);
    }
}

