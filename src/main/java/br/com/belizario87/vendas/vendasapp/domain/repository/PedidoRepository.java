package br.com.belizario87.vendas.vendasapp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.belizario87.vendas.vendasapp.domain.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
