package br.com.fiap.locadora.tests;

import br.com.fiap.locadora.exceptions.CarroNaoDisponivelException;
import br.com.fiap.locadora.exceptions.LocacaoException;
import br.com.fiap.locadora.models.Carro;
import br.com.fiap.locadora.models.Cliente;
import br.com.fiap.locadora.models.Locacao;
import br.com.fiap.locadora.services.LocacaoService;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;

import static br.com.fiap.locadora.utils.DataUtils.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class LocacaoTest {

    private LocacaoService service;

    @Rule
    public ErrorCollector erros = new ErrorCollector();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before // Como se fosse o construtor do teste.
    public void inicializa() {
        System.out.println("Executa antes de realizar os testes.");
        service = new LocacaoService();
    }

    @Test
    public void testeAlugaCarro() throws Exception {
        Cliente cliente = new Cliente("Gustavo");
        Carro carro = new Carro("Renault Clio 2012", 5, 10.0);

        Locacao locacao = service.alugaCarro(cliente, carro);

        erros.checkThat(locacao.getValor(), is(equalTo(10.0)));
        erros.checkThat(ehMesmaData(LocalDate.now(), locacao.getDataRetirada()), is(true));
        erros.checkThat(ehMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(3)), is(true));
    }

    @Test(expected = CarroNaoDisponivelException.class)
    public void testeCarroNaoDisponivel() throws Exception{
        Cliente cliente = new Cliente("Martin");
        Carro carro = new Carro("Fiat Uno", 0, 10.0);

        service.alugaCarro(cliente, carro);
    }

    @Test
    public void testeVeiculoVazio() {
        Cliente cliente = new Cliente("Andrey");

        try {
            service.alugaCarro(cliente, null);
            fail(); // Da classe Assert
        } catch (CarroNaoDisponivelException | LocacaoException e) {
            assertEquals("Carro não informado", e.getMessage());
        }
    }

    @Test
    public void testeClienteVazio() throws  CarroNaoDisponivelException, LocacaoException {
        Carro carro = new Carro("Renault Clio 2012", 5, 10.0);

        exception.expect(LocacaoException.class);
        exception.expectMessage("Cliente não informado");

        service.alugaCarro(null, carro);
    }

    @After
    public void finaliza() {
        System.out.println("Executado após o teste.");
    }
}
