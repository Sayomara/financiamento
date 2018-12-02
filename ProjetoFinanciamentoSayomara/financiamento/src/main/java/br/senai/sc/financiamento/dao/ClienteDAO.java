package br.senai.sc.financiamento.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.senai.sc.financiamento.entity.Cliente;
import br.senai.sc.financiamento.factory.ConnectionFactory;

public class ClienteDAO {

	private ConnectionFactory connection;
	
	public void inserir(Cliente cliente) {
		try {
			String sql = "INSERT INTO cliente "
					+ "VALUES (DEFAULT, ?, ?, ?, ?, ?)";
			Connection con = connection.connect();
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getCpf());
			stm.setDate(3, (Date) cliente.getDataNascimento());
			stm.setDouble(4, cliente.getSalario().doubleValue());
			stm.setDouble(5, cliente.getValorFGTS().doubleValue());
			stm.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
