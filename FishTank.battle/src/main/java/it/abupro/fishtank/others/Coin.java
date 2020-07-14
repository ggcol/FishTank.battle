package it.abupro.fishtank.others;

public class Coin {

	private int side;
	private String headsOrTails;

	public String flip () {
		side = (int) (Math.random() * 10);
		if (side < 5) {
			headsOrTails = "HEAD";
			System.out.println("Got an HEAD!");
//			System.out.println(side);
		} else {
			headsOrTails = "TAIL";
			System.out.println("Got a TAIL!");
//			System.out.println(side);
		}
		return headsOrTails;
	}
	
	
}


