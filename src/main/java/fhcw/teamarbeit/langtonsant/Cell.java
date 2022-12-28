package fhcw.teamarbeit.langtonsant;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Cell extends Rectangle {

    private static final int CELL_SIZE = 8;
    private final int x;
    private final int y;


    private boolean white;

    public Cell(int x, int y) {
        super(x + (x*CELL_SIZE), y, CELL_SIZE,CELL_SIZE);
        this.x = x;
        this.y = y;
        setWidth(CELL_SIZE);
        setHeight(CELL_SIZE);
        setX(x + (x * CELL_SIZE));
        setY(y + (y * CELL_SIZE));
        setFill(Paint.valueOf("lightblue"));
        this.white = true;
    }

    public int x() {

        return x;
    }

    public boolean getWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public int y() {
        return y;
    }

}