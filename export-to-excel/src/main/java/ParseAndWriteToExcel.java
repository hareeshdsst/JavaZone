import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ParseAndWriteToExcel {


    public static void main(String[] args) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet 1");

        boolean encounterDash = false;
        String dashedLine = "----";
        List<Integer> spaceIndexes = new ArrayList<>();
        int rowCounter = 1;
        File file = new File("text.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            String line;
            while ((line = br.readLine()) != null) {
                if (encounterDash) {
                    int columnCounter = 0;
                    int start = 0;
                    Row row = sheet.createRow(rowCounter);
                    // System.out.println(spaceIndexes);
                    List<Integer> tabs = findCharacterIndexes(line, '\t');
                    List<Integer> tabSizes = new ArrayList<>();
                    int startPointer = 0;
                    int markerValue = tabs.get(0);
                    while (startPointer < tabs.size() - 1) {
                        int prev = startPointer;
                        for (int i = startPointer; i < tabs.size(); i++) {
                            if (prev != i) {
                                if (tabs.get(i) - tabs.get(prev) > 1) {
                                    markerValue = markerValue + (tabs.get(i) - tabs.get(prev)) - 1;
                                    startPointer = i;
                                    break;
                                } else {
                                    if (i == tabs.size() - 1)
                                        startPointer = i;
                                    markerValue = markerValue + 8;
                                    tabSizes.add(8);
                                }

                            } else {
                                int multiple8 = markerValue % 8;
                                if (multiple8 != 0) {
                                    int nextMultiple8 = (markerValue - multiple8) + 8;
                                    int tabSize = nextMultiple8 - markerValue;
                                    markerValue = markerValue + tabSize;
                                    tabSizes.add(tabSize);
                                } else {
                                    markerValue = markerValue + 8;
                                    tabSizes.add(8);
                                }

                            }
                            prev = i;
                        }
                    }
                    System.out.println(tabSizes);
                    String lineSpaced = line;
                    try {
                    for (int i = 0; i < tabs.size(); i++) {
                        lineSpaced = lineSpaced.replaceFirst("\t", StringUtils.repeat(' ', tabSizes.get(i)));
                    }
                    System.out.println(lineSpaced);
                        for (int index : spaceIndexes) {
                            String cellValue = lineSpaced.substring(start, index);
                            row.createCell(columnCounter).setCellValue(cellValue);
                            start = index;
                            columnCounter++;
                        }
                        String cellValue = lineSpaced.substring(start, lineSpaced.length());
                        row.createCell(columnCounter).setCellValue(cellValue);
                        rowCounter++;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Array Index out of bound may be last line inconsistency");
                    }
                } else {
                    if (line.contains(dashedLine)) {
                        spaceIndexes = findCharacterIndexes(line, ' ');
                        encounterDash = true;
                    }
                }
            }
        } finally {
            br.close();
        }
        FileOutputStream fileOut = new FileOutputStream("sample.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }

    static List<Integer> findCharacterIndexes(String textString, char c) {
        List<Integer> indexes = new ArrayList<Integer>();
        StringBuilder output = new StringBuilder();
        int index = 0;
        while (index != -1) {
            index = textString.indexOf(c, index + 1);  // Slight improvement
            if (index != -1) {
                indexes.add(index);
            }
        }
        return indexes;
    }

}
