package br.com.fiap;

import br.com.fiap.locadora.models.Cliente;
import org.junit.Test;

import static org.junit.Assert.*; // Para utilizarmos os métodos asserts

public class AssertTest {

    @Test // A anotação Test indica que esse método é um teste unitário.
    public void testNumerosInteirosIguais() {
        int i = 5; // Tipo inteiro primitivo
        Integer j = 5; // Tipo inteiro por referencia
        // assertEquals compara se dois objetos possuem valores iguais
        // através do método equals da classe.
        // Não é possível comparar tipo primitivo com tipo
        // por referência (classe).
        // O método valueOf, transforma o tipo primitivo em um
        // objeto da classe.
        assertEquals(Integer.valueOf(i), j);
        // Primitivo com primitivo funciona também
        assertEquals(2, 2);
    }

    @Test
    public void testNumerosInteirosDiferentes() {
        // assertNotEquals que verifica se os objetos possuem valores diferentes
        assertNotEquals(2, 3);
    }

    @Test
    public void testNumerosReaisIguais() {
        // Para números com ponto flutuante, você deve informar a
        // precisão referente as casas decimais consideradas na
        // comparação, como um terceiro parâmetro do método
        // assertEquals.
        assertEquals(0.5124, 0.512, 0.001);
    }

    @Test
    public void testTexto() {
        assertEquals("java", "java");
    }

    @Test
    public void testTextoCaseInsensitive() {
        // assertTrue que valida se o valor passado como
        // parâmetro é verdadeiro.
        assertTrue("java".equalsIgnoreCase("Java"));
    }

    @Test
    public void testTextosDiferentes() {
        // assertFalse que valida se o valor passado como
        // parâmetro é falso.
        assertFalse("java".startsWith("Ro"));
    }

    @Test
    public void testInstanciasIguais() {
        Cliente cliente = new Cliente("Gustavo");
        // assertSame verifica o endereço de memória para o
        // objeto instanciado.
        assertSame(cliente, cliente);
    }

    @Test
    public void testInstanciasDiferentes() {
        Cliente c1 = new Cliente("Gustavo");
        Cliente c2 = new Cliente("Gustavo");
        // assertNotSame verifica se o endereço de memória para os
        // objetos instanciados são diferentes.
        assertNotSame(c1, c2);
    }

    @Test
    public void testInstanciaNula() {
        Cliente c1 = null;
        // assertNull verifica se o objeto está nulo.
        assertNull(c1);
    }

    @Test
    public void testInstancia() {
        Cliente c1 = new Cliente("Gustavo");
        // assertNotNull verifica se o objeto foi instanciado
        // de maneira adequada.
        assertNotNull(c1);
    }
}
