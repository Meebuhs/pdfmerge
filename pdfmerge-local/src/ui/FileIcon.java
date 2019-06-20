package ui;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.File;

public class FileIcon extends VBox {
    private File file;
    private VBox vBox;

    public FileIcon(File file) {
        this.file = file;
        this.vBox = createVBox();
    }

    public VBox getFileIcon() {
        return vBox;
    }

    private VBox createVBox() {
        Image image = createImage();
        ImageView imageView = createImageView(image);
        Label label = createLabel();

        VBox vBox = new VBox();
        vBox.getChildren().add(imageView);
        vBox.getChildren().add(label);

        return vBox;
    }

    private Image createImage() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        // Assume the resource can always be loaded
        return new Image(classLoader.getResourceAsStream("pdf-icon.png"));
    }

    private ImageView createImageView(Image image) {
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
        imageView.setPickOnBounds(true);
        imageView.setOpacity(0.9);

        return imageView;
    }

    private Label createLabel() {
        Label label = new Label(file.getName());
        label.setStyle("-fx-text-fill: #b8b8b8; -fx-font-size: 1.5em");
        label.setMaxSize(120, 50);
        label.setWrapText(true);

        return label;
    }
}