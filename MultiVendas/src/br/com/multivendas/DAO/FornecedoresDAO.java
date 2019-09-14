package br.com.multivendas.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.multivendas.conexao.Conexao_bd;
import br.com.multivendas.domain.Fornecedores;

public class FornecedoresDAO {

	// Comando salvar
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

	// Comando excluir
	public void excluir(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fornecedores ");
		sql.append("WHERE codigo_forn = ?");

		Connection conexao = Conexao_bd.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());
		comando.executeUpdate();
	}

	// Comando editar
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

	// Comando busca por codigo
	public Fornecedores buscaPorCodigo(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo_forn, descricao_forn ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE codigo_forn = ? ");

		Connection conexao = Conexao_bd.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setLong(1, f.getCodigo());
		ResultSet resultado = comando.executeQuery();
		Fornecedores retorno = null;

		if (resultado.next()) {
			retorno = new Fornecedores();
			retorno.setCodigo(resultado.getLong("codigo_forn"));
			retorno.setDescricao(resultado.getString("descricao_forn"));
		}
		return retorno;
	}

	// Comando buscar por Descricao
	public ArrayList<Fornecedores> buscarPorDescricao(Fornecedores f) throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo_forn, descricao_forn ");
		sql.append("FROM fornecedores ");
		sql.append("WHERE descricao_forn LIKE ? ");
		sql.append("ORDER BY descricao_forn ASC ");

		Connection conexao = Conexao_bd.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, "%" + f.getDescricao() + "%");

		ResultSet resultado = comando.executeQuery();

		ArrayList<Fornecedores> lista = new ArrayList<Fornecedores>();

		while (resultado.next()) {
			Fornecedores item = new Fornecedores();
			item.setCodigo(resultado.getLong("codigo_forn"));
			item.setDescricao(resultado.getString("descricao_forn"));

			lista.add(item);
		}
		return lista;
	}
		
	// Comando Listar
	public ArrayList<Fornecedores> listar() throws SQLException {

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo_forn, descricao_forn ");
		sql.append("FROM fornecedores ");
		sql.append("ORDER BY descricao_forn ASC ");

		Connection conexao = Conexao_bd.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		ResultSet resultado = comando.executeQuery();
		ArrayList<Fornecedores> lista = new ArrayList<Fornecedores>();

		while (resultado.next()) {
			Fornecedores f = new Fornecedores();
			f.setCodigo(resultado.getLong("codigo_forn"));
			f.setDescricao(resultado.getString("descricao_forn"));

			lista.add(f);
		}
		return lista;
	}

}
