module org.example.tareaep2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;


    opens org.example.tareaep2.model to com.google.gson;
    opens org.example.tareaep2.controller to javafx.fxml;

    exports org.example.tareaep2;
}