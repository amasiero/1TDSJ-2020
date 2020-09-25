package br.com.fiap.arquivos;

import java.io.*;

public class LeituraMain {

    public static void main(String[] args) {
        File arquivo = new File("arquivo.txt");
        if(arquivo.exists() && arquivo.canRead()) {
            try {
                FileReader fileReader = new FileReader(arquivo);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                String linha;
                while((linha = bufferedReader.readLine()) !=  null) {
                    System.out.println(linha);
                }

                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
