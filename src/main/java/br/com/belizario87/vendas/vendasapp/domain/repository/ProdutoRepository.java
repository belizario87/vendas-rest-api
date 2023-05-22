package br.com.belizario87.vendas.vendasapp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.belizario87.vendas.vendasapp.domain.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
