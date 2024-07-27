package com.example.todo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;

public class HelloController {
    @FXML
    private Label Assistant;
    private ListView<Task> taskListView;
    private SplitPane splitPane;

    @FXML
    protected void onHelloButtonClick() {
        Assistant.setText("These are the things you need to do");
    }

    @FXML
    protected void onAddTaskClick(){
        Assistant.setText("Adding task");
    }
}