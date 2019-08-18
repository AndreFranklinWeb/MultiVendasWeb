package br.com.multivendas.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao_bd {

	private static final String USUARIO = "root";
	private static final String SENHA = "";
	private static final String URL = "jdbc:mysql://localhost:3306/bd_multivendas";
	
	public static Connection conectar() throws SQLException {
		
		//Referência ao driver do mysql para versões antigas do java.
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}
	/*
	public static void main(String[] args) {

		try {
			Connection conexao = Conexao_bd.conectar();
			System.out.println("Conexão com Banco de dados realizada com sucesso !");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Conexão com o banco de dados falhou !");
		}
	} */
}