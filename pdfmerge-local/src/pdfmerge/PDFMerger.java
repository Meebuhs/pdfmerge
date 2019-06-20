package pdfmerge;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;

public class PDFMerger {
    public static boolean mergeFiles(List<File> files, File saveFile) {
        try {
            PDFMergerUtility merger = new PDFMergerUtility();
            List<PDDocument> documents = new ArrayList<>();

            for (File file : files) {
                PDDocument document = PDDocument.load(file);
                documents.add(document);
                merger.addSource(file);
            }

            merger.setDestinationFileName(saveFile.getAbsolutePath());
            merger.mergeDocuments(MemoryUsageSetting.setupTempFileOnly());

            for (PDDocument document : documents) {
                document.close();
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
