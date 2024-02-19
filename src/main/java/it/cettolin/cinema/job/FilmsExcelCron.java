package it.cettolin.cinema.job;

import it.cettolin.cinema.service.interfaces.ExcelReaderServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class FilmsExcelCron {

    private final ExcelReaderServiceInterface excelReaderService;

    @Scheduled(cron = "0 0 0 * * 1") // Every Monday at midnight
    public void readExcelJob() {
        try {
            excelReaderService.readExcel();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
