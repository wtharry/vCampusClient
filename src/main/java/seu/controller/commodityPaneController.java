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
import seu.service.ShopService;
import seu.service.StudentService;


/**
 * Created by Q on 2017/9/11.
 */
public class commodityPaneController {

    StudentService studentService=new StudentService();

    ShopService shopService=new ShopService();
    @FXML
    private TextField balance;

    @FXML
    private TextField totalBought;

    @FXML
    private TextField waterBoughtAmount;

    @FXML
    private TextField colaBoughtAmount;

    @FXML
    private TextField breadBoughtAmount;

    @FXML
    private TextField noodlesBoughtAmount;

    @FXML
    private TextField penBoughtAmount;

    @FXML
    private TextField noteBoughtAmount;
    @FXML
    private TextField coffeeBoughtAmount;

    @FXML
    private TextField snacksBoughtAmount;

    @FXML
    private TextField giftsBoughtAmount;

    private int studentID;

  public void setBalance(int stuID)
  {


   balance.setText(String.valueOf( studentService.queryStudentByStudentId(stuID).getBalance()));

  }

    public void subWater(ActionEvent actionEvent) {


      if( Integer.valueOf (waterBoughtAmount.getText())<1)
      {}
      else
      {
          waterBoughtAmount.setText(String.valueOf(Integer.valueOf (waterBoughtAmount.getText())-1));
          totalBought.setText(String.valueOf(Integer.valueOf ( totalBought.getText())-1));
      }

    }

    public void addWater(ActionEvent actionEvent) {



            waterBoughtAmount.setText(String.valueOf(Integer.valueOf (waterBoughtAmount.getText())+1));
            totalBought.setText(String.valueOf(Integer.valueOf ( totalBought.getText())+1));


    }


    public void subCola(ActionEvent actionEvent) {

        if( Integer.valueOf (colaBoughtAmount.getText())<1)
        {}
        else
        {
           colaBoughtAmount.setText(String.valueOf(Integer.valueOf (colaBoughtAmount.getText())-1));
            totalBought.setText(String.valueOf(Integer.valueOf ( totalBought.getText())-3));
        }
    }

    public void addCola(ActionEvent actionEvent) {
       colaBoughtAmount.setText(String.valueOf(Integer.valueOf (colaBoughtAmount.getText())+1));
       totalBought.setText(String.valueOf(Integer.valueOf ( totalBought.getText())+3));
    }


    public void subBread(ActionEvent actionEvent) {
        if( Integer.valueOf (breadBoughtAmount.getText())<1)
        {}
        else
        {
            breadBoughtAmount.setText(String.valueOf(Integer.valueOf (breadBoughtAmount.getText())-1));
            totalBought.setText(String.valueOf(Integer.valueOf ( totalBought.getText())-2));
        }
    }

    public void addBread(ActionEvent actionEvent) {
       breadBoughtAmount.setText(String.valueOf(Integer.valueOf (breadBoughtAmount.getText())+1));
        totalBought.setText(String.valueOf(Integer.valueOf ( totalBought.getText())+2));
    }



    public void subPen(ActionEvent actionEvent) {
        if( Integer.valueOf (penBoughtAmount.getText())<1)
        {}
        else
        {
            penBoughtAmount.setText(String.valueOf(Integer.valueOf (penBoughtAmount.getText())-1));
            totalBought.setText(String.valueOf(Integer.valueOf ( totalBought.getText())-10));
        }
    }

    public void addPen(ActionEvent actionEvent) {
        penBoughtAmount.setText(String.valueOf(Integer.valueOf (penBoughtAmount.getText())+1));
        totalBought.setText(String.valueOf(Integer.valueOf ( totalBought.getText())+10));
    }


    public void addNote(ActionEvent actionEvent) {
        noteBoughtAmount.setText(String.valueOf(Integer.valueOf (noteBoughtAmount.getText())+1));
        totalBought.setText(String.valueOf(Integer.valueOf ( totalBought.getText())+2));
    }
    public void subNote(ActionEvent actionEvent) {
        if( Integer.valueOf (noteBoughtAmount.getText())<1)
        {}
        else
        {
           noteBoughtAmount.setText(String.valueOf(Integer.valueOf (noteBoughtAmount.getText())-1));
            totalBought.setText(String.valueOf(Integer.valueOf ( totalBought.getText())-2));
        }
    }


