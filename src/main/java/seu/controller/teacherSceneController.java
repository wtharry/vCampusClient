package seu.controller;

/**
 * Created by Q on 2017/9/13.
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class teacherSceneController {
    @FXML
    private AnchorPane teacherView;

    private int teacherID;

    private String password;

    public void showTeacherInfo(ActionEvent actionEvent) throws IOException {
       teacherView.getChildren().clear();

        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view//teacherInfoPane.fxml"));
        Parent child =loader.load();
        teacherInfoPaneController teaInfo =loader.< teacherInfoPaneController>getController();
        teaInfo.setData(this.teacherID,password);

        teacherView.getChildren().add(child);
    }

    public void classManage(ActionEvent actionEvent) throws IOException {
        teacherView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view//classManagePane.fxml"));
        teacherView.getChildren().add(child);
    }

    public void CourseManage(ActionEvent actionEvent) throws IOException {
        teacherView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view//courseManagePane.fxml"));
        teacherView.getChildren().add(child);
    }

    public void exit(ActionEvent actionEvent) throws IOException {
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass()
                .getResource("/view//MyScene.fxml"));
        Stage stg = new Stage();
        stg.setTitle("虚拟校园登陆");
        Scene Scene = new Scene(root, 600, 400);
        stg.setScene(Scene);
        Scene.getStylesheets().add(
                getClass().getResource("/view//login.css")
                        .toExternalForm());
        stg.getIcons().add(new Image("/images/01.png"));
        stg.setResizable(false);
        stg.show();
    }

    public void setData(int teacherID,String password) throws IOException {
        this.teacherID=teacherID;
        this.password=password;
        teacherView.getChildren().clear();

        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view//teacherInfoPane.fxml"));
        Parent child =loader.load();
        teacherInfoPaneController teaInfo =loader.< teacherInfoPaneController>getController();
        teaInfo.setData(this.teacherID,password);

        teacherView.getChildren().add(child);
    }
}
