package information;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentinfoController {

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
    private Button fx_6;

    @FXML
    private Button fx_7;

    @FXML
    private Button fx_8;


    @FXML
    private void Close() {
        Platform.exit();
    }

    @FXML
    private void Studselect() {
        try {
            // 加载另一个FXML文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("studselect.fxml"));
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
    private void Updateage() {
        try {
            // 加载另一个FXML文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("age.fxml"));
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
    private void Updategender() {
        try {
            // 加载另一个FXML文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("gender.fxml"));
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
    private void Updateantionality() {
        try {
            // 加载另一个FXML文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("antionality.fxml"));
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
    private void Updatemajor() {
        try {
            // 加载另一个FXML文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("major.fxml"));
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
    private void Updatephone() {
        try {
            // 加载另一个FXML文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("phone.fxml"));
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
    private void Updatephoto() {
        try {
            // 加载另一个FXML文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("photo.fxml"));
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

