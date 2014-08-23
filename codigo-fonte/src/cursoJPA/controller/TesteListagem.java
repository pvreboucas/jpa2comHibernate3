package cursoJPA.controller;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import cursoJPA.DAO.ContaBancariaDAO;
import cursoJPA.DAO.MovimentacaoDAO;
import cursoJPA.bean.ContaBancaria;
import cursoJPA.bean.Movimentacao;
import cursoJPA.bean.TipoMovto;

public class TesteListagem {

/*	public static void main(String[] args) {
		
EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		
		ContaBancaria conta1 = new ContaBancaria();
		conta1.setTitular("João");
		conta1.setSaldo(500);
		
		ContaBancariaDAO daoConta = new ContaBancariaDAO(em);
		daoConta.cadastrar(conta1);
		
		Movimentacao mvt1 = new Movimentacao();
		mvt1.setConta(conta1);
		mvt1.setData(Calendar.getInstance());
		mvt1.setDescricao("Conta de Luz - 04/2014");
		mvt1.setTipo(TipoMovto.SAIDA);
		mvt1.setValor(53.40);
		
		Movimentacao mvt2 = new Movimentacao();
		mvt2.setConta(conta1);
		mvt2.setData(Calendar.getInstance());
		mvt2.setDescricao("Conta de Água - 05/2014");
		mvt2.setTipo(TipoMovto.SAIDA);
		mvt2.setValor(60.0);
		
		Movimentacao mvt3 = new Movimentacao();
		mvt3.setConta(conta1);
		mvt3.setData(Calendar.getInstance());
		mvt3.setDescricao("Salario - 06/2014");
		mvt3.setTipo(TipoMovto.ENTRADA);
		mvt3.setValor(2500);
		
		MovimentacaoDAO daoMvt = new MovimentacaoDAO(em);
		daoMvt.cadastrar(mvt1);
		daoMvt.cadastrar(mvt2);
		daoMvt.cadastrar(mvt3);
		
		em.getTransaction().commit();
		
		System.out.println(conta1.toString());
		System.out.println(mvt1.toString());
		System.out.println(mvt2.toString());
		System.out.println(mvt3.toString());
		//System.out.println(daoMvt.consultar(conta1.getId()).getDescricao());
		
		List<Movimentacao> lista = daoMvt.filtrar(conta1);
		System.out.println(lista);
		
		em.close();
		
	}
*/
}
