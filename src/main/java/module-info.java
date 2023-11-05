module com.example.spms {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.logging;
    requires java.sql;

    opens com.example.spms to javafx.fxml;
    exports com.example.spms;
    exports com.example.spms.Tables;
    opens com.example.spms.Tables to javafx.fxml;
}