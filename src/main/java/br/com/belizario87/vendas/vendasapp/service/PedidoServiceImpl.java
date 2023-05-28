package br.com.belizario87.vendas.vendasapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.belizario87.vendas.vendasapp.domain.entity.Pedido;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Override
    public Pedido salvarPedido(Pedido produto) {

        throw new UnsupportedOperationException("Unimplemented method 'salvarPedido'");
    }

    @Override
    public Pedido buscarPedidoId(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPedidoId'");
    }

    @Override
    public Pedido atualizarPedido(Integer id, Pedido produto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarPedido'");
    }

    @Override
    public void deletarPedido(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletarPedido'");
    }

    @Override
    public List<Pedido> buscarPedido(Pedido filto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPedido'");
    }

}
