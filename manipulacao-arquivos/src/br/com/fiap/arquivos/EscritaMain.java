package br.com.fiap.arquivos;

import java.io.*;

public class EscritaMain {

    public static void main(String[] args) {
        File arquivo = new File("arquivo.txt"); // Navega na pasta até o arquivo
        if(!arquivo.exists() || arquivo.canWrite()) {
            try {
                FileWriter fileWriter = new FileWriter(arquivo); // Abertura do arquivo
                PrintWriter printWriter = new PrintWriter(fileWriter); // Digitar no arquivo

                printWriter.println("#--- Meu primeiro arquivo com Java 15 ---#");
                printWriter.println("- Hello World -");
                printWriter.println("- Hello Arquivos! -");

                printWriter.close();
                fileWriter.close(); // Salva o arquivo no HD
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
