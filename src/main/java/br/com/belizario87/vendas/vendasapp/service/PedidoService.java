package br.com.belizario87.vendas.vendasapp.service;

import java.util.List;

import br.com.belizario87.vendas.vendasapp.domain.entity.Pedido;
import br.com.belizario87.vendas.vendasapp.rest.dto.PedidosDto;

public interface PedidoService {
    Pedido salvarPedido(PedidosDto pedidoDto);

    Pedido buscarPedidoId(Integer id);

    Pedido atualizarPedido(Integer id, Pedido produto);

    void deletarPedido(Integer id);

    List<Pedido> buscarPedido(Pedido filto);
}
