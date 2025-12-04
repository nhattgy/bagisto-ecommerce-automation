package utilities;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;

public class PDFHelper {

    public static String readPDF(String filePath) {
        try (PDDocument doc = PDDocument.load(new File(filePath))) {
            return new PDFTextStripper().getText(doc);
        } catch (Exception e) {
            throw new RuntimeException("Error reading PDF: " + e.getMessage());
        }
    }

    public static File getLatestFile(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();

        if (files == null || files.length == 0) return null;

        File newest = files[0];
        for (File f : files) {
            if (f.lastModified() > newest.lastModified()) newest = f;
        }
        return newest;
    }
}
