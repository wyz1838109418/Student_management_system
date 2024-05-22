package course_about;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;

public class Select_courseController {

    @FXML
    private TextField fx_1;

    @FXML
    private TextField fx_2;

    @FXML
    private TextField fx_3;

    @FXML
    private Button fx_4;

    @FXML
    private Button fx_5;

    @FXML
    private Label fx_6;

    @FXML
    private void button1() throws ClassNotFoundException, SQLException {
        String data = "提示信息";
        String new_sno = fx_1.getText();
        String new_cno = fx_2.getText();
        String new_score = fx_3.getText();
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");// 建议写上，不写也不会报错
        // 2. 获取数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义sql
        Statement stmt = conn.createStatement();
        String sql = "INSERT INTO student_management.select_course(sno, cno, score) VALUES(?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,new_sno);
        pst.setString(2,new_cno);
        pst.setString(3,new_score);
        int result = pst.executeUpdate();
        if(result == 1){
            data = "录入成绩成功";
        }
        else {
            data = "录入成绩失败";
        }
        stmt.close();
        conn.close();
        fx_6.setText(data);
    }

    @FXML
    private void button2() throws ClassNotFoundException, SQLException {
        String data = "提示信息";
        String new_sno = fx_1.getText();
        String new_cno = fx_2.getText();
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");// 建议写上，不写也不会报错
        // 2. 获取数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义sql
        Statement stmt = conn.createStatement();
        String sql = "DELETE FROM student_management.select_course WHERE sno = ? AND cno = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,new_sno);
        pst.setString(2,new_cno);
        int result = pst.executeUpdate();
        if(result == 1){
            data = "取消成绩成功";
        }
        else {
            data = "取消成绩失败";
        }
        stmt.close();
        conn.close();
        fx_6.setText(data);
    }



}

