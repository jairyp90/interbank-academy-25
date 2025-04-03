package com.cli.procesing.interbank;

import com.cli.procesing.interbank.controller.TransactionController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootApplication
public class ProcesingTransactionApplication implements CommandLineRunner {
    private final TransactionController controller;

    public ProcesingTransactionApplication(TransactionController controller) {
        this.controller = controller;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProcesingTransactionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Usar el cargador de recursos de Spring Boot para obtener el archivo desde resources
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("data.csv");

        // Verificar si el archivo fue encontrado
        if (inputStream == null) {
            throw new FileNotFoundException("El archivo data.csv no se encuentra en el classpath.");
        }

        // Llamar al controlador y pasarle el InputStream en lugar de una ruta de archivo
        controller.processTransaction(inputStream);

        // Imprimir el reporte
        controller.printTransactionReport();
    }
}