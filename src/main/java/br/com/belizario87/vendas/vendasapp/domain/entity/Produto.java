package br.com.belizario87.vendas.vendasapp.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco_unitario")
    private Double preco;

    // @Column(name = "quantidade_estoque")
    // private int quantidade;

    public Produto() {
    };

    public Produto(Integer id, String descricao, Double preco) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        // this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    // public int getQuantidade() {
    // return quantidade;
    // }

    // public void setQuantidade(int quantidade) {
    // this.quantidade = quantidade;
    // }

}
