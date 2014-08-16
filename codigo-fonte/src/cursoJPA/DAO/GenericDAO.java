package cursoJPA.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class GenericDAO<T> {
	
	private EntityManager em;
	private Class<T> classe;
	
	public GenericDAO(EntityManager em, Class<T> classe){
		this.em = em;
		this.classe = classe;
	}
	
	public void cadastrar(T t){
		em.persist(t);
	}
	
	public List<T> listar(){
		String jpql = "SELECT c FROM "+classe.getName()+"c";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}
	
	public void excluir(T t){
		em.remove(em.merge(t));
	}
	
	public T consultar(Long id){
		return em.getReference(classe, id);
	}


}
