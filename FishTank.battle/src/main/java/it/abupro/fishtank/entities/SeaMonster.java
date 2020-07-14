package it.abupro.fishtank.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SeaMonster")
public class SeaMonster extends Beast {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name ="atk")
	private int atk;
	@Column (name="def")
	private int def;
	@Column(name ="hp")
	private int hp;

	public SeaMonster () {} //costruttore vuoto per ass. stat

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void generateStat() {
		setAtk((int)(Math.random()*100)+1);
		setDef((int)(Math.random()*100)+1);
		setHp((int) ((Math.random()*10)+1));
	}
	
	public String toString() { //to string
		return name + " atk: "+atk+" def: "+def+" hp: "+hp;
	}
}
