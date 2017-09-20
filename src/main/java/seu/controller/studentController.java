package seu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


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

    private int studentID;
    private String password;

    public studentController() throws IOException {
        ImageView delICON = new ImageView(getClass().getResource("/images/information.png").toString());



    }

    public void showSchoolrollInfo(ActionEvent actionEvent) throws IOException {

        changeView.getChildren().clear();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/schoolrollPane.fxml"));
        Parent child =loader.load();
        schoolrollPaneController schroll =loader.<schoolrollPaneController>getController();
        schroll.setData(this.studentID,password);

        changeView.getChildren().add(child);

    }



    public void showLibraryInfo(ActionEvent actionEvent) throws IOException {
        changeView.getChildren().clear();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/LibraryTest.fxml"));
        Parent child =loader.load();
        LibraryTestController lib =loader.<     LibraryTestController>getController();
        lib.getStudentID(this.studentID);
        System.out.print("跳转");
        System.out.print(this.studentID);
        changeView.getChildren().add(child);

    }
    

    public void showDormitoryInfo(ActionEvent actionEvent) throws IOException {
        changeView.getChildren().clear();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/dormitoryPane.fxml"));
        Parent child =loader.load();


        dormitoryPaneController dor =loader.<       dormitoryPaneController>getController();
        dor.setInfo(this.studentID);


        changeView.getChildren().add(child);

    }

    public void showCourseInfo(ActionEvent actionEvent) throws IOException {
        changeView.getChildren().clear();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/CourseTest.fxml"));
        Parent child =loader.load();
        courseTestController cou =loader.<        courseTestController>getController();
        cou.getstudentID(this.studentID);
        changeView.getChildren().add(child);


    }

    public void showCommodityInfo(ActionEvent actionEvent) throws IOException {
        changeView.getChildren().clear();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/commodityPane.fxml"));
        Parent child =loader.load();
        commodityPaneController shop =loader.<       commodityPaneController>getController();
        shop.getStudentID(this.studentID);
        shop.setBalance(this.studentID);

        changeView.getChildren().add(child);


    }



    public void getData( int id,String pw) throws IOException {
       this.studentID=id;
       this.password=pw;
        changeView.getChildren().clear();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/schoolrollPane.fxml"));
        Parent child =loader.load();
        schoolrollPaneController schroll =loader.<schoolrollPaneController>getController();
        schroll.setData(this.studentID,password);


        changeView.getChildren().add(child);

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
}
