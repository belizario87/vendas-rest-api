package br.com.belizario87.vendas.vendasapp.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.belizario87.vendas.vendasapp.domain.entity.Cliente;
import br.com.belizario87.vendas.vendasapp.exception.ClienteNotFoundException;
import br.com.belizario87.vendas.vendasapp.service.ClienteServiceImpl;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteServiceImpl clienteService;

    public ClienteController(ClienteServiceImpl clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> obterClientePorId(@PathVariable Integer id) {

        if (clienteService.obterClientePorId(id) != null) {
            return ResponseEntity.ok(clienteService.obterClientePorId(id));
        }

        return ResponseEntity.notFound().build();

    }

    @PostMapping
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteService.salvarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @DeleteMapping("{id}")
    public void deletarCliente(@PathVariable Integer id) {
        if (clienteService.obterClientePorId(id) == null) {
            throw new ClienteNotFoundException("Cliente não encontrado");
        }
        clienteService.deletarCliente(id);

    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        if (clienteService.obterClientePorId(id) == null) {
            throw new ClienteNotFoundException("Cliente não encontrado");
        }
        clienteService.atualizarCliente(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> buscarClientes(Cliente filtro) {

        if (clienteService.buscarClientes(filtro) != null) {
            return ResponseEntity.ok(clienteService.buscarClientes(filtro));
        }

        return ResponseEntity.notFound().build();

    }
}
