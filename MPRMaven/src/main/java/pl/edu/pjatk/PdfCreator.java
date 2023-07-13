package pl.edu.pjatk;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import javax.imageio.IIOException;
import java.io.IOException;

public class PdfCreator {
    public static void main(String[] args) throws IOException {
        PDDocument doc = new PDDocument();
        for (int i = 1; i <= 10; i++) {
        PDPage page = new PDPage();
        PDPageContentStream stream = new PDPageContentStream(doc, page);
        stream.beginText();
        stream.newLineAtOffset(200, 500);
        stream.setFont(PDType1Font.COURIER, 20);
            if (i == 1) {
                stream.showText("Hello world!!!");
            }
            if( i == 10){
                stream.showText("Hello world!!!");
            }
            stream.newLineAtOffset(380, -450);
            stream.showText(Integer.toString(i));
            stream.endText();
            stream.close();
            doc.addPage(page);
        }
        doc.save("MyPDF.pdf");
        doc.close();
    }
}
