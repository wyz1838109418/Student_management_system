package sadd_delete;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Sadd_deleteController {

    @FXML
    private Button fx_1;

    @FXML
    private Button fx_2;

    @FXML
    private void Addstudent() {
        try {
            // 加载另一个FXML文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sadd.fxml"));
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
    private void Deletestudent() {
        try {
            // 加载另一个FXML文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sdelete.fxml"));
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

