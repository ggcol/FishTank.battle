package it.abupro.fishtank;

import java.util.Scanner;

import it.abupro.fishtank.entities.*;
import it.abupro.fishtank.fun.*;
import it.abupro.fishtank.others.*;

public class Main {

	public static void main(String[] args) {

		Impl impl = new Impl();
		Coin coin = new Coin();
		Player p1 = new Player();
		Action a = new Action();
		Message m = new Message();
		
		impl.emptyAllTables();
		Scanner s = new Scanner(System.in);
		
		System.out.println(m.start());
		String name = s.nextLine();
		a.start(name);
		
		System.out.println(m.beforeChoice());
		String choice = s.nextLine();
		System.out.println(m.afterChoice(choice));
		a.selectTeam(choice);
		
//		System.out.println(m.beforeFlip());
//		String hOt = s.nextLine();
//		a.whosFirst(hOt);
//		
		
//		do {
//		
//		
//		
//	} while ();
		s.close();
	}
}
