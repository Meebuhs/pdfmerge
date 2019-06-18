package ui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class FileDisplay {
    private App app;
    private FlowPane flowPane;

    public FileDisplay(App app) {
        this.app = app;
        this.flowPane = createFlowPane();
    }

    private FlowPane createFlowPane() {
        FlowPane flow = new FlowPane();
        flow.setHgap(20);
        flow.setVgap(20);
        flow.setPadding(new Insets(40, 20, 40, 20));
        flow.setStyle("-fx-background-color: #3c3c3c");

        flow.setOnDragOver(event -> {
            if (event.getGestureSource() != flow && event.getDragboard().hasFiles()) {
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            event.consume();
        });

        flow.setOnDragDropped(event -> {
            boolean success = false;
            if (event.getGestureSource() != flow && event.getDragboard().hasFiles()) {
                List<File> pdfs = event.getDragboard().getFiles().stream()
                        .filter(file -> getExtension(file.getName()).equals("pdf"))
                        .collect(Collectors.toList());
                if (!pdfs.isEmpty()) {
                    addFiles(pdfs);
                    success = true;
                }
            }
            event.setDropCompleted(success);
            event.consume();
        });

        return flow;
    }

    private void addFiles(List<File> files) {
        for (File file : files) {
            VBox vBox = new VBox();

            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            Image image = new Image(classLoader.getResourceAsStream("pdf-icon.png"));
            ImageView iv = new ImageView();
            iv.setImage(image);
            iv.setPreserveRatio(true);
            iv.setSmooth(true);
            iv.setCache(true);
            iv.setPickOnBounds(true);
            iv.setOpacity(0.9);

            vBox.getChildren().add(iv);
            Label label = new Label(file.getName());
            label.setStyle("-fx-text-fill: #b8b8b8; -fx-font-size: 1.5em");
            label.setMaxSize(120, 50);
            label.setWrapText(true);

            vBox.getChildren().add(label);

            flowPane.getChildren().add(vBox);
        }
        app.addFiles(files);
    }

    public void clearFiles() {
        flowPane.getChildren().clear();
    }

    public FlowPane getFileDisplay() {
        return flowPane;
    }

    private String getExtension(String fileName){
        String extension = "";

        int i = fileName.lastIndexOf('.');
        if (i > 0 && i < fileName.length() - 1) {
            return fileName.substring(i + 1).toLowerCase();
        }

        return extension;
    }
}
