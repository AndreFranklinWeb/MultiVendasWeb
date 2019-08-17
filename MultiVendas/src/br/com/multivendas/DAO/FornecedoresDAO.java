package br.com.multivendas.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import br.com.multivendas.conexao.Conexao_bd;
import br.com.multivendas.domain.Fornecedores;

public class FornecedoresDAO {
	
	//Comando salvar
	public void salvar(Fornecedores f) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("INSERT INTO fornecedores ");
		sql.append("(descricao_forn)");
		sql.append("VALUES (?)");

		Connection conexao = Conexao_bd.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.executeUpdate();
	}
	
	//Comando excluir 
	public void excluir(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fornecedores ");
		sql.append("WHERE codigo_forn = ?");

		Connection conexao = Conexao_bd.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		comando.executeUpdate();
	}
	
	//Comando editar 
	public void editar(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fornecedores ");
		sql.append("SET descricao_forn = ? ");
		sql.append("WHERE codigo_forn = ?");

		Connection conexao = Conexao_bd.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.setLong(2, f.getCodigo());
		comando.executeUpdate();
	}

}
