package br.com.belizario87.vendas.vendasapp.service;

import java.util.List;

import br.com.belizario87.vendas.vendasapp.domain.entity.Pedido;

public interface PedidoService {
    Pedido salvarPedido(Pedido produto);

    Pedido buscarPedidoId(Integer id);

    Pedido atualizarPedido(Integer id, Pedido produto);

    void deletarPedido(Integer id);

    List<Pedido> buscarPedido(Pedido filto);
}
