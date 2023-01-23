package fhcw.teamarbeit.langtonsant;

import javafx.scene.Group;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private Cell[][] grid;
    private int dimension;

    /** Der Hauptkonstruktor für das Objekt Grid. Übergeben werden zwei Parametern: Gruppe und die Höhe#Breite,
     *  also Dimension von dem Grid */

    public Grid(Group group, int dimension) {
        this.dimension = dimension;
        this.grid = new Cell[this.dimension][this.dimension];

        // Zu jedem Feld im Grid wird eine Cell erstellt an den entsprechenden Koordinaten
        // Die Cells werden auch der Group hinzugefügt, um sie im GUI anzuzeigen
        for(int i=0; i<this.dimension; i++){
            for(int j=0; j<this.dimension; j++){
                Cell current = new Cell(i,j);
                grid[current.x()][current.y()] = current;
                group.getChildren().add(current);
            }
        }
    }

    /* Getters */
    public Cell[][] getGrid() {
        return grid;
    }

    public int getDimension() {
        return dimension;
    }
}
