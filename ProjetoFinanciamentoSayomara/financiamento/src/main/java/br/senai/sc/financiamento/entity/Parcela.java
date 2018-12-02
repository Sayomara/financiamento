package br.senai.sc.financiamento.entity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

@XmlRootElement
public class Parcela {
	
	private Integer numero;
	
	@JsonIgnore
	private Date dataParcela;
	
	private String vencimento;
	
	private BigDecimal valor;
	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getDataParcela() {
		return dataParcela;
	}

	public void setDataParcela(Date vencimento) {
		this.dataParcela = vencimento;
	}

	public String getVencimento() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.vencimento = sdf.format(this.dataParcela);
		return vencimento;
	}

	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}
}
