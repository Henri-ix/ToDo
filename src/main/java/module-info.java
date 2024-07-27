module com.example.todo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.desktop;

    opens com.example.todo to javafx.fxml;
    exports com.example.todo;
}