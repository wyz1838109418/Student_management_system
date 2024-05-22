package course_about;

import course_about.course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class Search_courseController{

    @FXML
    private TextField fx_1;

    @FXML
    private Button fx_2;

    @FXML
    private TableColumn<course, String> fx_3;

    @FXML
    private TableColumn<course, String> fx_4;

    @FXML
    private TableColumn<course, String> fx_5;

    @FXML
    private TableColumn<course, String> fx_6;

    @FXML
    private TableView<course> fx_7;

    @FXML
    private Button fx_10;


    @FXML
    private void initialize() {
        // Initialize your TableView and set the items
        fx_3.setCellValueFactory(new PropertyValueFactory<>("cno"));
        fx_4.setCellValueFactory(new PropertyValueFactory<>("cname"));
        fx_5.setCellValueFactory(new PropertyValueFactory<>("ctime"));
        fx_6.setCellValueFactory(new PropertyValueFactory<>("cscore"));
    }

    @FXML
    private void search() throws ClassNotFoundException, SQLException {
        ObservableList<course> data = FXCollections.observableArrayList();
        String search_course = fx_1.getText();
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");// 建议写上，不写也不会报错
        // 2. 获取数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义sql
        String sql = "SELECT * FROM Student_management.course WHERE cno = '" + search_course + "'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            String cno = (String) rs.getString("cno");
            String cname = (String) rs.getString("cname");
            String ctime = (String) rs.getString("ctime");
            String cscore = (String) rs.getString("cscore");
            course course1 = new course(cno, cname, ctime, cscore);
            data.add(course1);
        }
        fx_7.setItems(data);
    }

    @FXML
    private void searchall() throws ClassNotFoundException, SQLException {
        ObservableList<course> data = FXCollections.observableArrayList();
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");// 建议写上，不写也不会报错
        // 2. 获取数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义sql
        String sql = "SELECT * FROM Student_management.course";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String cno = (String) rs.getString("cno");
            String cname = (String) rs.getString("cname");
            String ctime = (String) rs.getString("ctime");
            String cscore = (String) rs.getString("cscore");
            course course1 = new course(cno, cname, ctime, cscore);
            data.add(course1);
        }
        fx_7.setItems(data);
    }

}

