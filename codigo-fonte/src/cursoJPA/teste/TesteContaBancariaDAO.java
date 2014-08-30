package cursoJPA.teste;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import cursoJPA.DAO.ContaBancariaDAO;
import cursoJPA.DAO.MovimentacaoDAO;
import cursoJPA.bean.ContaBancaria;
import cursoJPA.bean.Movimentacao;
import cursoJPA.bean.TipoMovto;
import cursoJPA.controller.JPAUtil;

public class TesteContaBancariaDAO {

	private ContaBancaria deveRetornarContaBancaria(Long id, EntityManager em){
		
		ContaBancariaDAO dao = new ContaBancariaDAO(em);
		ContaBancaria conta = new ContaBancaria();
		conta = dao.consultar(id);
	
		System.out.println(conta.toString()+"Retornada");
		return conta;
	}

	@Test
	public void deveCadastrarContaBancaria(){
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		
		ContaBancariaDAO dao = new ContaBancariaDAO(em);
		ContaBancaria conta = new ContaBancaria();
		conta.setTitular("Carlos");
		conta.setSaldo(new BigDecimal (1000));
		dao.cadastrar(conta);
		
		Assert.assertNotNull(conta.getId());
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	
/*	@Test
	public void deveExcluirContaBancaria(ContaBancaria conta){
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		ContaBancariaDAO dao = new ContaBancariaDAO(em);
		
		//Assert.assertNotNull(dao.excluir(conta));
		
	}
	
	@Test
	public void deveAtualizarContaBancaria(ContaBancaria conta){

	}*/

}
