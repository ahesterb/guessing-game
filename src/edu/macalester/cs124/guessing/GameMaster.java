package edu.macalester.cs124.guessing;

import java.util.Random;


public class GameMaster {
	public static final int HIGH = -1;
	public static final int LOW = -2;
	public static final int CORRECT = -3;
	private Random rand = new Random();
	private int answer;
	private int total;
	
	public void startNewGame() {
		answer = rand.nextInt(100);
		total = 0;
	}
	
	public int submitGuess(int guess) {
		total++;
		if(guess < answer) {
			return GameMaster.LOW;
		} else if(guess > answer) {
			return GameMaster.HIGH;
		} else {
			return GameMaster.CORRECT;
		}
	}
	
	public int getGuessCount() {
		return total;
	}
	

}
