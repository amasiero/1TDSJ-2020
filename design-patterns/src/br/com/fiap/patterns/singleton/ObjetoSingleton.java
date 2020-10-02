package br.com.fiap.patterns.singleton;

public class ObjetoSingleton {

    private static ObjetoSingleton instance;

    private ObjetoSingleton() {
        System.out.println("Objeto singleton criado.");
    }

    public static synchronized ObjetoSingleton getInstance() {
        if(instance == null) {
            instance = new ObjetoSingleton();
        }
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
