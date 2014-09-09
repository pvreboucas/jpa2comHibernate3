package cursoJPA.DAO;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
	
/*	public List<Movimentacao> filtrarContaTipo(ContaBancaria conta, TipoMovto tipo){
		String jpql = "SELECT m FROM Movimentacao m WHERE m.conta = :pConta AND m.tipo = :pTipo";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", tipo);
		return query.getResultList();
	}*/
	
	public BigDecimal calcularTotalMovimento(ContaBancaria conta, TipoMovto tipo){
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
	
	public List<Movimentacao> listarMovimentacaoPorTitular(String titular){
		String jpql = "SELECT m FROM Movimentacao m WHERE m.conta.titular = :pTitular";
		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
		query.setParameter("pTitular", titular);
		return query.getResultList();
	}
	
	public List<Movimentacao> filtrar(ContaBancaria conta, TipoMovto tipoMovto){
		//NÃO É UMA PRÁTICA
		/*String jpql = "SELECT m FROM Movimentacao m ";
		if(conta != null){
			jpql += "WHERE m.conta = :pConta";
		}
		if(tipoMovto != null){
			jpql += "AND m.tipo = :pTipoMovto";
		}
		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class);
		if(conta!=null){
			query.setParameter("pConta", conta);
		}
		if(tipoMovto!=null){
			query.setParameter("pTipoMovto", tipoMovto);
		}*/
		
		//BOA PRÁTICA
		/*StringBuilder builder = new StringBuilder("SELECT m FROM Movimentacao m");
		if(conta != null){
			builder.append("WHERE m.conta = :pConta");
		}
		if(tipoMovto != null){
			builder.append("AND m.tipo = :pTipoMovto");
		}
		TypedQuery<Movimentacao> query = em.createQuery(builder.toString(), Movimentacao.class);
		if(conta!=null){
			query.setParameter("pConta", conta);
		}
		if(tipoMovto!=null){
			query.setParameter("pTipoMovto", tipoMovto);
		}*/
		
		//PRÁTICA MELHOR AINDA
		//Objeto para criação de criterios
		CriteriaBuilder cb = em.getCriteriaBuilder();
		//Definição de um criterio de consulta
		CriteriaQuery<Movimentacao> criterio = cb.createQuery(Movimentacao.class);
		//Definição da classe base para consulta
		Root<Movimentacao> root = criterio.from(Movimentacao.class);
		
		//Objeto que permite a inclusao de AND e OR
		Predicate condicao = cb.conjunction();
		//Criacao condicional dos componentes de filtro
		if(conta != null){
			condicao = cb.and(condicao, cb.equal(root.get("conta"), conta));
		}
		if(tipoMovto != null){
			condicao = cb.and(condicao, cb.equal(root.get("tipoMovto"), tipoMovto));
		}
		
		//Definicao da clausura WHERE
		criterio.where(condicao);
		//criacao da query baseada no criterio
		TypedQuery<Movimentacao> query = em.createQuery(criterio);
		//retorna o resultado da consulta
		return query.getResultList();
	}
}
