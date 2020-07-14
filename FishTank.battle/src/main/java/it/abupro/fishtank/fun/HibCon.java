package it.abupro.fishtank.fun;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibCon {
	
	private SessionFactory sFactory;
	
	
	public void setsFactory(SessionFactory sFactory) {
		this.sFactory = sFactory;
	}

	public SessionFactory getsFactory() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sFactory = metadata.getSessionFactoryBuilder().build();
		return sFactory;
	}
	/*
	 * Necessario uno Schema "FishTank" con tre Table
	 * Table 1: Player
	 * 		-id
	 * 		-nickname
	 * Table 2: GreatFish
	 * 		-id
	 * 		-name
	 * 		-atk
	 * 		-def
	 * 		-hp
	 *Table 3: SeaMonster
	 * 		-id
	 * 		-name
	 * 		-atk
	 * 		-def
	 * 		-hp
	 */
}
