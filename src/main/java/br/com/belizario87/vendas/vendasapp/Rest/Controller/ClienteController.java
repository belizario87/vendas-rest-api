package br.com.belizario87.vendas.vendasapp.Rest.Controller;

import java.util.Optional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.belizario87.vendas.vendasapp.domain.entity.Cliente;
import br.com.belizario87.vendas.vendasapp.domain.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Cliente> obterClientePorId(@PathVariable Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("")
    public ResponseEntity<List<Cliente>> buscarTodosOsClientes() {
        List<Cliente> clientes = clienteRepository.findAll();

        return ResponseEntity.ok(clientes);
    }

    @PostMapping("/salvarcliente")
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return ResponseEntity.created(null).body(clienteSalvo);
    }

    @PutMapping("/atualizarcliente/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
        return clienteRepository.findById(id).map(clienteExistente -> {
            clienteExistente.setNome(cliente.getNome());
            clienteRepository.save(clienteExistente);
            return ResponseEntity.ok(clienteExistente);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
