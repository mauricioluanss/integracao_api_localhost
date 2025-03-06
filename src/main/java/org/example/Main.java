package org.example;
import org.example.controller.Requestis;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Requestis req = new Requestis();

        req.chamaPagamento(1, "CARD", "DEBIT", "FULL_PAYMENT");
    }
}