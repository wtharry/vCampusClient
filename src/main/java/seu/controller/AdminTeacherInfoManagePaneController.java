package seu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import seu.service.TeacherService;

import java.io.IOException;




/**
 * Created by Q on 2017/9/18.
 */
public class AdminTeacherInfoManagePaneController {
    TeacherService teacherService=new TeacherService();

    @FXML
    private TextField teacherIDtext;

    @FXML
    private TextField teacherName;

    @FXML
    private TextField teacherPhoneNumber;

    @FXML
    private AnchorPane adminTeacherInfo;


    private int teacherID;


    public void setData(int teacherID)

    {

        this.teacherID=teacherID;

        teacherIDtext.setText(String.valueOf(teacherID));
       teacherName.setText(teacherService.queryTeacherByTeacherId(teacherID).getTeacherName());
             teacherPhoneNumber.setText(String.valueOf(teacherService.queryTeacherByTeacherId(teacherID).getTeacherPhoneNumber()));
    }

    public void returnAdmin(ActionEvent actionEvent) throws IOException {
        adminTeacherInfo.getChildren().clear();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/TeacherManage.fxml"));
        Parent child =loader.load();

        adminTeacherInfo.getChildren().add(child);
    }
}
