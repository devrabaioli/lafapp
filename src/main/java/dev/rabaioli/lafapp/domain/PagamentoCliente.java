package dev.rabaioli.lafapp.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import dev.rabaioli.lafapp.domain.enums.EstadoPagamento;
import jakarta.persistence.Entity;

@Entity
public class PagamentoCliente extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataVencimento;
	
	public PagamentoCliente() {}

	public PagamentoCliente(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento) {
		super(id, estado, pedido);
		this.dataVencimento = dataVencimento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	


}