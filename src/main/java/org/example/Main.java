package org.example;

import org.example.controller.Request;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    static Scanner scan = new Scanner(System.in);
    static Request request = new Request();

    public static void main(String[] args) throws IOException, InterruptedException
    {
        int opcao;
        do
        {
            System.out.println("\n1 - DEBITO\n2 - CREDITO\n3 - PIX\n0 - SAIR");
            System.out.println("Digite a opcao");
            opcao = scan.nextInt();

            switch (opcao)
            {
                case 1:
                    opcaoUm();
                    break;
                case 2:
                case 3:
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }


    public static void opcaoUm() throws IOException, InterruptedException
    {
        System.out.print("Digite o valor: R$ ");
        double value = scan.nextDouble();
        request.chamaPagamento(value,"CARD", "DEBIT", "FULL_PAYMENT" );
        request.consultaPagamento();
    }
}