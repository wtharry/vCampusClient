package seu.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import seu.domain.Teacher;
import seu.service.TeacherService;

import java.io.IOException;

@Component
public class TeacherManage {
    @FXML
    TeacherService teacherService;

    @FXML
    private TextField teacherIDDel;

    @FXML
    private TextField teacherIDAdd;

    @FXML
    private TextField teacherPhoneNumberAdd;

    @FXML
    private TextField teacherNameAdd;

    @FXML
    private TextField teacherIDSearch;

    @FXML
    private TextField passwordAdd;

    @FXML
    private AnchorPane teacherManagePane;


    public void teacherInfoFind(ActionEvent actionEvent) throws IOException {

        teacherManagePane.getChildren().clear();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view//AdminTeacherInfoManagePane.fxml"));
        Parent child =loader.load();
        AdminTeacherInfoManagePaneController admin =loader.<AdminTeacherInfoManagePaneController>getController();
        admin.setData(Integer.valueOf(teacherIDSearch.getText()));
        teacherManagePane.getChildren().add(child);
    }

    public void delConfirm(ActionEvent actionEvent) {
        teacherService.deleteTeacher(Integer.valueOf(teacherIDDel.getText()));


        Stage window = new Stage();
        window.setTitle("title");
        //modality要使用Modality.APPLICATION_MODEL
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(300);
        window.setMinHeight(150);

        Button button = new Button("确认");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }

        });

        Label label = new Label("删除成功");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label , button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();
    }

    public void teacherAddConfirm(ActionEvent actionEvent) {
        Teacher tea=new Teacher(Integer.valueOf(teacherIDAdd.getText()),teacherNameAdd.getText(),
                Integer.valueOf(teacherPhoneNumberAdd.getText()),passwordAdd.getText());
        teacherService.insertTeacher(tea);

        Stage window = new Stage();
        window.setTitle("title");
        //modality要使用Modality.APPLICATION_MODEL
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(300);
        window.setMinHeight(150);

        Button button = new Button("确认");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }

        });

        Label label = new Label("添加成功");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label , button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();
    }
}
