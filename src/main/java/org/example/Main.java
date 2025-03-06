package org.example;
import org.example.controller.Request;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Request req = new Request();

        req.chamaPagamento(1, "CARD", "DEBIT", "FULL_PAYMENT");
        req.consultaPagamento();
    }
}