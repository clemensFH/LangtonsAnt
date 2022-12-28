package fhcw.teamarbeit.langtonsant;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class AntController implements Initializable {

    @FXML
    private BorderPane borderpane;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnStart;

    @FXML
    private Group cells;

    @FXML
    private Slider speed;

    @FXML
    private TextField txtfldDim;

    @FXML
    private TextField txtfldX;

    @FXML
    private TextField txtfldY;

    @FXML
    private TextField txtfldSteps;

    @FXML
    private Hyperlink link;

    private Grid grid;

    private Ant ant;

    private Timeline timeline;

    private boolean run;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        link.setOnAction(event -> {

        });

        btnReset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(btnReset.getText().equals("Reset")) {
                    btnReset.setText("Create");
                    cells.getChildren().clear();
                }else if(btnReset.getText().equals("Create")){
                    btnReset.setText("Reset");
                    int dimension = Integer.parseInt(txtfldDim.getText());
                    int x = Integer.parseInt(txtfldX.getText());
                    int y = Integer.parseInt(txtfldY.getText());
                    grid = new Grid(cells, dimension);
                    if(inDimension(x) && inDimension(y)){
                        grid.getGrid()[x][y].setFill(Paint.valueOf("red"));
                        ant = new Ant(x,y,grid);
                    }
                }
            }
        });

    }

    public void startAnt(){
        if(cells.getChildren().isEmpty()) {
            return;
        }

        if (btnStart.getText().equals("Start")) {
            btnStart.setText("Stop");
            timeline = new Timeline();
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), this::tick));
            timeline.rateProperty().bind(speed.valueProperty());
            timeline.setOnFinished(ev -> txtfldDim.setText("Start"));
            timeline.play();
        } else if (btnStart.getText().equals("Stop")) {
            btnStart.setText("Start");
            timeline.stop();
        }
    }

    private void tick(ActionEvent actionEvent) {
        ant.move();
    }

    private boolean inDimension(int z){
        if(z < 0 || z >= this.grid.getDimension()){
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Ungültige Eingabe");
            errorAlert.setContentText("Startkoordinaten müssen innerhalb der Dimension sein!" + System.lineSeparator()
                                        + "0 - " + (this.grid.getDimension()-1));
            errorAlert.showAndWait();
            return false;
        }
        return true;
    }
}