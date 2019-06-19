package org.itstep;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        String owner = keyboard.nextLine();

        try (Socket client = new Socket("127.0.0.1", 9000)) {
            try (
                Scanner scanner = new Scanner(client.getInputStream());
                PrintWriter writer = new PrintWriter(client.getOutputStream())
            ) {
                writer.println(0);
                writer.println(owner);
                writer.flush();

                Integer accountNumber = Integer.parseInt(scanner.nextLine());
                System.out.println("Создан счет: " + accountNumber);
            }
        }
    }
}
