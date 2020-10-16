package br.com.fiap.locadora.services;

import br.com.fiap.locadora.exceptions.CarroNaoDisponivelException;
import br.com.fiap.locadora.exceptions.LocacaoException;
import br.com.fiap.locadora.models.Carro;
import br.com.fiap.locadora.models.Cliente;
import br.com.fiap.locadora.models.Locacao;

import static br.com.fiap.locadora.utils.DataUtils.*;

import java.time.LocalDate;

public class LocacaoService {

    public Locacao alugaCarro(Cliente cliente, Carro carro) throws LocacaoException, CarroNaoDisponivelException {
        if(cliente == null) throw new LocacaoException("Cliente não informado");

        if(carro == null) throw new LocacaoException("Carro não informado");

        if(carro.getDisponiveis() == 0) throw new CarroNaoDisponivelException();

        Locacao locacao = new Locacao();
        locacao.setCliente(cliente);
        locacao.setCarro(carro);
        locacao.setDataRetirada(LocalDate.now());
        locacao.setDataRetorno(adicionaDias(LocalDate.now(), 3));
        locacao.setValor(carro.getValor());

        //Salvar a locacao, no banco de dados
        // TODO adicionar método da DAO para salvar

        return locacao;
    }

    public static void main(String... args) throws Exception {
        // Cenário -> As condições para o teste acontecer
        LocacaoService service = new LocacaoService();
        Cliente cliente = new Cliente("Gustavo");
        Carro carro = new Carro("Renault Clio 2012", 5, 10.0);

        // Ação -> São os métodos que preciso executar para chegar no resultado
        Locacao locacao = service.alugaCarro(cliente, carro);

        // Validação -> Ver ser o resultado obtido é igual ao esperado
        System.out.println(locacao.getValor() == 10.0);
        System.out.println(ehMesmaData(LocalDate.now(), locacao.getDataRetirada()));
        System.out.println(ehMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(3)));
    }

}
