package fhcw.teamarbeit.langtonsant;

import javafx.scene.paint.Paint;

public class Ant {

    private int x;
    private int y;
    private Grid grid;

    private Direction direction;

    public Ant(int x, int y, Grid grid) {
        this.x = x;
        this.y = y;
        this.grid = grid;
        this.direction = Direction.WEST;
    }

    public void move(){
        boolean white = grid.getGrid()[x][y].getWhite();
        grid.getGrid()[x][y].setWhite(!white);
        if (white){
            grid.getGrid()[x][y].setFill(Paint.valueOf("darkgrey"));
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
        else{
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
        grid.getGrid()[x][y].setFill(Paint.valueOf("red"));
    }

    private void stepNorth(){
        this.y--;
        this.direction = Direction.NORTH;
    }

    private void stepSouth(){
        this.y++;
        this.direction = Direction.SOUTH;
    }

    private void stepEast(){
        this.x++;
        this.direction = Direction.EAST;
    }

    private void stepWest(){
        this.x--;
        this.direction = Direction.WEST;
    }
}
