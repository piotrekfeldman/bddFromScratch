package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class dataDriven {

    public static void main(String[] args) throws IOException {

        //fileInputStream argument
        FileInputStream fs = new FileInputStream("C:\\Users\\piotr\\OneDrive\\Dokumenty\\XSSF\\demo.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fs);

        int sheetsize = workbook.getNumberOfSheets();

        for (int i = 0; i < sheetsize; i++) {

            if (workbook.getSheetName(i).equalsIgnoreCase("Arkusz1")) {
                XSSFSheet sheet = workbook.getSheetAt(i);

                Iterator<Row> rows = sheet.iterator();
                Row firstRow = rows.next();

                Iterator<Cell> cell = firstRow.cellIterator();
                int k = 0;
                int coloumn = 0;
                while (cell.hasNext()) {
                    Cell value = cell.next();
                    if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
                        coloumn = k;
                    }
                    k++;
                }
                System.out.println(coloumn);
            ArrayList ar=new ArrayList<>();
                while (rows.hasNext()) {
                    Row r = rows.next();
                    if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase("Purchase")) {
                        Iterator<Cell> cv = r.cellIterator();

                        while (cv.hasNext()) {
                            Cell c=cv.next();


                            if(c.getCellType()==CellType.STRING)
                            {
                                ar.add(c.getStringCellValue());
                            }
                                else
                            {
                                ar.add(NumberToTextConverter.toText((c.getNumericCellValue())));
                            }
                          //  String names = cv.next().getStringCellValue();
                          //  System.out.println(names);
                        }
                    }
                }

                System.out.println(ar);
            }

        }
    }
}
