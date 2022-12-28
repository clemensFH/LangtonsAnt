package fhcw.teamarbeit.langtonsant;

import javafx.scene.Group;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private Cell[][] grid;
    private int dimension;

    public Grid(Group group, int dimension) {
        this.dimension = dimension;
        this.grid = new Cell[this.dimension][this.dimension];
        List<Cell> cells = new ArrayList<>();
        for(int i=0; i<this.dimension; i++){
            for(int j=0; j<this.dimension; j++){
                cells.add(new Cell(i,j));
            }
        }
        cells.forEach(cell -> grid[cell.x()][cell.y()] = cell);
        group.getChildren().addAll(cells);
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public int getDimension() {
        return dimension;
    }
}
