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
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class AntController implements Initializable {

    @FXML
    private BorderPane borderpane;

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

    private Ant ant;

    private boolean run;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int dimension = Integer.parseInt(txtfldDim.getText());
                int x = Integer.parseInt(txtfldX.getText());
                int y = Integer.parseInt(txtfldY.getText());
                grid = new Grid(cells, dimension);
                grid.getGrid()[x][y].setFill(Paint.valueOf("Black"));
                ant = new Ant(x,y,grid);
                run = true;
                /*while(run){
                    ant.move();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }*/
                //ant.move();
                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }*/
                //ant.move();
                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }*/
                //ant.move();
            }
        });

        btnReset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cells.getChildren().clear();
            }
        });

        btnStop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                grid.getGrid()[5][5].setFill(Paint.valueOf("red"));

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                grid.getGrid()[5][5].setFill(Paint.valueOf("yellow"));
            }
        });
    }
}