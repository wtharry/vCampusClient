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
import seu.domain.Library;
import seu.service.LibraryService;

import java.util.Date;

public class LibraryManage {
    @FXML
    private TextField bookIDAdd;

    @FXML
    private TextField bookNameAdd;

    @FXML
    private TextField bookIDDel;

    LibraryService libraryService=new LibraryService();


    @FXML
    private TextField bookID;

    @FXML
    private TextField bookName;

    @FXML
    private TextField studentID;

    @FXML
    private TextField startDate;



    public void confirm(ActionEvent actionEvent) {
        Date startdate=new Date(startDate.getText());

        Library library=new Library(Integer.valueOf(bookID.getText()),bookName.getText(),Integer.valueOf(studentID.getText()),startdate);
       if(libraryService.updateBook(library)==1)

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
                   ((Node) (event.getSource())).getScene().getWindow().hide();
               }

           });

           Label label = new Label("修改成功");

           VBox layout = new VBox(10);
           layout.getChildren().addAll(label, button);
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

           Label label = new Label("修改失败");

           VBox layout = new VBox(10);
           layout.getChildren().addAll(label , button);
           layout.setAlignment(Pos.CENTER);

           Scene scene = new Scene(layout);
           window.setScene(scene);
           //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
           window.showAndWait();
       }
    }

    public void addConfirm(ActionEvent actionEvent) {
        if(libraryService.insertBook(Integer.valueOf(bookIDAdd.getText()),bookNameAdd.getText())==1)
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

            Label label = new Label("添加成功");

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

            Label label = new Label("添加失败");

            VBox layout = new VBox(10);
            layout.getChildren().addAll(label , button);
            layout.setAlignment(Pos.CENTER);

            Scene scene = new Scene(layout);
            window.setScene(scene);
            //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
            window.showAndWait();
        }
    }

    public void delConfirm(ActionEvent actionEvent) {
       if( libraryService.deleteBook(Integer.valueOf(bookIDAdd.getText()))==1)
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

           Label label = new Label("删除成功");

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

           Label label = new Label("删除失败");

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