    public void addGifts(ActionEvent actionEvent) {
       giftsBoughtAmount.setText(String.valueOf(Integer.valueOf (giftsBoughtAmount.getText())+1));
        totalBought.setText(String.valueOf(Integer.valueOf ( totalBought.getText())+2));
    }

    public void subGifts(ActionEvent actionEvent) {
        if( Integer.valueOf (giftsBoughtAmount.getText())<1)
        {}
        else
        {
            giftsBoughtAmount.setText(String.valueOf(Integer.valueOf (giftsBoughtAmount.getText())-1));
            totalBought.setText(String.valueOf(Integer.valueOf ( totalBought.getText())-2));
        }
    }


    public void addSnacks(ActionEvent actionEvent) {
       snacksBoughtAmount.setText(String.valueOf(Integer.valueOf (snacksBoughtAmount.getText())+1));
        totalBought.setText(String.valueOf(Integer.valueOf ( totalBought.getText())+3));
    }

    public void subSnacks(ActionEvent actionEvent) {
        if( Integer.valueOf (snacksBoughtAmount.getText())<1)
        {}
        else
        {
           snacksBoughtAmount.setText(String.valueOf(Integer.valueOf (snacksBoughtAmount.getText())-1));
            totalBought.setText(String.valueOf(Integer.valueOf ( totalBought.getText())-3));
        }
    }


    public void addCoffee(ActionEvent actionEvent) {
        coffeeBoughtAmount.setText(String.valueOf(Integer.valueOf (coffeeBoughtAmount.getText())+1));
        totalBought.setText(String.valueOf(Integer.valueOf ( totalBought.getText())+3));
    }

    public void subCoffee(ActionEvent actionEvent) {
        if( Integer.valueOf (coffeeBoughtAmount.getText())<1)
        {}
        else
        {
            coffeeBoughtAmount.setText(String.valueOf(Integer.valueOf (coffeeBoughtAmount.getText())-1));
            totalBought.setText(String.valueOf(Integer.valueOf ( totalBought.getText())-3));
        }
    }





    public void addNoodles(ActionEvent actionEvent) {
       noodlesBoughtAmount.setText(String.valueOf(Integer.valueOf (noodlesBoughtAmount.getText())+1));
        totalBought.setText(String.valueOf(Integer.valueOf ( totalBought.getText())+1));
    }

    public void subNoodles(ActionEvent actionEvent) {
        if( Integer.valueOf (noodlesBoughtAmount.getText())<1)
        {}
        else
        {
            noodlesBoughtAmount.setText(String.valueOf(Integer.valueOf (noodlesBoughtAmount.getText())-1));
            totalBought.setText(String.valueOf(Integer.valueOf ( totalBought.getText())-1));
        }
    }

