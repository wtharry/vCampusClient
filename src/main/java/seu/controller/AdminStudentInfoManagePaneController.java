package seu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import seu.service.StudentService;
import seu.service.ClassService;
import seu.domain.Student;

import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seu.domain.Student;
import seu.service.ClassService;
import seu.service.StudentService;

import java.io.IOException;

@Component

/**
 * Created by Q on 2017/9/18.
 */
public class AdminStudentInfoManagePaneController {
    @Autowired

    StudentService studentService=new StudentService();

    @Autowired

    ClassService classService=new ClassService();

    @FXML
    private TextField studentIDField;


    @FXML
    private TextField classIDField;

    @FXML
    private TextField dormitoryIDField;

    @FXML
    private TextField balanceField;

    @FXML
    private TextField classNameField;

    @FXML
    private TextField majorField;


    @FXML
    private TextField teacherField;


    @FXML
    private TextField classSizeField;

    @FXML
    private TextField nameField;



    @FXML
    private AnchorPane adminStudentInfoManage;

    @FXML
    private TextField passwordField;


    private String password;

    private int studentID;


    public void changeInfo(ActionEvent actionEvent) {
       //学号不可由学生更改
        nameField.setEditable(true);
        classIDField.setEditable(true);
        dormitoryIDField.setEditable(true);
        balanceField.setEditable(true);
        classIDField.setEditable(true);
        classNameField .setEditable(true);
        majorField.setEditable(true);
        classSizeField .setEditable(true);
        teacherField.setEditable(true);
        passwordField.setEditable(true);


    }



    public void checkInfo(ActionEvent actionEvent) {

        Student stu=new Student(Integer.valueOf(studentIDField.getText()),nameField.getText(),Integer.valueOf(classIDField.getText()),
        Integer.valueOf(dormitoryIDField.getText()),Integer.valueOf(balanceField.getText()), passwordField.getText());


        studentService.updateStudent(stu);


    }


    public void setData(int  id)
    {
        studentIDField.setText(String.valueOf(id));
        studentIDField.setEditable(false);

        studentID=id;



        nameField.setText(String.valueOf(studentService.queryStudentByStudentId(id).getStudentName()));
        nameField.setEditable(false);

        dormitoryIDField.setText(String.valueOf(studentService.queryStudentByStudentId(id).getDormitoryId()));
        dormitoryIDField.setEditable(false);

        balanceField.setText(String.valueOf(studentService.queryStudentByStudentId(id).getBalance()));
        balanceField.setEditable(false);

        passwordField.setText(studentService.queryStudentByStudentId(id).getPassword());
        passwordField.setEditable(false);


        classIDField.setText(String.valueOf(classService.queryClassByStudentId(id).getClassId()));
        classIDField.setEditable(false);

        classNameField.setText(classService.queryClassByStudentId(id).getClassName());
        classNameField .setEditable(false);

        majorField.setText(classService.queryClassByStudentId(id).getMajor());
        majorField.setEditable(false);

        classSizeField.setText(String.valueOf(classService.queryClassByStudentId(id).getClassSize()));
        classSizeField .setEditable(false);

        teacherField.setText(String.valueOf(classService.queryClassByStudentId(id).getTeacherId()));
        teacherField.setEditable(false);





    }


    public void returnPane(ActionEvent actionEvent) throws IOException {

        adminStudentInfoManage.getChildren().clear();
        Parent child = FXMLLoader.load(getClass().getResource("/view//StudentManage.fxml"));
        adminStudentInfoManage.getChildren().add(child);
    }
}
