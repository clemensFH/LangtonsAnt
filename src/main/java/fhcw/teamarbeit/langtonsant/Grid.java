package fhcw.teamarbeit.langtonsant;

import javafx.scene.Group;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private Cell[][] grid;

    public Grid(Group group, int dimension) {
        this.grid = new Cell[dimension][dimension];
        List<Cell> cells = new ArrayList<>();
        for(int i=0; i<dimension; i++){
            for(int j=0; j<dimension; j++){
                cells.add(new Cell(i,j));
            }
        }
        cells.forEach(cell -> grid[cell.x()][cell.y()] = cell);
        group.getChildren().addAll(cells);
    }

    public Cell[][] getGrid() {
        return grid;
    }
}
