package it.cettolin.cinema.service;

import it.cettolin.cinema.dto.FilmDto;
import it.cettolin.cinema.model.Film;
import it.cettolin.cinema.service.interfaces.ExcelReaderServiceInterface;
import it.cettolin.cinema.service.interfaces.FilmServiceInterface;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ExcelReaderService implements ExcelReaderServiceInterface {

    private static final String EXCEL = "films.xlsx";
    private final FilmServiceInterface filmService;

    @Override
    public void readExcel() throws IOException {
        var f = new ClassPathResource(EXCEL);
        File file = new ClassPathResource(EXCEL).getFile();
        try (InputStream inp = new FileInputStream(file)) {
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(0); // Assuming first sheet

            Map<String, Integer> columns = mapColumns(sheet);
            List<FilmDto> films = readExcelFile(sheet, columns);
            films.forEach(filmService::save);
        }
    }

    public static Map<String, Integer> mapColumns(Sheet sheet) {
        Row headerRow = sheet.getRow(0);
        Map<String, Integer> columnMap = new HashMap<>();
        for (Cell cell : headerRow) {
            columnMap.put(cell.getStringCellValue(), cell.getColumnIndex());
        }
        return columnMap;
    }

    public static List<FilmDto> readExcelFile(Sheet sheet, Map<String, Integer> columnMap) {
        List<FilmDto> films = new ArrayList<>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            FilmDto filmDto = new FilmDto();
            for (Map.Entry<String, Integer> entry : columnMap.entrySet()) {
                String columnName = entry.getKey();
                Integer columnIndex = entry.getValue();
                Cell cell = row.getCell(columnIndex);
                if (cell != null) {
                    switch (columnName) {
                        case "name":
                            filmDto.setName(cell.getStringCellValue());
                            break;
                        case "note":
                            filmDto.setNote(cell.getStringCellValue());
                            break;
                        case "room":
                            filmDto.setRoomId(Long.valueOf(cell.getStringCellValue()));
                            break;
                        case "director":
                            filmDto.setDirectorId(Long.valueOf(cell.getStringCellValue()));
                            break;
                        case "startDate":
                            filmDto.setStartDate(toDate(cell.getStringCellValue()));
                            break;
                        case "endDate":
                            filmDto.setEndDate(toDate(cell.getStringCellValue()));
                            break;
                        // Add more cases for other columns
                    }
                }
            }
            films.add(filmDto);
        }
        return films;
    }

    private static Date toDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            return null; //qua lancerei errore e quindi skipperei l'insert, loggando l'errore
        }
    }

}
