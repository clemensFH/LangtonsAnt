module fhcw.teamarbeit.langtonsant {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires java.desktop;


    opens fhcw.teamarbeit.langtonsant to javafx.fxml;
    exports fhcw.teamarbeit.langtonsant;
}