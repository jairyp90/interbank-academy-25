package com.cli.procesing.interbank.controller;

import com.cli.procesing.interbank.model.Report;
import com.cli.procesing.interbank.model.Transaction;
import com.cli.procesing.interbank.util.CSVReaderUtil;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Clase que controla el flujo de procesamiento de transacciones
 */
@Controller
public class TransactionController {

    private final CSVReaderUtil csvReader;
    private final Report report;

    public TransactionController(CSVReaderUtil csvReader, Report report) {
        this.csvReader = csvReader;
        this.report = report;
    }

    /**
     * Método para procesar las transacciones
     * @param fileCSV
     * @throws IOException
     */
    public void processTransaction(InputStream fileCSV) throws IOException {
        List<Transaction> transaction = csvReader.readArchive(fileCSV);
        report.proccessTransaction(transaction);
    }

    /**
     * Método para imprimir el reporte
     */
    public void printTransactionReport() {
        report.printReport();
    }
}

