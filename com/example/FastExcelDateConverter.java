package main.java.com.example;

import com.github.dhatim.fastxls.reader.ExcelReader;
import com.github.dhatim.fastxls.reader.ExcelReaderFactory;
import com.github.dhatim.fastxls.reader.ExcelSheetReader;
import com.github.dhatim.fastxls.reader.ExcelRowReader;
import com.github.dhatim.fastxls.reader.ExcelCellReader;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FastExcelDateConverter {
    public static void main(String[] args) {
        File file = new File("path/to/your/file.xlsx");

        try (ExcelReader reader = ExcelReaderFactory.createExcelReader(file)) {
            ExcelSheetReader sheetReader = reader.getSheet(0);

            // Define the date format
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Read each row
            sheetReader.forEach(row -> {
                // Read each cell
                row.forEach(cell -> {
                    if (cell.isDate()) {
                        // Convert date to string
                        Date date = cell.getDate();
                        String dateString = dateFormat.format(date);
                        System.out.println("Date as String: " + dateString);
                    } else {
                        // Handle other types of cells if needed
                        System.out.println("Cell Value: " + cell.getValue());
                    }
                });
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}