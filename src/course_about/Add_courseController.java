package course_about;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;

public class Add_courseController {

    @FXML
    private TextField fx_1;

    @FXML
    private TextField fx_2;

    @FXML
    private TextField fx_3;

    @FXML
    private TextField fx_4;

    @FXML
    private Button fx_5;

    @FXML
    private Label fx_6;

    @FXML
    private void button() throws ClassNotFoundException, SQLException {
        String data = "提示信息";
        String new_cno = fx_1.getText();
        String new_cname = fx_2.getText();
        String new_ct = fx_3.getText();
        int new_ctime = Integer.parseInt(new_ct);
        String new_cs = fx_4.getText();
        int new_cscore = Integer.parseInt(new_cs);

        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");// 建议写上，不写也不会报错
        // 2. 获取数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义sql
        Statement stmt = conn.createStatement();
        String sql = "INSERT INTO student_management.course(cno,cname,ctime,cscore) VALUES(?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,new_cno);
        pst.setString(2,new_cname);
        pst.setInt(3,new_ctime);
        pst.setInt(4,new_cscore);
        int result = pst.executeUpdate();
        if(result == 1){
            data = "添加课程成功";
        }
        else {
            data = "添加课程失败";
        }
        stmt.close();
        conn.close();
        fx_6.setText(data);
    }



}

