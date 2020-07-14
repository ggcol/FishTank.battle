package it.abupro.fishtank.fun;

import java.util.NoSuchElementException;
import java.util.*;

import org.hibernate.Session;

import it.abupro.fishtank.entities.*;
import it.abupro.fishtank.exception.BeastChoseException;
import it.abupro.fishtank.fun.*;
import it.abupro.fishtank.others.Coin;

public class Action {

	Impl implA = new Impl();
	Message mesA = new Message();
	HibCon h = new HibCon();


	public void start (String name) {

		Player p1 = new Player();
		p1.setNickname(name);
		try (Session sessionC = h.getsFactory().openSession()) {
			sessionC.beginTransaction();
			sessionC.save(p1);
			sessionC.getTransaction().commit();
		}
		System.out.println(mesA.playerName());
	}


	public void selectTeam(String select) {
		try {
			if (select.equalsIgnoreCase("greatfish") || select.equalsIgnoreCase("seamonster")) {
				implA.teamCreate(select);
				implA.teamRead(select);
			} else {
				throw new BeastChoseException();
			}
		} catch (BeastChoseException bCm) {
			bCm.printStackTrace();
		}
	}


	public String whosFirst(String hotChoice) {
		Coin c1 = new Coin();
		mesA.coinFlipping();
		String result = c1.flip();
		if (hotChoice.toLowerCase().equals(result)) {
			System.out.println(mesA.yF());
		} else {
			System.out.println(mesA.mF());
		}
		return result;

	}



	//chiude classe

}
