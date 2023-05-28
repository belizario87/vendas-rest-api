package br.com.belizario87.vendas.vendasapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import br.com.belizario87.vendas.vendasapp.domain.entity.Cliente;
import br.com.belizario87.vendas.vendasapp.domain.repository.ClienteRepository;
import br.com.belizario87.vendas.vendasapp.exception.ClienteNotFoundException;
import br.com.belizario87.vendas.vendasapp.exception.FormatException;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente salvarCliente(Cliente cliente) {
        try {
            return clienteRepository.save(cliente);

        } catch (Exception e) {
            throw new FormatException("Erro ao salvar cliente");
        }

    }

    @Override
    public Cliente obterClientePorId(Integer id) {
        Cliente clientePorId = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente nao encontrado"));

        return clientePorId;
    }

    @Override
    public Cliente atualizarCliente(Integer id, Cliente cliente) {
        Cliente clienteAtualizado = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente nao encontrado"));

        clienteAtualizado.setNome(cliente.getNome());
        clienteAtualizado.setCpf(cliente.getCpf());

        return clienteRepository.save(clienteAtualizado);
    }

    @Override
    public void deletarCliente(Integer id) {
        Cliente clienteDeletado = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente nao encontrado"));
        clienteRepository.delete(clienteDeletado);
    }

    @Override
    public List<Cliente> buscarClientes(Cliente filtro) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Cliente> example = Example.of(filtro, matcher);
        return clienteRepository.findAll(example);
    }

}
