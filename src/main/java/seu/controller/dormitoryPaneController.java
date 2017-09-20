package seu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import seu.service.DormitoryService;

/**
 * Created by Q on 2017/9/11.
 */
public class dormitoryPaneController {

 DormitoryService dormitoryService =new DormitoryService();
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

        dormitoryID.setText(String.valueOf(dormitoryService.getDormitoryByStudentId(stuID).getDormitoryId()));
        dormitoryScore.setText(String.valueOf(dormitoryService.getDormitoryByStudentId(stuID).getScore()));
    }
}
