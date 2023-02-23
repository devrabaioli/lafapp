package dev.rabaioli.lafapp.dto;

import java.io.Serializable;

public class ClientNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String localidade;
	private String telefone1;
    private String telefone2;
	
	public ClientNewDTO() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	
	
	

}
