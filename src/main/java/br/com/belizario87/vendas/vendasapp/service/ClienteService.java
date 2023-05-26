package br.com.belizario87.vendas.vendasapp.service;

import java.util.List;

import br.com.belizario87.vendas.vendasapp.domain.entity.Cliente;

public interface ClienteService {

    Cliente salvarCliente(Cliente cliente);

    Cliente obterClientePorId(Integer id);

    Cliente atualizarCliente(Integer id, Cliente cliente);

    void deletarCliente(Integer id);

    List<Cliente> buscarClientes(Cliente filtro);

}
