package br.com.meufotosensor.util;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {
	
	private EntityManagerFactory factory; 
	public EntityManagerProducer() { 
		this.factory = Persistence.createEntityManagerFactory("MeufotosensorPersistence"); 
	} 
	
	@Produces 
	@RequestScoped 
	public EntityManager createEntityManager() { 
		return factory.createEntityManager(); 
	} 
	public void closeEntityManager(@Disposes EntityManager manager) { 
		manager.close(); 
	}

}
