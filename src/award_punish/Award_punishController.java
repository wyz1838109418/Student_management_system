package award_punish;

import award_punish.aw_pu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class Award_punishController {

    @FXML
    private TextField fx_1;

    @FXML
    private Button fx_2;

    @FXML
    private Button fx_3;

    @FXML
    private Button fx_4;

    @FXML
    private TextField fx_5;

    @FXML
    private TableColumn<aw_pu, String> fx_11;

    @FXML
    private Button fx_6;

    @FXML
    private TableColumn<aw_pu, String> fx_10;

    @FXML
    private Button fx_7;

    @FXML
    private Button fx_8;

    @FXML
    private TableView<aw_pu> fx_12;

    @FXML
    private Label fx_9;

    @FXML
    private Button fx_14;

    @FXML
    private Button fx_13;

    @FXML
    private Button fx_15;

    @FXML
    private Button fx_16;

    @FXML
    private void initialize() {
        // Initialize your TableView and set the items
        fx_10.setCellValueFactory(new PropertyValueFactory<>("sno"));
        fx_11.setCellValueFactory(new PropertyValueFactory<>("apname"));
    }

    @FXML
    private void asearch() throws ClassNotFoundException, SQLException {
        ObservableList<aw_pu> data = FXCollections.observableArrayList();
        String search_sno = fx_1.getText();;
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");// 建议写上，不写也不会报错
        // 2. 获取数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义sql
        String sql = "SELECT * FROM Student_management.asituation WHERE sno = '" + search_sno + "'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String sno = (String) rs.getString("sno");
            String aname = (String) rs.getString("aname");
            aw_pu a_p = new aw_pu(sno, aname);
            data.add(a_p);
        }
        fx_12.setItems(data);
    }

    @FXML
    private void psearch() throws ClassNotFoundException, SQLException {
        ObservableList<aw_pu> data = FXCollections.observableArrayList();
        String search_sno = fx_1.getText();;
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");// 建议写上，不写也不会报错
        // 2. 获取数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义sql
        String sql = "SELECT * FROM Student_management.psituation WHERE sno = '" + search_sno + "'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String sno = (String) rs.getString("sno");
            String pname = (String) rs.getString("pname");
            aw_pu a_p = new aw_pu(sno, pname);
            data.add(a_p);
        }
        fx_12.setItems(data);
    }

    @FXML
    private void a_add() throws ClassNotFoundException, SQLException {
        String data = "提示信息";
        String add_sno = fx_1.getText();
        String add_award = fx_5.getText();
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");// 建议写上，不写也不会报错
        // 2. 获取数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义sql
        Statement stmt = conn.createStatement();
        String sql = "INSERT INTO student_management.asituation(sno,aname) VALUES(?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,add_sno);
        pst.setString(2,add_award);
        int result = pst.executeUpdate();
        if(result == 1){
            data = "添加奖项成功";
        }
        else {
            data = "添加奖项失败";
        }
        stmt.close();
        conn.close();
        fx_9.setText(data);
    }

    @FXML
    private void p_add() throws ClassNotFoundException, SQLException {
        String data = "提示信息";
        String add_sno = fx_1.getText();
        String add_punish = fx_5.getText();
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");// 建议写上，不写也不会报错
        // 2. 获取数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义sql
        Statement stmt = conn.createStatement();
        String sql = "INSERT INTO student_management.psituation(sno,pname) VALUES(?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,add_sno);
        pst.setString(2,add_punish);
        int result = pst.executeUpdate();
        if(result == 1){
            data = "添加惩罚成功";
        }
        else {
            data = "添加惩罚失败";
        }
        stmt.close();
        conn.close();
        fx_9.setText(data);
    }

    @FXML
    private void a_delete() throws ClassNotFoundException, SQLException {
        String data = "提示信息";
        String delete_sno = fx_1.getText();
        String delete_award = fx_5.getText();

        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");// 建议写上，不写也不会报错
        // 2. 获取数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义sql
        Statement stmt = conn.createStatement();
        String sql = "call student_management.delete_award(?,?)";
        //String sql = "DELETE FROM student_management.student where sno = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,delete_sno);
        pst.setString(2,delete_award);
        int result = pst.executeUpdate();
        data = "删除奖项成功";
        stmt.close();
        conn.close();
        fx_9.setText(data);
    }

    @FXML
    private void p_delete() throws ClassNotFoundException, SQLException {
        String data = "提示信息";
        String delete_sno = fx_1.getText();
        String delete_punish = fx_5.getText();

        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");// 建议写上，不写也不会报错
        // 2. 获取数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义sql
        Statement stmt = conn.createStatement();
        String sql = "call student_management.delete_punishment(?,?)";
        //String sql = "DELETE FROM student_management.student where sno = ?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,delete_sno);
        pst.setString(2,delete_punish);
        int result = pst.executeUpdate();
        data = "删除惩罚成功";
        stmt.close();
        conn.close();
        fx_9.setText(data);
    }

    @FXML
    private void add_award() throws ClassNotFoundException, SQLException {
        String data = "提示信息";
        String new_aname = fx_5.getText();

        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");// 建议写上，不写也不会报错
        // 2. 获取数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义sql
        Statement stmt = conn.createStatement();
        String sql = "INSERT INTO student_management.award(aname) VALUES(?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,new_aname);
        int result = pst.executeUpdate();
        if(result == 1){
            data = "添加奖励类成功";
        }
        else {
            data = "添加奖励类失败";
        }
        stmt.close();
        conn.close();
        fx_9.setText(data);
    }

    @FXML
    private void add_punish() throws ClassNotFoundException, SQLException {
        String data = "提示信息";
        String new_punish = fx_5.getText();

        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");// 建议写上，不写也不会报错
        // 2. 获取数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义sql
        Statement stmt = conn.createStatement();
        String sql = "INSERT INTO student_management.punishment(pname) VALUES(?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,new_punish);
        int result = pst.executeUpdate();
        if(result == 1){
            data = "添加惩罚类成功";
        }
        else {
            data = "添加惩罚类失败";
        }
        stmt.close();
        conn.close();
        fx_9.setText(data);
    }

    @FXML
    private void delete_award() throws ClassNotFoundException, SQLException {
        String data = "提示信息";
        String delete_aname = fx_5.getText();

        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");// 建议写上，不写也不会报错
        // 2. 获取数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义sql
        Statement stmt = conn.createStatement();
        String sql = "DELETE FROM student_management.award WHERE aname=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,delete_aname);
        int result = pst.executeUpdate();
        data = "删除奖励类成功";
        stmt.close();
        conn.close();
        fx_9.setText(data);
    }

    @FXML
    private void delete_punish() throws ClassNotFoundException, SQLException {
        String data = "提示信息";
        String delete_pname = fx_5.getText();

        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");// 建议写上，不写也不会报错
        // 2. 获取数据库连接
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 3. 定义sql
        Statement stmt = conn.createStatement();
        String sql = "DELETE FROM student_management.punishment WHERE pname=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1,delete_pname);
        int result = pst.executeUpdate();
        data = "删除惩罚类成功";
        stmt.close();
        conn.close();
        fx_9.setText(data);
    }

}

