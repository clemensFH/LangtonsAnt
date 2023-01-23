package fhcw.teamarbeit.langtonsant;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * Cell stellt ein Feld im Raster(Grid) dar, auf welchem sich die Ant bewegt
 * Die Klasse erbt von javafx.scene.shape.Rectangle und wird erweitert um 4 Zusatzvariablen
 *
 * x,y speichern die Koordinaten der Cell im Grid
 *
 * clockwise gibt der Ameise ihr Verhalten vor - Bewegung gegen/im Uhrzeigersinn
 */
public class Cell extends Rectangle {

    private static final int CELL_SIZE = 8;
    private final int x;
    private final int y;

    private boolean clockwise;

    public Cell(int x, int y) {
        super(x + (x*CELL_SIZE), y, CELL_SIZE,CELL_SIZE);
        this.x = x;
        this.y = y;
        setWidth(CELL_SIZE);
        setHeight(CELL_SIZE);
        setX(x + (x * CELL_SIZE));
        setY(y + (y * CELL_SIZE));
        setFill(Paint.valueOf("lightblue"));
        this.clockwise = true;
    }

    public int x() {return x;}

    public boolean getClockwise() {
        return clockwise;
    }

    public void setClockwise(boolean clockwise) {
        this.clockwise = clockwise;
    }

    public int y() {
        return y;
    }

}