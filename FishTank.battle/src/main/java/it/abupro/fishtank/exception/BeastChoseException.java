package it.abupro.fishtank.exception;

public class BeastChoseException extends Exception {
	
	public BeastChoseException () {
			}
	
	public String getMessage() {
		return "I deeply apologize but the Monster you chose is not currently available!";
	}

}
