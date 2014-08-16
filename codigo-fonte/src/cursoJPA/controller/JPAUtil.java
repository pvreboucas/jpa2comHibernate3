package cursoJPA.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	//singleton
	//EntityManagerFactory = interface de fábrica de conexões
	//faz a leitura de todas as tabelas do banco de dados especificado no persistence.xml
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("controlefinancas"); 
	
	public static EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
}
