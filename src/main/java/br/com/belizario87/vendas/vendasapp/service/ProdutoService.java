package br.com.belizario87.vendas.vendasapp.service;

import java.util.List;

import br.com.belizario87.vendas.vendasapp.domain.entity.Produto;

public interface ProdutoService {

    Produto salvarProduto(Produto produto);

    Produto buscarProdutoId(Integer id);

    Produto atualizarProduto(Integer id, Produto produto);

    void deletarProduto(Integer id);

    List<Produto> buscarProdutos(Produto filto);

}
