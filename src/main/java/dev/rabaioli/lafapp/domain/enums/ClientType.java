package dev.rabaioli.lafapp.domain.enums;

public enum ClientType {
	
	CNS(1,"CNS"),
	CLIENTE(2,"CLIENTE"),
	AUTORIDADES(3,"PSP/GNR"),
	DOACAO(4,"DOAçAO");
	
	private int cod;
	private String description;
	
	private ClientType(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public Integer getCod() {
		return cod;
	}

	
	public String getDescription() {
		return description;
	}
	
	public static ClientType toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for (ClientType x : ClientType.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid id " + cod);
		
	}

	
}
