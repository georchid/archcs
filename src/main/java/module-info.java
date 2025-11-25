module app {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.reflections;

    opens app to javafx.fxml;
    exports app;
}