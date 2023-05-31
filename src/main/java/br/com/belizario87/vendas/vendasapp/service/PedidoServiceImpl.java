package br.com.belizario87.vendas.vendasapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.belizario87.vendas.vendasapp.domain.entity.ItemPedido;
import br.com.belizario87.vendas.vendasapp.domain.entity.Pedido;
import br.com.belizario87.vendas.vendasapp.domain.repository.ClienteRepository;
import br.com.belizario87.vendas.vendasapp.domain.repository.PedidoRepository;
import br.com.belizario87.vendas.vendasapp.domain.repository.ProdutoRepository;
import br.com.belizario87.vendas.vendasapp.exception.ClienteNotFoundException;
import br.com.belizario87.vendas.vendasapp.rest.dto.ItemPedidoDto;
import br.com.belizario87.vendas.vendasapp.rest.dto.PedidosDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    @Override
    public Pedido salvarPedido(PedidosDto pedidoDto) {
        Integer idCliente = pedidoDto.getClienteId();
        clienteRepository.findById(idCliente).orElseThrow(() -> new ClienteNotFoundException("Cliente não encontrado"));

        Pedido pedido = new Pedido();
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(clienteRepository.findById(idCliente).get());

        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        return pedidoSalvo;

        
    }
    private void salvarItens(List<ItemPedidoDto> itens) {
       
    }

    @Override
    public Pedido buscarPedidoId(Integer id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

    }

    @Override
    public Pedido atualizarPedido(Integer id, Pedido produto) {
        // Pedido pedido = buscarPedidoId(id);
        // pedido.setItens(produto.getItens());
        return null;
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
