package seu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

import static com.sun.org.apache.xerces.internal.utils.SecuritySupport.getResourceAsStream;

import seu.controller.MyController;
import seu.controller.schoolrollPaneController;
/**
 * Created by Q on 2017/9/9.
 */

public class studentController {

    @FXML
    private AnchorPane changeView;
    @FXML
    private Button schoolroll;

    @FXML
    private Button Course;

    @FXML
    private Button library;

    @FXML
    private Button dormitory;

    @FXML
    private Button commodity;

    private int ID;
    private String password;

    public studentController() throws IOException {
        ImageView delICON = new ImageView(getClass().getResource("/images/information.png").toString());
        /*schoolroll.setGraphic(deICON);*/

    }

    public void showSchoolrollInfo(ActionEvent actionEvent) throws IOException {

        changeView.getChildren().clear();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view//schoolrollPane.fxml"));
        Parent child =loader.load();
        schoolrollPaneController schroll =loader.<schoolrollPaneController>getController();
        schroll.setData(this.ID,password);

        changeView.getChildren().add(child);

    }



    public void showLibraryInfo(ActionEvent actionEvent) throws IOException {
        changeView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view//LibraryTest.fxml"));
        changeView.getChildren().add(child);

    }
    

    public void showDormitoryInfo(ActionEvent actionEvent) throws IOException {
        changeView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view//dormitoryPane.fxml"));


        changeView.getChildren().add(child);

    }

    public void showCourseInfo(ActionEvent actionEvent) throws IOException {
        changeView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view//CourseTest.fxml"));
        changeView.getChildren().add(child);


    }

    public void showCommodityInfo(ActionEvent actionEvent) throws IOException {
        changeView.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view//commodityPane.fxml"));
        changeView.getChildren().add(child);


    }



    public void getData( int id,String pw)
    {
       this.ID=id;
       this.password=pw;
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
}
