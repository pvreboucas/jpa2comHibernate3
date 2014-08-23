package cursoJPA.DAO;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import cursoJPA.bean.ContaBancaria;
import cursoJPA.bean.Movimentacao;
import cursoJPA.bean.TipoMovto;
import cursoJPA.valueObject.ValorPorMes;

public class MovimentacaoDAO {

	GenericDAO<Movimentacao> dao;
	EntityManager em;
	
	public MovimentacaoDAO(EntityManager em){
		this.em = em;
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
	
	public List<Movimentacao> filtrarConta(ContaBancaria conta){
		String jpql = "SELECT m FROM Movimentacao m WHERE m.conta = :pConta";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		return query.getResultList();
	}
	
	public List<Movimentacao> filtrarContaTipo(ContaBancaria conta, TipoMovto tipo){
		String jpql = "SELECT m FROM Movimentacao m WHERE m.conta = :pConta AND m.tipo = :pTipo";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);
		return query.getResultList();
	}
	
	/*public BigDecimal soma(ContaBancaria conta, TipoMovto tipo){
		String jpql = "SELECT SUM(m.valor) FROM Movimentacao m WHERE m.conta = :pConta and m.tipo = :pTipo";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);
		return (BigDecimal) query.getSingleResult();
	}*/
	
	public BigDecimal soma(ContaBancaria conta, TipoMovto tipo){
		String jpql = "SELECT SUM(m.valor) FROM Movimentacao m WHERE m.conta = :pConta and m.tipo = :pTipo";
		TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);
		return query.getSingleResult();
	}
	
	public List<ValorPorMes> listarMesesComMovimentacao(ContaBancaria conta, TipoMovto tipo){
		String jpql = "new cursoJPA.valueObject.ValorPorMes(month(m.data), sum(m.valor))"+
					  "FROM Movimentacao m"+
					  "GROUP BY month(m.data), m.conta, m.tipo"+
					  "HAVING m.conta = :pConta and m.tipo = :pTipo";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);
		return query.getResultList();
		}
}
