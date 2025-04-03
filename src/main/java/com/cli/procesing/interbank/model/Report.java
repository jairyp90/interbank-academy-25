package com.cli.procesing.interbank.model;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Clase Reporte que procesa y genera un informe de transacciones.
 */
@Component
public class Report {
    private double finalBalance;
    private Transaction TransactionHighestAmount;
    private int creditCount;
    private int DebitCount;

    public void proccessTransaction(List<Transaction> transacciones) {
        finalBalance = 0;
        TransactionHighestAmount = null;
        creditCount = 0;
        DebitCount = 0;

        for (Transaction trans : transacciones) {
            if (trans.getType().equals("Crédito")) {
                finalBalance += trans.getAmount();
                creditCount++;
            } else if (trans.getType().equals("Débito")) {
                finalBalance -= trans.getAmount();
                DebitCount++;
            }

            if (TransactionHighestAmount == null || trans.getAmount() > TransactionHighestAmount.getAmount()) {
                TransactionHighestAmount = trans;
            }
        }
    }

    public void printReport() {
        System.out.println("Reporte de Transacciones");
        System.out.println("---------------------------------------------");
        System.out.printf("Balance Final: %.2f\n", finalBalance);
        System.out.println("Transacción de Mayor Monto: ID " + TransactionHighestAmount.getId() +
                " - " + TransactionHighestAmount.getAmount());
        System.out.println("Conteo de Transacciones: Crédito: " + creditCount + " Débito: " + DebitCount);
    }
}