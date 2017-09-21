package seu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import seu.service.ClassService;

/**
 * Created by Q on 2017/9/13.
 */
public class classManageController {


    ClassService classService=new ClassService();

    @FXML
    private TextField classIDSearch;

    @FXML
    private Button findClass;

    @FXML
    private TextField classIDFound;

    @FXML
    private TextField classNameFound;

    @FXML
    private TextField majorFound;

    @FXML
    private TextField classSizeFound;

    @FXML
    private TextField teacherIDFound;

    public void findClass(ActionEvent actionEvent) {

        classIDFound.setText(String.valueOf(classService.queryClassByClassId(Integer.valueOf(classIDSearch.getText())).getClassId()));
        classNameFound.setText(classService.queryClassByClassId(Integer.valueOf(classIDSearch.getText())).getClassName());
        majorFound.setText(classService.queryClassByClassId(Integer.valueOf(classIDSearch.getText())).getMajor());
        classSizeFound.setText(String.valueOf(classService.queryClassByClassId(Integer.valueOf(classIDSearch.getText())).getClassSize()));
        teacherIDFound.setText(String.valueOf(classService.queryClassByClassId(Integer.valueOf(classIDSearch.getText())).getTeacherId()));
    }

    public void changeConfirm(ActionEvent actionEvent) {
    }

    public void delConfirm(ActionEvent actionEvent) {
    }

    public void addConfirm(ActionEvent actionEvent) {
    }
}
