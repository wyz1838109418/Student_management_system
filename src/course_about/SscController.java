package course_about;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class SscController {

    @FXML
    private TextField fx_1;

    @FXML
    private Button fx_2;

    @FXML
    private TableColumn<select_course, String> fx_3;

    @FXML
    private TableColumn<select_course, String> fx_4;

    @FXML
    private TableColumn<select_course, String> fx_5;

    @FXML
    private TableView<select_course> fx_6;

    @FXML
    private void initialize() {
        // Initialize your TableView and set the items
        fx_3.setCellValueFactory(new PropertyValueFactory<>("sno"));
        fx_4.setCellValueFactory(new PropertyValueFactory<>("cno"));
        fx_5.setCellValueFactory(new PropertyValueFactory<>("score"));
    }

    @FXML
    private void search() throws ClassNotFoundException, SQLException {
        ObservableList<select_course> data = FXCollections.observableArrayList();
        String search_sno = fx_1.getText();
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");// 建议写上，不写也不会报错
        // 2. 获取数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义sql
        String sql = "SELECT * FROM Student_management.select_course WHERE sno = '" + search_sno + "'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String sno = (String) rs.getString("sno");
            String cno = (String) rs.getString("cno");
            String score = (String) rs.getString("score");
            select_course s1 = new select_course(sno, cno, score);
            data.add(s1);
        }
        fx_6.setItems(data);
    }

}


