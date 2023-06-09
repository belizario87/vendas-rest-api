package br.com.belizario87.vendas.vendasapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import br.com.belizario87.vendas.vendasapp.domain.entity.Produto;
import br.com.belizario87.vendas.vendasapp.domain.repository.ProdutoRepository;
import br.com.belizario87.vendas.vendasapp.exception.ClienteNotFoundException;
import br.com.belizario87.vendas.vendasapp.exception.FormatException;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto salvarProduto(Produto produto) {
        Produto produtoSalvo = produtoRepository.save(produto);
        if (produtoSalvo == null) {
            throw new FormatException("Insira os dados do cliente em um formato válido");
        }

        return produtoSalvo;
    }

    @Override
    public Produto buscarProdutoId(Integer id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente nao encontrado"));
        return produto;

    }

    @Override
    public Produto atualizarProduto(Integer id, Produto produto) {
        Produto produtoAtualizado = produtoRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente nao encontrado"));
        produtoAtualizado.setDescricao(produto.getDescricao());
        produtoAtualizado.setPreco(produto.getPreco());

        return produtoRepository.save(produtoAtualizado);

    }

    @Override
    public void deletarProduto(Integer id) {
        Produto produtoDeletado = produtoRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente nao encontrado"));
        produtoRepository.delete(produtoDeletado);

    }

    @Override
    public List<Produto> buscarProdutos(Produto filto) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);

        Example<Produto> example = Example.of(filto, matcher);
        return produtoRepository.findAll(example);
    }

}
