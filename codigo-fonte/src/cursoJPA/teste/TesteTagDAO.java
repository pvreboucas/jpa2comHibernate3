package cursoJPA.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import cursoJPA.DAO.ContaBancariaDAO;
import cursoJPA.DAO.MovimentacaoDAO;
import cursoJPA.DAO.TagDAO;
import cursoJPA.bean.ContaBancaria;
import cursoJPA.bean.Movimentacao;
import cursoJPA.bean.Tag;
import cursoJPA.bean.TipoMovto;
import cursoJPA.controller.JPAUtil;

public class TesteTagDAO {

	@Test
	public void deveCadastrarOuBuscarTag(){
		EntityManager em = JPAUtil.getEntityManager();
		
		em.getTransaction().begin();
		
		ContaBancariaDAO contaDAO = new ContaBancariaDAO(em);
		TagDAO tagDAO = new TagDAO(em);
		MovimentacaoDAO mvtDAO = new MovimentacaoDAO(em);
		
		ContaBancaria conta = new ContaBancaria();
		//conta = contaDAO.consultar(new Long (8));
		conta.setTitular("Joana");
		conta.setSaldo(new BigDecimal(900.87));
		contaDAO.cadastrar(conta);
		
		Movimentacao mvt = new Movimentacao();
		/*List<Movimentacao> listaMvt = new ArrayList<Movimentacao>();
		listaMvt = conta.getMovimentacoes();
		mvt = listaMvt.get(0);*/
		mvt.setConta(conta);
		mvt.setDescricao("IPVA - 2014");
		mvt.setValor(new BigDecimal(800));
		mvt.setTipo(TipoMovto.SAIDA);
		mvt.setData(Calendar.getInstance());
		
		Tag tag = new Tag();
		tag = tagDAO.cadastrarOuBuscar("carro");
		mvt.getTags().add(tag);
		tag = tagDAO.cadastrarOuBuscar("IPVA");
		mvt.getTags().add(tag);
		tag = tagDAO.cadastrarOuBuscar("2014");
		mvt.getTags().add(tag);
		tag = tagDAO.cadastrarOuBuscar("saida");
		mvt.getTags().add(tag);
		
		mvtDAO.cadastrar(mvt);
		
		Assert.assertNotNull(mvt.getTags());
		
		em.getTransaction().commit();
		em.close();
	}
	
	//@Test
	public void deveRetornarListaDeTags(){
		EntityManager em = JPAUtil.getEntityManager();
		MovimentacaoDAO mvtDAO = new MovimentacaoDAO(em);
		Movimentacao mvt = mvtDAO.consultar(new Long (8));
		for(Tag tag: mvt.getTags()){
			System.out.println(tag.getNome());
		}
		em.close();
	}
	
}
