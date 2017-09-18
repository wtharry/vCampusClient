package seu.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seu.service.TeacherService;
/**
 * Created by Q on 2017/9/13.
 */


@Component
public class teacherInfoPaneController {
@Autowired TeacherService teacherService;

    @FXML
    private  TextField teacherIDtext;

    @FXML
    private TextField teacherName;

    @FXML
    private TextField teacherPhoneNumber;




    private int teacherID;
    private String password;

    public void setData(int teacherID,String password)

    {

        this.teacherID=teacherID;
        this.password=password;
        teacherIDtext.setText(String.valueOf(teacherID));
       teacherName.setText(teacherService.queryTeacherByTeacherId(teacherID).getTeacherName());
      teacherPhoneNumber.setText(String.valueOf(teacherService.queryTeacherByTeacherId(teacherID).getTeacherPhoneNumber()));
    }
}
