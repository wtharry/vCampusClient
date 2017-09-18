package seu.controller;

/**
 * Created by Q on 2017/9/9.
 */


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import seu.controller.studentController;
import seu.service.AdminService;
import seu.service.StudentService;
import seu.service.TeacherService;
//import seu.service.StudentService;



@Component
public class MyController implements Initializable
    {
        @Autowired
        StudentService studentService;

        @Autowired
        TeacherService  teacherService;

        @Autowired
        AdminService  adminService;

        @FXML
        private Button signIn;
        @FXML
        private Button signOut;

        @FXML
        private TextField password;
        @FXML
        private TextField accountNumber;

        @FXML
        private RadioButton student;
        @FXML
        private RadioButton admin;
        @FXML
        private RadioButton teacher;

        private ToggleGroup group= new ToggleGroup();


        @Override
        public void initialize(URL location, ResourceBundle resources) {

            // TODO (don't really need to do anything here).
            student.setToggleGroup(group);
            student.setSelected(true);
            teacher.setToggleGroup(group);
            admin.setToggleGroup(group);
        }



        public void signIn(Event event ) {


            if (group.getSelectedToggle() == student) {


                int stuID=Integer.valueOf(accountNumber.getText()).intValue();
                if(studentService.login( stuID,password.getText())==1)
                {

                ((Node) (event.getSource())).getScene().getWindow().hide();
                System.out.println("Button Clicked!");
                System.out.println("student");
                try {
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("/view//studentScene.fxml"));
                    Parent target = (Parent) loader.load();

                  studentController stu =loader.<studentController>getController();
                  stu.getData(Integer.valueOf(accountNumber.getText()),password.getText());
                    //载入窗口B的定义文件；<span style="white-space:pre"> </span>
                    Scene scene = new Scene(target); //创建场景；
                    Stage stg = new Stage();//创建舞台；
                    stg.setTitle("学生服务界面");
                    stg.setScene(scene); //将场景载入舞台；


                    scene.getStylesheets().add(
                            getClass().getResource("/view//Student.css")
                                    .toExternalForm());
                    stg.setResizable(false);
                    stg.show(); //显示窗口；


                } catch (Exception e) {
                    e.printStackTrace();
                }


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

                    Label label = new Label("账号或密码错误");

                    VBox layout = new VBox(10);
                    layout.getChildren().addAll(label , button);
                    layout.setAlignment(Pos.CENTER);

                    Scene scene = new Scene(layout);
                    window.setScene(scene);
                    //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
                    window.showAndWait();
                }
            }


                    if(group.getSelectedToggle()==teacher)
                    {


                         int TeacherID=Integer.valueOf(accountNumber.getText()).intValue();
                        if(teacherService.login( TeacherID,password.getText())==1)
                        {

                        ((Node)(event.getSource())).getScene().getWindow().hide();
                        System.out.println("teacher");
                        try {

                            FXMLLoader loader=new FXMLLoader(getClass().getResource("/view//teacherScene.fxml"));
                            Parent target = (Parent) loader.load();
                            teacherSceneController tea =loader.< teacherSceneController>getController();
                            tea.setData(Integer.valueOf(accountNumber.getText()).intValue(),password.getText());
                            Scene scene = new Scene(target); //创建场景；
                            Stage stg = new Stage();//创建舞台；
                            stg.setTitle("教师服务界面");
                            stg.setScene(scene); //将场景载入舞台；
                            scene.getStylesheets().add(
                                    getClass().getResource("/view//Teacher.css")
                                            .toExternalForm());
                            stg.setResizable(false);
                            stg.show(); //显示窗口；
                        }

                        catch(Exception e) {
                            e.printStackTrace();
                        }

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

                    Label label = new Label("账号或密码错误");

                    VBox layout = new VBox(10);
                    layout.getChildren().addAll(label , button);
                    layout.setAlignment(Pos.CENTER);

                    Scene scene = new Scene(layout);
                    window.setScene(scene);
                    //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
                    window.showAndWait();
                }
                    }

                    if(group.getSelectedToggle()==admin)
                    {


                         int AdminID=Integer.valueOf(accountNumber.getText()).intValue();
                        if(adminService.login( AdminID,password.getText())==1)
                        {
                        ((Node)(event.getSource())).getScene().getWindow().hide();
                        System.out.println("admin");
                        try {

                            FXMLLoader loader=new FXMLLoader(getClass().getResource("/view//admin.fxml"));
                            Parent target = (Parent) loader.load();

                            AdminController adm =loader.<    AdminController>getController();
                            adm.setData(Integer.valueOf(accountNumber.getText()).intValue(),password.getText());

                            Scene scene = new Scene(target); //创建场景；
                            Stage stg = new Stage();//创建舞台；
                            scene.getStylesheets().add(
                                    getClass().getResource("/view//Teacher.css")
                                            .toExternalForm());
                            stg.setTitle("管理员管理界面");
                            stg.setScene(scene); //将场景载入舞台；
                            stg.setResizable(false);
                            stg.show(); //显示窗口；
                        }

                        catch(Exception e) {
                            e.printStackTrace();
                        }

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

                    Label label = new Label("账号或密码错误");

                    VBox layout = new VBox(10);
                    layout.getChildren().addAll(label , button);
                    layout.setAlignment(Pos.CENTER);

                    Scene scene = new Scene(layout);
                    window.setScene(scene);
                    //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
                    window.showAndWait();
                }
                    }

        }

        public void signOut(ActionEvent event )
        {
            System.out.println("Button Clicked!");
            System.exit(0);
        }


        public void accountNumber()
        {

        }

        public void password()
        {

        }

        public int getID()
        {

            return Integer.valueOf(accountNumber.getText()).intValue();
        }

    }

