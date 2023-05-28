package br.com.belizario87.vendas.vendasapp.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.belizario87.vendas.vendasapp.domain.entity.Pedido;
import br.com.belizario87.vendas.vendasapp.service.PedidoService;

@RestController
@RequestMapping("pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("")
    public ResponseEntity<Pedido> salvarPedido(@RequestBody Pedido pedido) {
        Pedido pedidoSalvo = pedidoService.salvarPedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);

    }

    public ResponseEntity<Pedido> buscarPedidoPorId(Integer id) {

        if (pedidoService.buscarPedidoId(id) != null) {
            return ResponseEntity.ok(pedidoService.buscarPedidoId(id));
        }

        return ResponseEntity.notFound().build();

    }

    public ResponseEntity<Pedido> atualizarPedido(Integer id, Pedido pedido) {
        if (pedidoService.buscarPedidoId(id) == null) {
            return ResponseEntity.notFound().build();

        }
        pedidoService.atualizarPedido(id, pedido);
        return ResponseEntity.noContent().build();

    }

    public ResponseEntity<Void> deletarPedido(Integer id) {
        if (pedidoService.buscarPedidoId(id) == null) {
            return ResponseEntity.notFound().build();

        }
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();

    }

    public ResponseEntity<List<Pedido>> buscarPedidos(Pedido filto) {
        if (pedidoService.buscarPedido(filto) != null) {
            return ResponseEntity.ok(pedidoService.buscarPedido(filto));
        }

        return ResponseEntity.notFound().build();

    }

}
