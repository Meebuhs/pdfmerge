package pdfmerge;

import java.io.File;
import java.util.List;

public class PDFMerger {
    public PDFMerger() {

    }

    public boolean mergeFiles(List<File> files) {
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }
        return true;
    }
}
