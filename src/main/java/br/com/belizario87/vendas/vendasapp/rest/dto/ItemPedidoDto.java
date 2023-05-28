package br.com.belizario87.vendas.vendasapp.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ItemPedidoDto {

    private Integer produtoId;
    private Integer quantidade;

}
