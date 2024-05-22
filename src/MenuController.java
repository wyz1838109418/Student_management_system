import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

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
    private Text title;

    @FXML
    private void Close() {
        Platform.exit();
    }

    @FXML
    private void Stuinfo() {
        try {
            // 加载另一个FXML文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("information/studentinfo.fxml"));
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
    private void Sadd_delete() {
        try {
            // 加载另一个FXML文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sadd_delete/sadd_delete.fxml"));
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
    private void Course_about() {
        try {
            // 加载另一个FXML文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("course_about/course_about.fxml"));
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
    private void Award_Punish() {
        try {
            // 加载另一个FXML文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("award_punish/award_punish.fxml"));
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
