package br.com.fiap.arquivos;

import java.io.*;

public class Exercicio01 {

    public static void main(String[] args) {

        try {
            FileReader fr = new FileReader("arquivo.txt");
            BufferedReader reader = new BufferedReader(fr);

            FileWriter fw = new FileWriter("arquivo-limpo.txt");
            PrintWriter writer = new PrintWriter(fw);

            String linha;
            while((linha = reader.readLine()) != null) {
                StringBuilder sb = new StringBuilder();
                for(char letra : linha.toCharArray()) {
                    if (letra == 32 ||
                            (letra >= 65 && letra <= 90) ||
                            (letra >= 97 && letra <= 122)) {
                        sb.append(letra);
                    }
                }
                writer.println(sb.toString().trim());
            }

            writer.close();
            fw.close();
            reader.close();
            fr.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
