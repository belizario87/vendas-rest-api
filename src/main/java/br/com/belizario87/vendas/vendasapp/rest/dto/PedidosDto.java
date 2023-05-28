package br.com.belizario87.vendas.vendasapp.rest.dto;

import java.math.BigDecimal;

import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PedidosDto {

    private Integer clienteId;
    private BigDecimal total;
    private List<ItemPedidoDto> itens;

}
