package information;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.sql.*;

public class StudselectController {

    @FXML
    private WebView fx_15;

    @FXML
    private TextField fx_1;

    @FXML
    private Button fx_2;

    @FXML
    private TableColumn<student, String> fx_3;

    @FXML
    private TableColumn<student, String> fx_4;

    @FXML
    private TableColumn<student, String> fx_5;

    @FXML
    private TableColumn<student, String> fx_6;

    @FXML
    private TableColumn<student, String> fx_7;

    @FXML
    private TableColumn<student, String> fx_8;

    @FXML
    private TableColumn<student, String> fx_9;

    @FXML
    private TableColumn<student, String> fx_10;

    @FXML
    private TableColumn<student, String> fx_11;

    @FXML
    private TableView<student> fx_12;

    @FXML
    private Button fx_16;


    @FXML
    private void initialize() {
        // Initialize your TableView and set the items
        fx_3.setCellValueFactory(new PropertyValueFactory<>("id"));
        fx_4.setCellValueFactory(new PropertyValueFactory<>("name"));
        fx_5.setCellValueFactory(new PropertyValueFactory<>("gender"));
        fx_6.setCellValueFactory(new PropertyValueFactory<>("age"));
        fx_7.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        fx_8.setCellValueFactory(new PropertyValueFactory<>("photo"));
        fx_9.setCellValueFactory(new PropertyValueFactory<>("phone"));
        fx_10.setCellValueFactory(new PropertyValueFactory<>("totalCredits"));
        fx_11.setCellValueFactory(new PropertyValueFactory<>("major"));
    }

    @FXML
    private void search() throws ClassNotFoundException, SQLException, IOException {
        ObservableList<student> data = FXCollections.observableArrayList();
        String search_student = fx_1.getText();
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");// 建议写上，不写也不会报错
        // 2. 获取数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义sql
        String sql = "SELECT * FROM Student_management.student WHERE sno = '" + search_student + "'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next()) {
            String id = (String) rs.getString("sno");
            String name = (String) rs.getString("sname");
            String gender = (String) rs.getString("sex");
            String age = (String) rs.getString("age");
            String nationality = (String) rs.getString("racial");
            String photo = (String) rs.getString("picture");
            String phone = (String) rs.getString("contact");
            String totalCredits = (String) rs.getString("total_credits");
            String major = (String) rs.getString("major");
            student student1 = new student(id, name, gender, age, nationality, photo, phone, totalCredits, major);
            data.add(student1);
            WebEngine webEngine = fx_15.getEngine();
            String viewaddress = "http://home.ustc.edu.cn/~wangyizhou/sjk/"+photo;
            webEngine.load(viewaddress);
        }
        fx_12.setItems(data);
    }

    @FXML
    private void searchall() throws ClassNotFoundException, SQLException, IOException {
        ObservableList<student> data = FXCollections.observableArrayList();
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
        while (rs.next()) {
            String id = (String) rs.getString("sno");
            String name = (String) rs.getString("sname");
            String gender = (String) rs.getString("sex");
            String age = (String) rs.getString("age");
            String nationality = (String) rs.getString("racial");
            String photo = (String) rs.getString("picture");
            String phone = (String) rs.getString("contact");
            String totalCredits = (String) rs.getString("total_credits");
            String major = (String) rs.getString("major");
            student student1 = new student(id, name, gender, age, nationality, photo, phone, totalCredits, major);
            data.add(student1);
        }
        fx_12.setItems(data);
    }
}





