package br.senai.sc.financiamento.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Cliente {

	private Integer id;
	
	private String nome;
	
	private String cpf;
	
	private Date dataNascimento;
	
	private BigDecimal salario;
	
	private BigDecimal valorFGTS;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public BigDecimal getValorFGTS() {
		return valorFGTS;
	}

	public void setValorFGTS(BigDecimal valorFGTS) {
		this.valorFGTS = valorFGTS;
	}
}
