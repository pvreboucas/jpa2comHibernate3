package cursoJPA.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import cursoJPA.bean.ContaBancaria;

public class ContaBancariaDAO {
	
	private GenericDAO<ContaBancaria> dao;
	
	public ContaBancariaDAO(EntityManager em){
		dao = new GenericDAO<ContaBancaria>(em, ContaBancaria.class);
	}
	
	public void cadastrar(ContaBancaria conta){
		dao.cadastrar(conta);

	}
	
	public List<ContaBancaria> listar(){
		return dao.listar();
	}
	
	public void excluir(ContaBancaria conta){
		dao.excluir(conta);
	}
	
	public ContaBancaria consultar(Long id){
		return dao.consultar(id);
	}
	
	

}
