package br.com.mjv.entities;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Employee {

	private Long id;

	@NotBlank(message = "O campo nome não pode ser vazio.")
	private String nome;

	@NotBlank(message = "O campo designação não pode ser vazio.")
	private String designacao;

	@JsonInclude(Include.NON_EMPTY)
	@NotNull(message = "Campo salário é de preenchimento obrigatório.")
	@DecimalMin(value = "999", message = "O valor do salário deve ser maior do que 999,00")
	@DecimalMax(value = "100000", message = "O valor do salário deve ser menor do que 100.000,00")
	private BigDecimal salario;

	private String telefone;
	private String endereco;

	public Employee() {
	}

	public Employee(long id, String nome, String designacao, BigDecimal salario, String telefone, String endereco) {
		this.id = id;
		this.nome = nome;
		this.designacao = designacao;
		this.salario = salario;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
