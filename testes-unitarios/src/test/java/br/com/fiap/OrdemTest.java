package br.com.fiap;

import br.com.fiap.locadora.models.Cliente;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

// Essa anotação ela determina ou obriga a execução do
// script de teste em uma ordem especifica. Nesse exemplo,
// estamos utilizando a ordem crescente alfabética.
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrdemTest {

    // O atributo global do teste, nesse caso,
    // deve ser estatico
    private static Cliente cliente;

    // Esse é um teste requerido pelos demais.
    @Test
    public void inicia() {
        cliente = new Cliente("Luiz");
        Assert.assertNotNull(cliente);
    }

    // Esse é um teste dependente do anterior.
    @Test
    public void verifica() {
        Assert.assertEquals("Luiz", cliente.getNome());
    }
}
