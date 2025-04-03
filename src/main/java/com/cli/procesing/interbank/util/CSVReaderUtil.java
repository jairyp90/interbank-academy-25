package com.cli.procesing.interbank.util;

import com.cli.procesing.interbank.model.Transaction;
import org.apache.commons.csv.*;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

/**
 * Clase Utilitaria para lectura de archivos CSV
 */
@Component
public class CSVReaderUtil {
    public List<Transaction> readArchive(InputStream inputStream) throws IOException {
        List<Transaction> transactions = new ArrayList<>();

        try (Reader reader = new InputStreamReader(inputStream);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())) {

            for (CSVRecord record : csvParser) {
                int id = Integer.parseInt(record.get("id"));
                String type = record.get("tipo");
                double amount = Double.parseDouble(record.get("monto"));
                transactions.add(new Transaction(id, type, amount));
            }
        }
        return transactions;
    }
}
