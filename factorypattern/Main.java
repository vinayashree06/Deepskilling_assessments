//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DocumentFactory wordF = new WordDocumentFactory();
        Document word = wordF.createDocument();
        word.open();

        DocumentFactory pdfF = new PdfDocumentFactory();
        Document pdf = pdfF.createDocument();
        pdf.open();

        DocumentFactory excelF = new ExcelDocumentFactory();
        Document excel = excelF.createDocument();
        excel.open();
        }
    }
