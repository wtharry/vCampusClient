package seu.controller;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
//import seu.service.StudentService;
//import seu.service.ClassService;
//import seu.domain.Student;

import org.springframework.stereotype.Component;

@Component

public class schoolrollPaneController {
    @FXML
    private  TextField studentIDField;


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
    private PasswordField oldPassword;

    @FXML
    private PasswordField newPassword;

    @FXML
    private PasswordField newPasswordConfirm;


    private String password;

    private int ID;


    public void changeInfo(ActionEvent actionEvent) {
        //学号不可由学生更改
        /*nameField.setEditable(true);
        classIDField.setEditable(true);
        dormitoryIDField.setEditable(true);
        balanceField.setEditable(true);
        classIDField.setEditable(true);
        classNameField .setEditable(true);
        majorField.setEditable(true);
        classSizeField .setEditable(true);
        teacherField.setEditable(true);*/

    }

    public void changePassword(ActionEvent actionEvent) {
        /*
        oldPassword.setEditable(true);
        newPassword.setEditable(true);
        newPasswordConfirm.setEditable(true);
        */
    }

    public void checkInfo(ActionEvent actionEvent) {

        /*
        Student stu(Integer.valueOf(studentIDField.getText()),nameField.getText(),Integer.valueOf(classIDField.getText()),
        Integer.valueOf(dormitoryIDField.getText()),Integer.valueOf(balanceField.getText()),this.password);
        StudentService stus;
        stus.updateStudent(stu);

         */
    }

    public void passwordChecked(ActionEvent actionEvent) {
        //StudentService Stu;
        //
        //if(Stu.login( ID,oldPassword.getText()&&newPassword.getText()==newPasswordConfirm.getText())
        //{
       //    Stu.updateStudentPassword(ID,newPassword.getText());
        // }


    }

    public void setData(int  id,String pw)
    {
        studentIDField.setText(String.valueOf(id));
        studentIDField.setEditable(false);
        password=pw;
        ID=id;

        /* StudentService stu;
         nameField.setText(stu.queryStudentByStudentId(id).getStudentName());
         nameField.setEditable(false);

        classIDField.setText(String.valueOf(stu.queryStudentByStudentId(id).getClassID()));
        classIDField.setEditable(false);

        dormitoryIDField.setText(String.valueOf(stu.queryStudentByStudentId(id).getDormitoryID()));
        dormitoryIDField.setEditable(false);

        balanceField.setText(String.valueOf(stu.queryStudentByStudentId(id).getBalance()));
        balanceField.setEditable(false);

        ClassService cla;

        classIDField.setText(String.valueOf(cla.queryClassByStudentId(id).getClassId()));
        classIDField.setEditable(false);

        classNameField.setText(cla.queryClassByStudentId(id).getClassName());
        classNameField .setEditable(false);

        majorField.setText(cla.queryClassByStudentId(id).getMajor());
        majorField.setEditable(false);

        classSizeField.setText(String.valueOf(cla.queryClassByStudentId(id).getClassSize()));
        classSizeField .setEditable(false);

        teacherField.setText(String.valueOf(cla.queryClassByStudentId(id).getTeacherID()));
        teacherField.setEditable(false);

        oldPassword.setEditable(false);
        newPassword.setEditable(false);
        newPasswordConfirm.setEditable(false);
                */


    }


}
