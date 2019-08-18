package br.com.multivendas.bean;

import java.io.LineNumberInputStream;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.multivendas.DAO.FornecedoresDAO;
import br.com.multivendas.domain.Fornecedores;

@ManagedBean(name = "MBFornecedores")
@ViewScoped
public class FornecedoresBean {

	private ListDataModel<Fornecedores> itens;

	public ListDataModel<Fornecedores> getItens() {
		return itens;
	}

	public void setItens(ListDataModel<Fornecedores> itens) {
		this.itens = itens;
	}
	
	@PostConstruct
	public void prepararPesquisa(){
		
		FornecedoresDAO fdao = new FornecedoresDAO();
				
		try {
		ArrayList<Fornecedores>lista = fdao.listar();
		itens = new ListDataModel<Fornecedores>(lista);
		}catch (SQLException e){
			e.printStackTrace();
		}		
	}	
}
