package edu.macalester.cs124.guessing;

import java.util.Random;

public class Player {
	private Random rand = new Random();
	private int guess;
	private int lowBound;
	private int highBound;
	
	public void startNewGame() {
		guess = 0;
		lowBound = 0;
		highBound = 100;
	}
	
	public int nextGuess() {
		int range = highBound - lowBound;
		guess = (rand.nextInt(range) + lowBound);
		return guess;
	}
	
	public void guessWasLow() {
		lowBound = guess;
	}
	
	public void guessWasHigh() {
		highBound = guess;
	}
	
}
