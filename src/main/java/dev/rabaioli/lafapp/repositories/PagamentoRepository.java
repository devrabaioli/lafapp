package dev.rabaioli.lafapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.rabaioli.lafapp.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
