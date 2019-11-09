package com.clj.monitoria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Monitores {
	@Id
	@GeneratedValue
    public Long id;
	@NotBlank(message = "Nome é obrigatório")
	@Size(max = 100)
    private String nome;
  	@NotBlank(message = "Informe o dia")
  	@Size(max = 8)
  	private String dia;

  	
  	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	
}
