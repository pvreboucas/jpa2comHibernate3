package cursoJPA.controller;

import javax.persistence.EntityManager;

import cursoJPA.DAO.ContaBancariaDAO;
import cursoJPA.bean.ContaBancaria;

public class TesteCadastroConta {

	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		ContaBancaria conta1 = new ContaBancaria();
		conta1.setTitular("Maria");
		conta1.setSaldo(500);
		
		ContaBancariaDAO dao1 = new ContaBancariaDAO(em);
		em.getTransaction().begin();
		dao1.cadastrar(conta1);
		//Long id = (long) 1; 
		//conta1 = dao1.consultar(id);
		//dao1.excluir(conta1);
		em.getTransaction().commit();
		em.close();
		
		System.out.println(conta1.toString());
		
	}

}
