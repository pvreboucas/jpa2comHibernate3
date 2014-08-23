package cursoJPA.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import cursoJPA.bean.Movimentacao;

public class MovimentacaoDAO {

	GenericDAO<Movimentacao> dao;
	
	MovimentacaoDAO(EntityManager em){
		dao = new GenericDAO<Movimentacao>(em, Movimentacao.class);
	}
	
	public void cadastrar(Movimentacao mvt){
		dao.cadastrar(mvt);
	}
	
	public List<Movimentacao> listar(){
		return dao.listar();
	}
	
	public void remover(Movimentacao mvt){
		dao.excluir(mvt);
	}
	
	public Movimentacao consultar(Long id){
		return dao.consultar(id); 	
	}
}
