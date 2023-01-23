package fhcw.teamarbeit.langtonsant;

import javafx.scene.paint.Paint;

/**
 * Die Klasse Ant repräsentiert die Ameise auf dem Feld/Grid.
 *
 * x,y speichern die Positionskoordinaten am Grid.
 *
 * steps speichert die maximale Anzahl an Schritten, die durchgeführt werden soll
 * der Wert -1 hierfür steht für unendlich (Input ist optional)
 *
 * mit count wird geprüft ob, der Wert in Steps erreicht wurde
 * (bei -1 eben nie, da count von 0 aufwärts zählt)
 *
 * Mit dem Enum Direction wird die Richtung gespeichert, in die die Ameise gerade guckt
 *  */
public class Ant {
    private enum Direction {
        NORTH, SOUTH, EAST, WEST
    }
    private int x;
    private int y;
    private Grid grid;

    private final int steps;
    private int count;

    private Direction direction;

    public Ant(int x, int y, Grid grid, int steps) {
        this.x = x;
        this.y = y;
        this.grid = grid;
        this.direction = Direction.WEST;
        this.steps = steps;
        this.count = 0;
    }

    public void move(){
        // Check ob max. Schritte erreicht wurden
        // wenn steps -1 ist, ist keine max. Anzahl an Schritten gesetzt und die Ameise läuft unendlich lang
        if(count == steps){
            return;
        }
        count++;

        // Feldwert holen und gleich darauf ändern
        boolean clockwise = grid.getGrid()[x][y].getClockwise();
        grid.getGrid()[x][y].setClockwise(!clockwise);

        if (clockwise){ // Ameise beweget sich im Uhrzeigersinn
            grid.getGrid()[x][y].setFill(Paint.valueOf("grey"));
            if(this.direction == Direction.NORTH){
                stepEast();
            } else if(this.direction == Direction.SOUTH){
                stepWest();
            } else if(this.direction == Direction.EAST){
                stepSouth();
            } else if(this.direction == Direction.WEST){
                stepNorth();
            }
        }
        else{ // Ameise beweget sich gegen Uhrzeigersinn
            grid.getGrid()[x][y].setFill(Paint.valueOf("white"));
            if(this.direction == Direction.NORTH){
                stepWest();
            } else if(this.direction == Direction.SOUTH){
                stepEast();
            } else if(this.direction == Direction.EAST){
                stepNorth();
            } else if(this.direction == Direction.WEST){
                stepSouth();
            }
        }

        // Ameise im Feld markieren
        grid.getGrid()[x][y].setFill(Paint.valueOf("red"));
    }

    private void stepNorth(){
        this.y--;
        this.y = keepInBorders(this.y);
        this.direction = Direction.NORTH;
    }

    private void stepSouth(){
        this.y++;
        this.y = keepInBorders(this.y);
        this.direction = Direction.SOUTH;
    }

    private void stepEast(){
        this.x++;
        this.x = keepInBorders(this.x);
        this.direction = Direction.EAST;
    }

    private void stepWest(){
        this.x--;
        this.x = keepInBorders(this.x);
        this.direction = Direction.WEST;
    }

    private int keepInBorders(int axis) {
        // Falls Ameise über Feldränder bewegt, auf gegenüber liegender Seite platzieren
        if(axis == this.grid.getDimension()){
            return 0;
        }else if(axis == -1){
            return this.grid.getDimension()-1;
        }
        return axis;
    }

}
