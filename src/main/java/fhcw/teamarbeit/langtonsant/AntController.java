package fhcw.teamarbeit.langtonsant;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

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

    private Timeline timeline;

    private boolean run;



    @Override
    public void initialize(URL location, ResourceBundle resources) {


//        btnStart.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                int dimension = Integer.parseInt(txtfldDim.getText());
//                int x = Integer.parseInt(txtfldX.getText());
//                int y = Integer.parseInt(txtfldY.getText());
//                grid = new Grid(cells, dimension);
//                grid.getGrid()[x][y].setFill(Paint.valueOf("Black"));
//                ant = new Ant(x,y,grid);
//                run = true;
//                /*while(run){
//                    ant.move();
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }*/
//                //ant.move();
//                /*try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }*/
//                //ant.move();
//                /*try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }*/
//                //ant.move();
//            }
//        });

        btnReset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cells.getChildren().clear();
            }
        });

        btnStop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               timeline.stop();
            }
        });
    }

    public void startAnt(){
        int dimension = Integer.parseInt(txtfldDim.getText());
        int x = Integer.parseInt(txtfldX.getText());
        int y = Integer.parseInt(txtfldY.getText());
        grid = new Grid(cells, dimension);
        grid.getGrid()[x][y].setFill(Paint.valueOf("red"));
        ant = new Ant(x,y,grid);
        timeline = new Timeline();
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), this::tick));
        timeline.setOnFinished(event -> txtfldDim.setText("Start"));
        timeline.play();
        //timeline.rateProperty().bind(fps.valueProperty());
    }

    private void tick(ActionEvent actionEvent) {
        ant.move();
    }
}