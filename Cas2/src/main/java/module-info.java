module com.example.seance6cas2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.seance6cas2 to javafx.fxml, javafx.graphics;

}