package it.abupro.fishtank.fun;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.Session;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import it.abupro.fishtank.entities.*;
import it.abupro.fishtank.fun.*;

public class Impl {

	public Impl () {}

	
	public String teamCreate (String selectImpl) {

		HibCon h = new HibCon();
		
			System.out.println("Now we are going to spawn your chosen Beasts...");
			System.out.println("Just type in the name of the beast when requested in order to invoke it!");
			
		if (selectImpl.equalsIgnoreCase("greatfish")) {
			GreatFish g1 = new GreatFish();
			GreatFish g2 = new GreatFish();
			
			g1.generateStat();
			g2.generateStat();
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Insert now the name of the first Great Fish you wish to invoke: ");
			g1.setName(scanner.nextLine().toUpperCase());
			System.out.println("Great, nice choice! You may now go for the second one: ");
			g2.setName(scanner.nextLine().toUpperCase());
			scanner.close();
			
			SeaMonster sNPC1 = new SeaMonster();
			SeaMonster sNPC2 = new SeaMonster();
			sNPC1.generateStat();
			sNPC2.generateStat();
			sNPC1.setName("KRAKEN");
			sNPC2.setName("LEVIATHAN");


			try (Session sessionC = h.getsFactory().openSession()) {
				sessionC.beginTransaction();
				sessionC.save(g1);
				sessionC.save(g2);
				sessionC.save(sNPC1);
				sessionC.save(sNPC2);
				sessionC.getTransaction().commit();
			}
			
			
		} else if (selectImpl.equalsIgnoreCase("seamonster")) {
			SeaMonster s1 = new SeaMonster();
			SeaMonster s2 = new SeaMonster();

			s1.generateStat();
			s2.generateStat();
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Insert now the name of the first Sea Monster you wish to invoke: ");
			s1.setName(scanner.nextLine().toUpperCase());
			System.out.println("Great, nice choice! You may now go for the second one: ");
			s2.setName(scanner.nextLine().toUpperCase());
			scanner.close();
			
			GreatFish gNPC1 = new GreatFish();
			GreatFish gNPC2 = new GreatFish();
			gNPC1.generateStat();
			gNPC2.generateStat();
			gNPC1.setName("MEGALODON");
			gNPC2.setName("BLUE WHALE");


			try (Session sessionC = h.getsFactory().openSession()) {
				sessionC.beginTransaction();
				sessionC.save(s1);
				sessionC.save(s2);
				sessionC.save(gNPC1);
				sessionC.save(gNPC2);
				sessionC.getTransaction().commit();
			}
			
		}
		return selectImpl;
	}

	
	@SuppressWarnings("unchecked")
	public String teamRead (String selectImpl) {
		HibCon h = new HibCon();


		if (selectImpl.equalsIgnoreCase("greatfish")) {
			List<GreatFish> lGf = new LinkedList<GreatFish>();
			List<SeaMonster> lSmNPC = new LinkedList<SeaMonster>();
			
			try (Session sessionR = h.getsFactory().openSession()) {
				lGf = sessionR.createQuery("FROM GreatFish").getResultList();
				System.out.println("You spawned these Greatest Fishes: ");
				System.out.println(lGf);
				
				lSmNPC = sessionR.createQuery("FROM SeaMonster").getResultList();
				System.out.println("Those fearsome Sea Monsters are going to fight against you...");
				System.out.println(lSmNPC);
			}
			
		} else if (selectImpl.equalsIgnoreCase("seamonster")) {
			List<SeaMonster> lSm = new LinkedList<SeaMonster>();
			List<GreatFish> lGfNPC = new LinkedList<GreatFish>();
			
			try (Session sessionR = h.getsFactory().openSession()) {
				lSm = sessionR.createQuery("FROM SeaMonster").getResultList();
				System.out.println("You spawned these fearsome Sea Monsters: ");
				System.out.println(lSm);
				
				lGfNPC = sessionR.createQuery("FROM GreatFish").getResultList();
				System.out.println("Those are the Greates Fishes that are going to fight against you...");
				System.out.println(lGfNPC);
			}
		}
		
		return selectImpl;
	}
	
	
	public void emptyAllTables() {
		HibCon h = new HibCon();
		try (Session sessionD = h.getsFactory().openSession()) {
			sessionD.beginTransaction();
			Query queryDP = sessionD.createQuery("DELETE FROM Player");
			Query queryDGF = sessionD.createQuery("DELETE FROM GreatFish");
			Query queryDSM = sessionD.createQuery("DELETE FROM SeaMonster");
			queryDP.executeUpdate();
			queryDGF.executeUpdate();
			queryDSM.executeUpdate();
			
			System.out.println("ok");
		}
	}

	//chiude classe
}
