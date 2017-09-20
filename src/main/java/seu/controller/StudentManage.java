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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seu.domain.Student;
import seu.service.StudentService;

import java.io.IOException;

@Component
public class StudentManage {
    @Autowired
    StudentService studentService=new StudentService();

    @FXML
    private AnchorPane studentManage;

    @FXML
    private TextField studengIDSeearch;

    @FXML
    private TextField studentIDDel;

    @FXML
    private TextField classIDAdd;

    @FXML
    private TextField studengIDAdd;

    @FXML
    private TextField studentNameAdd;

    @FXML
    private TextField dormitoryAdd;

    @FXML
    private TextField addPassword;

    @FXML
    private Button studengtFind;

    @FXML
    private Button studentDel;

    @FXML
    private TextField balanceAdd;

    public void addStudent(ActionEvent actionEvent) {
        Student stu=new Student(Integer.valueOf(studengIDAdd.getText()),studentNameAdd.getText(),Integer.valueOf(classIDAdd.getText()),
                Integer.valueOf(dormitoryAdd.getText()),  Integer.valueOf(balanceAdd.getText()),addPassword.getText() );
        studentService.insertStudent(stu);
System.out.print(stu.getBalance());
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

    public void searchStudent(ActionEvent actionEvent) throws IOException {

        studentManage.getChildren().clear();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/view//adminStudentInfoManagePane.fxml"));
        Parent child =loader.load();
        AdminStudentInfoManagePaneController adminStu =loader.< AdminStudentInfoManagePaneController>getController();
        adminStu.setData(Integer.valueOf(studengIDSeearch.getText()));
        studentManage.getChildren().add(child);
    }

    public void delStudent(ActionEvent actionEvent) {

        studentService.deleteStudent(Integer.valueOf(studentIDDel.getText()));
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


}
