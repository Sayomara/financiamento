package br.senai.sc.financiamento.entity;

import java.math.BigDecimal;

import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;

@Produces("application/json; charset=UTF-8")
@XmlRootElement
public class Financiamento {
	
	private Integer qtdParcelas;
	
	private BigDecimal valor;
	
	private BigDecimal valorImovel;
	
	private BigDecimal juros;
	
	private BigDecimal percEntrada;

	public Integer getQtdParcelas() {
		return qtdParcelas;
	}

	public void setQtdParcelas(Integer qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}

	public BigDecimal getValorImovel() {
		return valorImovel;
	}

	public void setValorImovel(BigDecimal valorImovel) {
		this.valorImovel = valorImovel;
	}

	public BigDecimal getJuros() {
		return juros;
	}

	public void setJuros(BigDecimal juros) {
		this.juros = juros;
	}

	public BigDecimal getPercEntrada() {
		return percEntrada;
	}

	public void setPercEntrada(BigDecimal percEntrada) {
		this.percEntrada = percEntrada;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
