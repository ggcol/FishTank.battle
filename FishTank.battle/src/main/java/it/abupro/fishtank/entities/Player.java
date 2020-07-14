package it.abupro.fishtank.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;
import javax.persistence.Table;

import org.hibernate.Session;

import it.abupro.fishtank.fun.*;

@Entity
@Table(name="player")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="nickname")
	private String nickname;


	public Player(int id, String nickname) {
		setId(id);
		setNickname(nickname);
	} 

	public Player () {} //costruttore vuoto per ass. 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getNickname() {
		HibCon h = new HibCon();
		try (Session sessionR = h.getsFactory().openSession()) {
		nickname = sessionR.createQuery("SELECT nickname FROM Player").getSingleResult().toString();
		//occhio che bisogna necessariamente svuotare la tabella a fine programma!!!
		return nickname;
		}
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	


	
	public void emptyTablePlayer() {
		HibCon h = new HibCon();
		try (Session sessionD = h.getsFactory().openSession()) {
			sessionD.beginTransaction();
			Query queryD = sessionD.createQuery("DELETE FROM Player");
			queryD.executeUpdate();
			System.out.println("ok");
		}
	}
	
	public String toString() {
		return nickname;
	}


}
