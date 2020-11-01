package br.ufc.crateus.trabalho.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity(name="cars")
public class Car{
	
	@Id
	@GeneratedValue
	int id;
	@NotBlank
	String nome;
	@NotBlank
	String marca;
	@NotBlank
	String anoFabricacao;
	@NotBlank
	String anoModelo;
	@NotBlank
	String dataVenda;
	

	public Car(int id, String nome, String marca, String anoFabricacao, String anoModelo, String dataVenda) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.dataVenda = dataVenda;
	}

	public Car(String nome, String marca, String anoFabricacao, String anoModelo, String dataVenda) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.dataVenda = dataVenda;
	}
	
	
	public Car() {
	
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getAnoFabricacao() {
		return anoFabricacao;
	}
	
	public void setAnoFabricacao(String anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	
	public String getAnoModelo() {
		return anoModelo;
	}
	
	public void setAnoModelo(String anoModelo) {
		this.anoModelo = anoModelo;
	}
	
	public String getDataVenda() {
		return dataVenda;
	}
	
	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}
	

	@Override
	public String toString() {
		return "Carro [id=" + id + ", nome=" + nome + ", marca=" + marca + ", anoFabricacao=" + anoFabricacao
				+ ", anoModelo=" + anoModelo + ", dataVenda=" + dataVenda + "]";
	}
	
}
