package cursoJPA.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import cursoJPA.DAO.ContaBancariaDAO;
import cursoJPA.bean.ContaBancaria;
import cursoJPA.controller.JPAUtil;

public class TesteContaDAO {
	
	@Test
	public void deveCadastrarConta(){
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
	
	

}
