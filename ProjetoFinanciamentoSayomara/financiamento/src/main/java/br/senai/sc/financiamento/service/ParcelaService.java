package br.senai.sc.financiamento.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.senai.sc.financiamento.entity.Financiamento;
import br.senai.sc.financiamento.entity.Parcela;

public class ParcelaService {
	
	public List<Parcela> getParcelasByFinanciamento(Financiamento financiamento) {
		/*
		 * Aqui calculamos o valor do financiamento
		 */
		BigDecimal valorFinanciamento = new BigDecimal(0);
		valorFinanciamento = financiamento
								.getValorImovel()
								.multiply(financiamento.getPercEntrada())
								.divide(new BigDecimal(100));
		valorFinanciamento = financiamento.getValorImovel().subtract(valorFinanciamento);
		financiamento.setValor(valorFinanciamento);
		
		List<Parcela> lista = new ArrayList<Parcela>();
		
		/*
		 * Aqui criamos uma variável para salvar o valor anterior
		 */
		Parcela parcelaAnterior = new Parcela();
		
		BigDecimal amortizacao = new BigDecimal(0);
		BigDecimal valorParcela = new BigDecimal(0);
		BigDecimal juros = new BigDecimal(0);
		BigDecimal parcelas = new BigDecimal(financiamento.getQtdParcelas());
		Date dataParcela = new Date();
		
		/*
		 * Aqui calculamos a amortização
		 */
		amortizacao = financiamento.getValor().divide(parcelas, 2, RoundingMode.HALF_UP);
		/*
		 * Aqui calculamos os juros do saldo devedor do financiamento
		 */
		juros = financiamento
				.getJuros()
				.multiply(financiamento.getValor())
				.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
		
		/*
		 * Fazemos um for para gerar o parcelamento, 
		 * começando da parcela 1 até o total informado pelo usuário
		 */
		for(int i = parcelaAnterior.getNumero();i <= parcelas.intValue(); i++){
			Parcela parcelaAtual = new Parcela();
			parcelaAtual.setNumero(i);
			/*
			 * Se não for a primeira parcela, calcula o saldo devedor
			 * para ver o valor da próxima parcela.
			 */
			if(i > 1) {
				/*
				 * Aqui calculamos o saldo devedor do financiamento
				 */
				valorFinanciamento = valorFinanciamento.subtract(parcelaAnterior.getValor());
				
				/*
				 * Aqui calculamos os juros do saldo devedor do financiamento
				 */
				juros = financiamento
						.getJuros()
						.multiply(valorFinanciamento)
						.divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
				
				/*
				 * Aqui definimos o vencimento
				 */
				dataParcela = parcelaAnterior.getDataParcela();
				Calendar data = Calendar.getInstance();
				data.setTime(dataParcela);
				data.add(Calendar.DAY_OF_MONTH, 30);
				dataParcela = data.getTime();
			}
			/*
			 * Aqui somamos o valor da amortização aos juros
			 */
			valorParcela = amortizacao.add(juros);
			parcelaAtual.setValor(valorParcela);
			parcelaAtual.setDataParcela(dataParcela);
			/*
			 * Aqui adicionamos à lista de parcelas
			 */
			lista.add(parcelaAtual);
			/*
			 * Aqui definimos a parcela anterior
			 */
			parcelaAnterior = parcelaAtual;
		}
		return lista;
	}

}
