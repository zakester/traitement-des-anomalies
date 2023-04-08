package com.p.traitementanomalies.Utility;

import com.p.traitementanomalies.DataHandler.SolutionHandler;
import com.p.traitementanomalies.Models.Action;
import com.p.traitementanomalies.Models.ActionType;
import com.p.traitementanomalies.Models.Solution;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ReadXSL {
    private static final String PATH = "/home/zakester/Traitement des Anomalies/db.xlsx";
    private SolutionHandler solutionHandler;

    public void readXSL() {
        InputStream fileInput;
        try {
            fileInput = new FileInputStream(PATH);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Workbook workbook;
        try {
            workbook = WorkbookFactory.create(fileInput);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet = workbook.getSheetAt(0);

        int row = 1;

        try {

            while (sheet.getRow(row).getCell(0) != null) {
                var currentRow = sheet.getRow(row);

                String anomalies = currentRow.getCell(0).getStringCellValue();
                String corrective = currentRow.getCell(1).getStringCellValue();
                String preventive = currentRow.getCell(2).getStringCellValue();

                ArrayList<Action> correctives = new ArrayList<>();
                ArrayList<Action> preventives = new ArrayList<>();


                for (String it: corrective.split("•")) {
                    if (it.isEmpty() || it.length() == 1) continue;
                    it = it.trim();
                    correctives.add(new Action(ActionType.CORRECTIVE, it));
                }

                for (String it: preventive.split("•")) {
                    if (it.isEmpty() || it.length() == 1) continue;
                    it = it.trim();
                    preventives.add(new Action(ActionType.PREVENTIVE, it));
                }

                this.solutionHandler.add(new Solution(anomalies, correctives, preventives));

                row++;
            }

        } catch (Exception e) {
        }

    }

    public void setSolutionHandler(SolutionHandler solutionHandler) {
        this.solutionHandler = solutionHandler;
    }

}
