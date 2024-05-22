import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.util.Objects;


public class Menu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // 加载FXML文件
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));

        // 创建Scene
        Scene scene = new Scene(root, 900, 600);

        // 设置Stage的标题
        primaryStage.setTitle("学籍管理系统");

        // 将Scene添加到Stage中
        primaryStage.setScene(scene);

        // 显示Stage
        primaryStage.show();

    }


}
