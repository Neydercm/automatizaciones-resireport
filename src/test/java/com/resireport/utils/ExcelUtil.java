package com.resireport.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {

    private static final String FILE_PATH = "dataResiReport.xlsx";

    public static String getCellData(int row, int column) {

        String cellValue = "";

        try {

            FileInputStream file = new FileInputStream(FILE_PATH);

            Workbook workbook = new XSSFWorkbook(file);

            Sheet sheet = workbook.getSheetAt(0);

            Row currentRow = sheet.getRow(row);

            Cell cell = currentRow.getCell(column);

            cellValue = cell.toString();

            workbook.close();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cellValue;
    }
}