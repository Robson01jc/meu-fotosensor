package br.com.meufotosensor.dao;

import javax.persistence.Persistence;

public class CriaTabelas {
	
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("MeufotosensorPersistence");
	}
}