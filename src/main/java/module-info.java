module fhcw.teamarbeit.langtonsant {
    requires javafx.controls;
    requires javafx.fxml;


    opens fhcw.teamarbeit.langtonsant to javafx.fxml;
    exports fhcw.teamarbeit.langtonsant;
}