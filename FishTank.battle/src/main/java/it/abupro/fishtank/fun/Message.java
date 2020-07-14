package it.abupro.fishtank.fun;

import java.util.Scanner;

import it.abupro.fishtank.entities.*;

public class Message {

	public String start () {
		String start = "Hello human. \nWelcome to Miskatonic University... \n"
				+ "I assume is not your first time here, ain't it right? \n"
				+ "Well, here's some stuff to do firstly... \nMay "
				+ "you please sign in with your nickname?";
		return start;
	}

	public String playerName() {
		Player p1 = new Player();
		String playerName = "Thanks human. So... "+p1.getNickname()+" is the way you are used to be "
				+ "called from the other exemples of your race... Fine. ";
		return playerName;
	}

	public String beforeChoice() {
		String beforeChoice = "I am very proud to show you our unusual Beast Generator! \n"
				+ "It's been programmed in order to manage two Fish tanks \nIn the firs one it can spawns "
				+ "two of the Greater Fishes ever existed... \nin the second one it is going to spawns "
				+ "two of the most legendary Sea Monster in time. \nThe choice... is up to you!"
				+ "\nkeep in mind that you can only choose one kind of Beast! \n"
				+ "Type in 'GreatFish' or 'SeaMonster' and press enter in order to confirm your choice!";
		return beforeChoice;
	}

	public String afterChoice(String select) {
		String afterChoice = "Well, you chose "+select;
		return afterChoice;
	}

	public String beforeFlip() {
		String beforeFlip = "Now our super-skilled-self-automated-system will flip a coin for you! \n"
				+ "Have you ever played HEADS or TAILS? \nYeah... what I guessed... Time to choose: Head or Tail?";
		return beforeFlip;
	}
	
	public String coinFlipping() {
		String coinFlipping = "Flipping the coin... \n. \n. \n.";
		return coinFlipping;
	}
	
	public String yF () {
		String yF = "Well... you move first!";
		return yF;
	}
	
	public String mF() {
		String mF = "Sorry mate... machine moves first!";
		return mF;
	}

	
	
	//chiude classe
}
