package seu.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import seu.domain.Teacher;
import seu.service.TeacherService;
/**
 * Created by Q on 2017/9/13.
 */


public class teacherInfoPaneController {
    TeacherService teacherService=new TeacherService();

    @FXML
    private  TextField teacherIDtext;

    @FXML
    private TextField teacherName;

    @FXML
    private TextField teacherPhoneNumber;

    @FXML
    private TextField oldPassword;

    @FXML
    private TextField newPassword;

    @FXML
    private TextField newPasswordConfirm;




    private int teacherID;
    private String password;

    public void setData(int teacherID,String password)

    {

        this.teacherID=teacherID;
        this.password=password;
        teacherIDtext.setText(String.valueOf(teacherID));
        teacherName.setText(teacherService.queryTeacherByTeacherId(teacherID).getTeacherName());
        teacherPhoneNumber.setText(String.valueOf(teacherService.queryTeacherByTeacherId(teacherID).getTeacherPhoneNumber()));
        teacherIDtext.setEditable(false);
        teacherName.setEditable(false);
        teacherPhoneNumber.setEditable(false);
        oldPassword.setEditable(false);
        newPassword.setEditable(false);
        newPasswordConfirm.setEditable(false);
    }

    public void changePassword(ActionEvent actionEvent) {
        oldPassword.setEditable(true);
        newPassword.setEditable(true);
        newPasswordConfirm.setEditable(true);


    }

    public void passwordChangeConfirm(ActionEvent actionEvent) {

        if(teacherService.login(teacherID,password)==1&&(Integer.valueOf(newPassword.getText())==Integer.valueOf(newPasswordConfirm.getText())))
        {
            teacherService.updateTeacherPassword(teacherID,newPassword.getText());
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

            Label label = new Label("更改成功");

            VBox layout = new VBox(10);
            layout.getChildren().addAll(label , button);
            layout.setAlignment(Pos.CENTER);

            Scene scene = new Scene(layout);
            window.setScene(scene);
            //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
            window.showAndWait();
        }

        else

        {
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

            Label label = new Label("请检查密码输入");

            VBox layout = new VBox(10);
            layout.getChildren().addAll(label , button);
            layout.setAlignment(Pos.CENTER);

            Scene scene = new Scene(layout);
            window.setScene(scene);
            //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
            window.showAndWait();
        }
        oldPassword.setEditable(false);
        newPassword.setEditable(false);
        newPasswordConfirm.setEditable(false);
    }

    public void changeInfo(ActionEvent actionEvent) {

        teacherIDtext.setEditable(true);
        teacherName.setEditable(true);
        teacherPhoneNumber.setEditable(true);

    }

    public void confirmChange(ActionEvent actionEvent) {
        Teacher tea=new Teacher(Integer.valueOf(teacherIDtext.getText()), teacherName.getText(),Integer.valueOf(teacherPhoneNumber.getText()),this.password);
        if(teacherService.updateTeacher(tea)==1)
        {
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

            Label label = new Label("更改成功");

            VBox layout = new VBox(10);
            layout.getChildren().addAll(label , button);
            layout.setAlignment(Pos.CENTER);

            Scene scene = new Scene(layout);
            window.setScene(scene);
            //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
            window.showAndWait();
        }
        else
        {
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

            Label label = new Label("更改失败");

            VBox layout = new VBox(10);
            layout.getChildren().addAll(label , button);
            layout.setAlignment(Pos.CENTER);

            Scene scene = new Scene(layout);
            window.setScene(scene);
            //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
            window.showAndWait();
        }
        teacherIDtext.setEditable(false);
        teacherName.setEditable(false);
        teacherPhoneNumber.setEditable(false);
    }


}
