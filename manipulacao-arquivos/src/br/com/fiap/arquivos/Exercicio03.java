package br.com.fiap.arquivos;

import java.io.*;

public class Exercicio03 {

    public static void main(String[] args) {

        try {
            FileReader fr = new FileReader("floats.txt");
            BufferedReader reader = new BufferedReader(fr);

            double maximo = 0.0;
            String linha;
            while((linha = reader.readLine()) != null) {
                double numero = Double.parseDouble(linha);
                if(numero > maximo) maximo = numero;
            }

            System.out.println(maximo);

            reader.close();
            fr.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