    public int confirmBuy(ActionEvent actionEvent) {


        //-------------------------------------------------------------------------
        for (int q = 0; q < Integer.valueOf(waterBoughtAmount.getText()); q++) {
            if (shopService.purchase(this.studentID, 1) == 1) {
            }
            else {

                Stage window = new Stage();
                window.setTitle("提示");
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

                Label label = new Label("余额不足");

                VBox layout = new VBox(10);
                layout.getChildren().addAll(label, button);
                layout.setAlignment(Pos.CENTER);

                Scene scene = new Scene(layout);
                window.setScene(scene);
                //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
                window.showAndWait();
                return 0;
            }
        }

        // -------------------------------------------------------------------------
        for (int w = 0; w < Integer.valueOf(colaBoughtAmount.getText()); w++) {
            if (shopService.purchase(this.studentID, 02) == 1) {
            } else {

                Stage window = new Stage();
                window.setTitle("提示");
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

                Label label = new Label("余额不足");

                VBox layout = new VBox(10);
                layout.getChildren().addAll(label, button);
                layout.setAlignment(Pos.CENTER);

                Scene scene = new Scene(layout);
                window.setScene(scene);
                //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
                window.showAndWait();

                return 0;
            }
        }

        //------------------------------------------------------------------------
        for (int e = 0; e < Integer.valueOf(coffeeBoughtAmount.getText()); e++) {
            if (shopService.purchase(this.studentID, 03) == 1) {
            } else {

                Stage window = new Stage();
                window.setTitle("提示");
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

                Label label = new Label("余额不足");

                VBox layout = new VBox(10);
                layout.getChildren().addAll(label, button);
                layout.setAlignment(Pos.CENTER);

                Scene scene = new Scene(layout);
                window.setScene(scene);
                //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
                window.showAndWait();

                return 0;
            }
        }

        //------------------------------------------------------------------------
        for (int r = 0; r < Integer.valueOf(breadBoughtAmount.getText()); r++) {
            if (shopService.purchase(this.studentID, 04) == 1) {
            } else {

                Stage window = new Stage();
                window.setTitle("提示");
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

                Label label = new Label("余额不足");

                VBox layout = new VBox(10);
                layout.getChildren().addAll(label, button);
                layout.setAlignment(Pos.CENTER);

                Scene scene = new Scene(layout);
                window.setScene(scene);
                //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
                window.showAndWait();

                return 0;
            }
        }

        //------------------------------------------------------------------------
        for (int t = 0; t < Integer.valueOf(noodlesBoughtAmount.getText()); t++) {
            if (shopService.purchase(this.studentID, 05) == 1) {
            } else {

                Stage window = new Stage();
                window.setTitle("提示");
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

                Label label = new Label("余额不足");

                VBox layout = new VBox(10);
                layout.getChildren().addAll(label, button);
                layout.setAlignment(Pos.CENTER);

                Scene scene = new Scene(layout);
                window.setScene(scene);
                //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
                window.showAndWait();

                return 0;
            }
        }
        //------------------------------------------------------------------------
        for (int y = 0; y < Integer.valueOf(snacksBoughtAmount.getText()); y++) {
            if (shopService.purchase(this.studentID, 06) == 1) {
            } else {

                Stage window = new Stage();
                window.setTitle("提示");
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

                Label label = new Label("余额不足");

                VBox layout = new VBox(10);
                layout.getChildren().addAll(label, button);
                layout.setAlignment(Pos.CENTER);

                Scene scene = new Scene(layout);
                window.setScene(scene);
                //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
                window.showAndWait();

                return 0;
            }
        }

        //------------------------------------------------------------------------
        for (int u = 0; u < Integer.valueOf(penBoughtAmount.getText()); u++) {
            if (shopService.purchase(this.studentID, 07) == 1) {
            } else {

                Stage window = new Stage();
                window.setTitle("提示");
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

                Label label = new Label("余额不足");

                VBox layout = new VBox(10);
                layout.getChildren().addAll(label, button);
                layout.setAlignment(Pos.CENTER);

                Scene scene = new Scene(layout);
                window.setScene(scene);
                //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
                window.showAndWait();

                return 0;
            }
        }


        //------------------------------------------------------------------------
        for (int o = 0; o < Integer.valueOf(noteBoughtAmount.getText()); o++) {
            if (shopService.purchase(this.studentID, 8) == 1) {
            } else {

                Stage window = new Stage();
                window.setTitle("提示");
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

                Label label = new Label("余额不足");

                VBox layout = new VBox(10);
                layout.getChildren().addAll(label, button);
                layout.setAlignment(Pos.CENTER);

                Scene scene = new Scene(layout);
                window.setScene(scene);
                //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
                window.showAndWait();

                return 0;
            }
        }


        //------------------------------------------------------------------------
        for (int p = 0; p < Integer.valueOf(giftsBoughtAmount.getText()); p++) {
            if (shopService.purchase(this.studentID, 9) == 1) {
            } else {

                Stage window = new Stage();
                window.setTitle("提示");
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

                Label label = new Label("余额不足");

                VBox layout = new VBox(10);
                layout.getChildren().addAll(label, button);
                layout.setAlignment(Pos.CENTER);

                Scene scene = new Scene(layout);
                window.setScene(scene);
                //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
                window.showAndWait();

                return 0;
            }
        }
        balance.setText(String.valueOf(studentService.queryStudentByStudentId(this.studentID).getBalance()));
        Stage window = new Stage();
        window.setTitle("提示");
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

        Label label = new Label("购买成功");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();
        return 0;
    }







    public void getStudentID(int id)
    {
        this.studentID=id;
    }


}
