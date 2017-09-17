package seu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

/**
 * Created by Q on 2017/9/11.
 */
@Component
public class dormitoryPaneController {
    @FXML
   private TextField dormitoryID;


    @FXML
    private TextField dormitoryScore;

    private int studentID;

    public void getDormitoryID(ActionEvent actionEvent) {
    }

    public void getDormitoryScore(ActionEvent actionEvent) {
    }

    public void setInfo(int stuID)
    {
      //  DormitoryService dor=new Dormitory();
        //dormitoryID.setText(String.valueOf(dor.getDormitoryByStudentId().getDormitoryID()));
       // dormitoryID.setText(String.valueOf(dor.getDormitoryByStudentId().getScore()));
    }
}
