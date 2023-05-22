package br.com.belizario87.vendas.vendasapp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.belizario87.vendas.vendasapp.domain.entity.Cliente;
import br.com.belizario87.vendas.vendasapp.domain.entity.Pedido;
import br.com.belizario87.vendas.vendasapp.domain.repository.ClienteRepository;
import br.com.belizario87.vendas.vendasapp.domain.repository.PedidoRepository;

@SpringBootApplication
public class VendasappApplication {

	@Bean
	public CommandLineRunner init(@Autowired ClienteRepository clienteRepository,
			@Autowired PedidoRepository pedidoRepository) {
		return args -> {
			System.out.println("Salvando clientes");
			Cliente belizario = new Cliente("Belizario");
			clienteRepository.save(belizario);

			Pedido p = new Pedido();
			p.setCliente(belizario);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(100));
			pedidoRepository.save(p);
			Pedido p2 = new Pedido();

			p2.setCliente(belizario);
			p2.setDataPedido(LocalDate.now());
			p2.setTotal(BigDecimal.valueOf(200));
			pedidoRepository.save(p2);

			// Cliente cliente =
			// clienteRepository.findClinteFetchPedidos(belizario.getId());
			// System.out.println(cliente);
			// System.out.println(cliente.getPedidos());

			pedidoRepository.findByCliente(belizario).forEach(System.out::println);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasappApplication.class, args);
	}

}
