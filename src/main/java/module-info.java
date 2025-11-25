module app {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.reflections;

    opens application to javafx.fxml;
    exports application;
}