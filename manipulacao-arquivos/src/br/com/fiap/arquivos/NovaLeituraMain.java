package br.com.fiap.arquivos;

import java.io.*;

public class NovaLeituraMain {
    public static void main(String[] args) {
        File arquivo = new File("arquivo.txt");
        if(arquivo.exists() && arquivo.canRead()) {
            try ( // Java 8
                FileReader fileReader = new FileReader(arquivo);
                BufferedReader bufferedReader = new BufferedReader(fileReader)
            ) {
                String linha;
                while((linha = bufferedReader.readLine()) !=  null) {
                    System.out.println(linha);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
