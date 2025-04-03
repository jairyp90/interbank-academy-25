package com.cli.procesing.interbank.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {

    private int id;
    private String type;
    private double amount;

}
