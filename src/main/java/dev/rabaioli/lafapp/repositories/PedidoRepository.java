package dev.rabaioli.lafapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.rabaioli.lafapp.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
