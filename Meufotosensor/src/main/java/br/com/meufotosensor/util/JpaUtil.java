package br.com.meufotosensor.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static EntityManagerFactory factory; 
	
	static { 
		factory = Persistence.createEntityManagerFactory( 
				"MeufotosensorPersistence");
	}
}
