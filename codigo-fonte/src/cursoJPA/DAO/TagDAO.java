package cursoJPA.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import cursoJPA.bean.Tag;

public class TagDAO {
	
	private EntityManager em;
	private GenericDAO<Tag> dao;
	
	public TagDAO(EntityManager em){
		this.em = em;
		dao = new GenericDAO<Tag>(em, Tag.class);
	}
	
	public Tag cadastrarOuBuscar(String nome){
		String jpql = "SELECT t FROM Tag t WHERE t.nome = :pNome";
		TypedQuery<Tag> query = em.createQuery(jpql, Tag.class);
		query.setParameter("pNome", nome);
		Tag tag = null;
		try{
			tag = query.getSingleResult();
		}catch(NoResultException e){
			tag = new Tag();
			tag.setNome(nome);
			dao.cadastrar(tag);
		}
		
		return tag;
	}
	
	public List<Tag> listar(){
		return dao.listar();
	}
	
	public void excluir(Tag tag){
		dao.excluir(tag);
	}
	
	public Tag consultar(Long id){
		return dao.consultar(id);
	}

}
