package br.com.belizario87.vendas.vendasapp.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.belizario87.vendas.vendasapp.domain.entity.Produto;
import br.com.belizario87.vendas.vendasapp.service.ProdutoServiceImpl;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoServiceImpl produtoService;

    public ProdutoController(ProdutoServiceImpl produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
        Produto produtoSalvo = produtoService.salvarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);

    }

    @GetMapping("{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Integer id) {

        if (produtoService.buscarProdutoId(id) != null) {
            return ResponseEntity.ok(produtoService.buscarProdutoId(id));
        }

        return ResponseEntity.notFound().build();

    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Integer id, @RequestBody Produto produto) {
        if (produtoService.buscarProdutoId(id) == null) {
            return ResponseEntity.notFound().build();

        }
        produtoService.atualizarProduto(id, produto);
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Integer id) {
        if (produtoService.buscarProdutoId(id) == null) {
            return ResponseEntity.notFound().build();
        }
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscarProdutos(Produto filtro) {
        if (produtoService.buscarProdutos(filtro) != null) {
            return ResponseEntity.ok(produtoService.buscarProdutos(filtro));
        }

        return ResponseEntity.notFound().build();

    }

}
