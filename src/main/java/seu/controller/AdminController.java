package seu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {
    @FXML
    private AnchorPane adminView;

    @FXML
    private ImageView adminTest;

    private int adminID;

    private String password;


    public void showStudentManage(ActionEvent actionEvent) throws IOException {
        adminView.getChildren().clear();

        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/StudentManage.fxml"));
        Parent child =loader.load();

        adminView.getChildren().add(child);



    }

    public void showTeacherManage(ActionEvent actionEvent) throws IOException {
        adminView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view/TeacherManage.fxml"));
        adminView.getChildren().add(child);
    }

    public void showLibraryManage(ActionEvent actionEvent) throws IOException {
        adminView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view/LibraryManage.fxml"));
        adminView.getChildren().add(child);
    }

    public void showDormitoryManage(ActionEvent actionEvent) throws IOException {
        adminView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view/DormitoryManage.fxml"));
        adminView.getChildren().add(child);

    }

    public void showShopManage(ActionEvent actionEvent) throws IOException {
        adminView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view/ShopManage.fxml"));
        adminView.getChildren().add(child);

    }

    public void exit(ActionEvent actionEvent) throws IOException {
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass()
                .getResource("/view/MyScene.fxml"));
        Stage stg = new Stage();
        stg.setTitle("虚拟校园登陆");
        Scene Scene = new Scene(root, 600, 400);
        stg.setScene(Scene);
        Scene.getStylesheets().add(
                getClass().getResource("/view/login.css")
                        .toExternalForm());
        stg.getIcons().add(new Image("/images/01.png"));
        stg.setResizable(false);
        stg.show();
    }

    public void setData(int adminID,String password) throws IOException {
        this.adminID=adminID;
        this.password=password;
        adminView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view/StudentManage.fxml"));
        adminView.getChildren().add(child);
    }
}