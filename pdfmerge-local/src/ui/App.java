package ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import pdfmerge.PDFMerger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    private PDFMerger merger;
    private List<File> fileList;
    private FileDisplay fileDisplay;
    private Button mergeButton;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        merger = new PDFMerger();
        fileList = new ArrayList<>();
        fileDisplay = new FileDisplay(this);
        mergeButton = createMergeButton();

        BorderPane border = new BorderPane();
        border.setCenter(fileDisplay.getFileDisplay());
        border.setBottom(createToolBar(mergeButton));

        Scene scene = new Scene(border, 1280, 720);
        primaryStage.setTitle("PDFMerge");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createMergeButton() {
        Button button = new Button();
        button.setPrefSize(120, 55);
        button.setText("Merge");
        button.setDisable(true);
        button.setOnAction((ActionEvent event) -> mergeFiles());
        return button;
    }

    private ToolBar createToolBar(Button mergeButton) {
        ToolBar toolBar = new ToolBar();
        HBox hBox = new HBox();
        HBox.setHgrow(hBox, Priority.ALWAYS);
        toolBar.getItems().add(hBox);
        toolBar.getItems().add(mergeButton);
        toolBar.setStyle("-fx-background-color: #3c3c3c");

        return toolBar;
    }

    private void updateMergeButtonState() {
        if (!fileList.isEmpty()) {
            mergeButton.setDisable(false);
        } else {
            mergeButton.setDisable(true);
        }
    }

    public void addFiles(List<File> files) {
        fileList.addAll(files);
        updateMergeButtonState();
    }

    private void mergeFiles() {
        if (!fileList.isEmpty()) {
            if (merger.mergeFiles(fileList)) {
                fileList.clear();
                fileDisplay.clearFiles();
                updateMergeButtonState();
            }
        }
    }
}
