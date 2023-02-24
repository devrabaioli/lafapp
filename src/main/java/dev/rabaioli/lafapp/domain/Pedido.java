package dev.rabaioli.lafapp.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Pedido implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date instant;
	
	@ManyToOne
	@JoinColumn(name="lost_id")
	private Lost lost;
	
	@OneToOne(cascade = CascadeType.ALL,  mappedBy = "pedido")
	private Pagamento pagamento;
	
	@ManyToOne
	@JoinColumn(name = "userapp_id")
	private UserAPP userapp;
	
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	public Pedido() {}

	public Pedido(Integer id, Date instant,  Client client, Lost lost, UserAPP userAPP) {
		super();
		this.id = id;
		this.instant = instant;
		this.client = client;
		this.lost = lost;
		this.userapp = userAPP;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstant() {
		return instant;
	}

	public void setInstant(Date instant) {
		this.instant = instant;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	

	public Lost getLost() {
		return lost;
	}

	public void setLost(Lost lost) {
		this.lost = lost;
	}
	

	public UserAPP getUserapp() {
		return userapp;
	}

	public void setUserapp(UserAPP userapp) {
		this.userapp = userapp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido número: ");
		builder.append(getId());
		builder.append(", Instante: ");
		builder.append(sdf.format(getInstant()));
		builder.append(", Cliente: ");
		builder.append(getClient().getName());
		builder.append(" \n Perdido nº");
		builder.append(getLost().getId());
		builder.append(" \n Descriçao: ");
		builder.append(getLost().getDescription());
		builder.append(" \n Quem encontrou: ");
		builder.append(getLost().getWhoFind());
		builder.append(" \n Local: ");
		builder.append(getLost().getLocal());
		builder.append(" \n Vigilante:");
		builder.append(getLost().getUserApp());
		builder.append(", \n Situação do pagamento: ");
		builder.append(getPagamento().getEstado().getDescription());
		builder.append("\nFim:\n");
		return builder.toString();
	}
	
	

}
