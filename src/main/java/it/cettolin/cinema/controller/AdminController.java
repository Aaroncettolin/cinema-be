package it.cettolin.cinema.controller;

import it.cettolin.cinema.service.interfaces.ExcelReaderServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final ExcelReaderServiceInterface excelReaderService;

    @PostMapping
    public ResponseEntity<String> generateFilmsAfterExcelComputation() throws IOException {
        try {
            excelReaderService.readExcel();
            return ResponseEntity.ok("Computation done");
        } catch (IOException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

}
