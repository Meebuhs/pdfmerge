package ui;

import javafx.geometry.Insets;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.FlowPane;

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
                        .filter(file -> file.getName().endsWith(".pdf"))
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
            FileIcon fileIcon = new FileIcon(file);
            flowPane.getChildren().add(fileIcon.getFileIcon());
        }
        app.addFiles(files);
    }

    public void clearFiles() {
        flowPane.getChildren().clear();
    }

    public FlowPane getFileDisplay() {
        return flowPane;
    }
}
