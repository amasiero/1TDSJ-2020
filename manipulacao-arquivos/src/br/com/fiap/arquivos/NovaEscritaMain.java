package br.com.fiap.arquivos;

import java.io.*;

public class NovaEscritaMain {
    public static void main(String[] args) {
        File arquivo = new File("arquivo.txt");
        if(!arquivo.exists() || arquivo.canWrite()) {
            try (
                FileWriter fileWriter = new FileWriter(arquivo);
                PrintWriter printWriter = new PrintWriter(fileWriter)
            ) {
                printWriter.println("#--- Meu primeiro arquivo com Java 15 ---#");
                printWriter.println("- Hello World -");
                printWriter.println("- Hello Arquivos! -");
                printWriter.println("- Agora estamos sem o close! Fecha sozinho! -");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
