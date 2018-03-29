package excel;
import java.io.File;
import analyzer.AnnotationProcessor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Class to write data to an Excel file.
 */
public class ExcelWriter {

    /**
     * Writes data to a separate sheet in an Excel file.
     * @param name - name of sheet. (Our filler).
     * @param data - data that will be written in a sheet.
     *             String - name of sorter, Long - time of sorting.
     */
    public static void sheetWriter(String name, Map<String,List<Long>> data) {
        FileInputStream fileInputStream;
        XSSFWorkbook workbook;
        try {
            File file = new File("File.xlsx");
            if (!file.exists()) {
                file.createNewFile();
            }
            fileInputStream = new FileInputStream(file);
            workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet spreadsheet;
            if ((spreadsheet = workbook.getSheet(name)) == null) {
                spreadsheet = workbook.createSheet(name);
            }
            int rowId = 0;
            rowWriter(spreadsheet, rowId++, AnnotationProcessor.MAX_ARRAY, data.get(AnnotationProcessor.MAX_ARRAY));
            Set<String> keySet = data.keySet();
            keySet.remove(AnnotationProcessor.MAX_ARRAY);
            for (String key : keySet) {
                rowWriter(spreadsheet, rowId++, key, data.get(key));
            }
            fileInputStream.close();
            FileOutputStream out = new FileOutputStream(new File("File.xlsx"));
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Writes one line to the sheet.
     * @param sheet - sheet where data is recorded.
     * @param rowId - line number where data is recorded.
     * @param rowName - name row.
     * @param data - List of hours of work of the sorter.
     */
    private static void rowWriter(XSSFSheet sheet, int rowId, String rowName, List <Long> data){
        int cellId = 0;
        XSSFRow row = sheet.createRow(rowId);
        Cell cell = row.createCell(cellId++);
        cell.setCellValue(rowName);
        for (Iterator<Long> iterator = data.iterator(); iterator.hasNext(); ) {
            cell = row.createCell(cellId++);
            cell.setCellValue(iterator.next());
        }
    }

}

