package course_about;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Course_aboutController {

    @FXML
    private Button fx_1;

    @FXML
    private Button fx_2;

    @FXML
    private Button fx_3;

    @FXML
    private Button fx_4;

    @FXML
    private Button fx_5;

    @FXML
    private void Search_course() {
        try {
            // 加载另一个FXML文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("search_course.fxml"));
            Parent newWindowRoot = loader.load();

            // 创建新的Scene
            Scene newWindowScene = new Scene(newWindowRoot, 900, 600);

            // 创建新的Stage
            Stage newWindowStage = new Stage();
            newWindowStage.setTitle("New Window");

            // 将Scene添加到新的Stage中
            newWindowStage.setScene(newWindowScene);

            // 显示新的Stage
            newWindowStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Add_course() {
        try {
            // 加载另一个FXML文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("add_course.fxml"));
            Parent newWindowRoot = loader.load();

            // 创建新的Scene
            Scene newWindowScene = new Scene(newWindowRoot, 900, 600);

            // 创建新的Stage
            Stage newWindowStage = new Stage();
            newWindowStage.setTitle("New Window");

            // 将Scene添加到新的Stage中
            newWindowStage.setScene(newWindowScene);

            // 显示新的Stage
            newWindowStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Delete_course() {
        try {
            // 加载另一个FXML文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("delete_course.fxml"));
            Parent newWindowRoot = loader.load();

            // 创建新的Scene
            Scene newWindowScene = new Scene(newWindowRoot, 900, 600);

            // 创建新的Stage
            Stage newWindowStage = new Stage();
            newWindowStage.setTitle("New Window");

            // 将Scene添加到新的Stage中
            newWindowStage.setScene(newWindowScene);

            // 显示新的Stage
            newWindowStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Select_course() {
        try {
            // 加载另一个FXML文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("select_course.fxml"));
            Parent newWindowRoot = loader.load();

            // 创建新的Scene
            Scene newWindowScene = new Scene(newWindowRoot, 900, 600);

            // 创建新的Stage
            Stage newWindowStage = new Stage();
            newWindowStage.setTitle("New Window");

            // 将Scene添加到新的Stage中
            newWindowStage.setScene(newWindowScene);

            // 显示新的Stage
            newWindowStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Search_student_course() {
        try {
            // 加载另一个FXML文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ssc.fxml"));
            Parent newWindowRoot = loader.load();

            // 创建新的Scene
            Scene newWindowScene = new Scene(newWindowRoot, 900, 600);

            // 创建新的Stage
            Stage newWindowStage = new Stage();
            newWindowStage.setTitle("New Window");

            // 将Scene添加到新的Stage中
            newWindowStage.setScene(newWindowScene);

            // 显示新的Stage
            newWindowStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

