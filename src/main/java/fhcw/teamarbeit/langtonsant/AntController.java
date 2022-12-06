package fhcw.teamarbeit.langtonsant;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ResourceBundle;

public class AntController implements Initializable {


    @FXML
    private Button btnReset;

    @FXML
    private Button btnStart;

    @FXML
    private Button btnStop;

    @FXML
    private Group cells;

    @FXML
    private Slider sliderSpeed;

    @FXML
    private TextField txtfldDim;

    @FXML
    private TextField txtfldX;

    @FXML
    private TextField txtfldY;

    @FXML
    private TextField txtfldSteps;

    private Grid grid;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                cells.getChildren().removeAll();
                grid = null;
                int dimension = Integer.parseInt(txtfldDim.getText());
                int x = Integer.parseInt(txtfldX.getText());
                int y = Integer.parseInt(txtfldY.getText());
                grid = new Grid(cells, dimension);
                grid.getGrid()[x][y].setFill(Paint.valueOf("Black"));
            }
        });
    }
}