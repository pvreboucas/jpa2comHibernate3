package cursoJPA.teste;

import java.util.ArrayList;
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
import cursoJPA.valueObject.ValorPorMes;

public class TesteMovimentacaoDAO {
	
	
	private List<Movimentacao> deveRetornarMovimentacao(ContaBancaria conta, EntityManager em){
		//EntityManager em = JPAUtil.getEntityManager();
		
		List <Movimentacao> movimentacao = new ArrayList<Movimentacao>();
		MovimentacaoDAO dao = new MovimentacaoDAO(em);
		movimentacao = dao.filtrarConta(conta);
		
		System.out.println("Movimentações da "+conta.toString()+" Retornadas");

		return movimentacao;
	}
	
	private ContaBancaria deveRetornarContaBancaria(Long id, EntityManager em){
		//EntityManager em = JPAUtil.getEntityManager();
		
		ContaBancariaDAO dao = new ContaBancariaDAO(em);
		ContaBancaria conta = new ContaBancaria();
		conta = dao.consultar(id);
		
		//Assert.assertNotNull(conta);
		System.out.println(conta.toString()+" Retornada");
		return conta;
	}
	
	/*@Test
	public void deveListarMovimentacaoPorTitular(){
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();		
		ContaBancaria conta = deveRetornarContaBancaria((long) 8, em);		
		List<Movimentacao> lista = deveRetornarMovimentacao(conta, em);		
		Assert.assertNotNull(lista);
		em.getTransaction().commit();
		System.out.println("Movimentações da "+conta.toString()+": "+lista.toString());
		em.close();
	}*/
	
	@Test
	public void deveListarMesesComMovimentacao(){
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		
		ContaBancaria conta = deveRetornarContaBancaria((long) 8, em);
		MovimentacaoDAO mvtDAO = new MovimentacaoDAO(em);
		List<ValorPorMes> listaEntrada = mvtDAO.listarMesesComMovimentacao(conta, TipoMovto.ENTRADA);
		List<ValorPorMes> listaSaida = mvtDAO.listarMesesComMovimentacao(conta, TipoMovto.SAIDA);
		
		Assert.assertNotNull(listaEntrada);
		Assert.assertNotNull(listaSaida);
		
		em.getTransaction().commit();
		System.out.println("Movimentações de Entrada da Conta"+conta.toString()+": "+listaEntrada.toString());
		System.out.println("Movimentações da Saída da Conta"+conta.toString()+": "+listaSaida.toString());
		em.close();
	}
	
/*	@Test
	public void deveCalcularTotalMovimentacao(){
		
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		
		ContaBancaria conta = deveRetornarContaBancaria((long) 8, em);
		List<Movimentacao> listaEntrada = deveRetornarMovimentacao(conta, em);
		List<Movimentacao> listaSaida = deveRetornarMovimentacao(conta, em);
		MovimentacaoDAO total = new MovimentacaoDAO(em);
		
		listaEntrada = (List<Movimentacao>) total.calcularTotalMovimento(conta, TipoMovto.ENTRADA);
		listaSaida = (List<Movimentacao>) total.calcularTotalMovimento(conta, TipoMovto.SAIDA);
		
		Assert.assertNotNull(listaEntrada);
		Assert.assertNotNull(listaSaida);
		
		em.getTransaction().commit();
		System.out.println("Movimentações de Entrada da Conta"+conta.toString()+": "+listaEntrada);
		System.out.println("Movimentações da Saída da Conta"+conta.toString()+": "+listaSaida);
		em.close();
	}*/
	
}
