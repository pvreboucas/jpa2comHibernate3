package cursoJPA.controller;

import java.util.Calendar;

import javax.persistence.EntityManager;

import cursoJPA.DAO.ContaBancariaDAO;
import cursoJPA.DAO.MovimentacaoDAO;
import cursoJPA.bean.ContaBancaria;
import cursoJPA.bean.Movimentacao;
import cursoJPA.bean.TipoMovto;

public class TesteCadastroConta {

	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		
		ContaBancaria conta1 = new ContaBancaria();
		conta1.setTitular("Maria");
		conta1.setSaldo(500);
		
		ContaBancariaDAO daoConta1 = new ContaBancariaDAO(em);
		daoConta1.cadastrar(conta1);
		
		//Long id = (long) 1; 
		//conta1 = dao1.consultar(id);
		//dao1.excluir(conta1);
		
		Movimentacao mvt1 = new Movimentacao();
		mvt1.setConta(conta1);
		mvt1.setData(Calendar.getInstance());
		mvt1.setDescricao("Conta de Luz - 04/2014");
		mvt1.setTipo(TipoMovto.SAIDA);
		mvt1.setValor(53.40);
		
		MovimentacaoDAO daoMvt1 = new MovimentacaoDAO(em);
		daoMvt1.cadastrar(mvt1);
		
		em.getTransaction().commit();
		
		System.out.println(conta1.toString());
		System.out.println(mvt1.toString());
		System.out.println(daoMvt1.consultar(conta1.getId()).getDescricao());
		
		em.close();
		
	}

}
