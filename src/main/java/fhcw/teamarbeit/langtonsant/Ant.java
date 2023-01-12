package fhcw.teamarbeit.langtonsant;

import javafx.scene.paint.Paint;

public class Ant {
  //hey ich bins

    private int x;
    private int y;
    private Grid grid;

    private int steps, count;

    private Direction direction;

    public Ant(int x, int y, Grid grid) {
        this.x = x;
        this.y = y;
        this.grid = grid;
        this.direction = Direction.WEST;
        this.steps = 10;
        this.count = 0;
    }

    public Ant(int x, int y, Grid grid, int steps) {
        this.x = x;
        this.y = y;
        this.grid = grid;
        this.direction = Direction.WEST;
        this.steps = steps;
        this.count = 0;
    }

    public void move(){
//        if(count == steps){
//            return;
//        }
//        count++;

        boolean white = grid.getGrid()[x][y].getWhite();
        grid.getGrid()[x][y].setWhite(!white);

        if (white){
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
        if(this.y == this.grid.getDimension()){
            this.y = 0;
        }else if(this.y == -1){
            this.y = this.grid.getDimension()-1;
        }
        this.direction = Direction.NORTH;
    }

    private void stepSouth(){
        this.y++;
        if(this.y == this.grid.getDimension()){
            this.y = 0;
        }else if(this.y == -1){
            this.y = this.grid.getDimension()-1;
        }
        this.direction = Direction.SOUTH;
    }

    private void stepEast(){
        this.x++;
        if(this.x == this.grid.getDimension()){
            this.x = 0;
        }else if(this.x == -1){
            this.x = this.grid.getDimension()-1;
        }
        this.direction = Direction.EAST;
    }

    private void stepWest(){
        this.x--;
        if(this.x == this.grid.getDimension()){
            this.x = 0;
        }else if(this.x == -1){
            this.x = this.grid.getDimension()-1;
        }
        this.direction = Direction.WEST;
    }

    private void checkIfBorderCrossed(int axis){
        if(axis == this.grid.getDimension()){
            axis = 0;
        }else if(axis == -1){
            axis = this.grid.getDimension()-1;
        }
    }
}
