package it.cettolin.cinema.service.interfaces;

import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface ExcelReaderServiceInterface {

    void readExcel() throws IOException;

}
