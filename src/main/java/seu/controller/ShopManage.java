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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import seu.domain.Commodity;
import seu.service.ShopService;

@Component
public class ShopManage {
    @Autowired
    ShopService shopservice=new ShopService();

    @FXML
    private TextField commodityIDSearch;

    @FXML
    private TextField commodityID;

    @FXML
    private  TextField commodityName;

    @FXML
    private  TextField commodityPrize;

    @FXML
    private  TextField commodityInventory;

    public void changeInfo(ActionEvent actionEvent) {

        commodityID.setEditable(true);
        commodityName.setEditable(true);
        commodityPrize.setEditable(true);
        commodityInventory.setEditable(true);

    }

    public void confirm(ActionEvent actionEvent) {
        Commodity commodity=new Commodity(Integer.valueOf(commodityID.getText()),commodityName.getText(),
                Integer.valueOf(commodityPrize.getText()),Integer.valueOf(commodityInventory.getText()));
       shopservice.updateCommodity(commodity);

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

        Label label = new Label("修改成功");

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label , button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        //使用showAndWait()先处理这个窗口，而如果不处理，main中的那个窗口不能响应
        window.showAndWait();
    }

    public void find(ActionEvent actionEvent) {

        commodityID.setText(String.valueOf(shopservice.getCommodityById(Integer.valueOf(commodityIDSearch.getText())).getCommodityId()));
        commodityName.setText( shopservice.getCommodityById(Integer.valueOf(commodityIDSearch.getText())).getCommodityName());
        commodityPrize.setText( String.valueOf(shopservice.getCommodityById(Integer.valueOf(commodityIDSearch.getText())).getPrize()));
        commodityInventory.setText(String.valueOf(shopservice.getCommodityById(Integer.valueOf(commodityIDSearch.getText())).getInventory()));
        commodityID.setEditable(false);
        commodityName.setEditable(false);
        commodityPrize.setEditable(false);
        commodityInventory.setEditable(false);


    }
}
