package dev.rabaioli.lafapp.domain.enums;

public enum EstadoPagamento {
	
	ENTREGUECNS(1, "Entregue CNS"),
	ENTREGUEAUTORIDADE(2, "Entregue Autoridade"),
	ENTREGUECLIENTE(3,"Entregue Cliente"),
	OUTRO(4,"Outro"),
	PENDENTE(5, "Pendente");
	
	private int cod;
	private String description;
	
	private EstadoPagamento(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public int getCod() {
		return cod;
	}

	
	public String getDescription() {
		return description;
	}

	public static EstadoPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(EstadoPagamento x : EstadoPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("invalid cod: " + cod);
	}


}
