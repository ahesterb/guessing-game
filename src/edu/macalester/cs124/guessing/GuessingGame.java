package edu.macalester.cs124.guessing;

import acm.program.ConsoleProgram;

public class GuessingGame extends ConsoleProgram {
    private GameMaster master;
    private Player player;

    public void run() {
        master = new GameMaster(); 
        player = new Player();
        
        boolean playAgain = true;
        while(playAgain) {
            playOneGame();
            playAgain = readBoolean("Play again (y/n)? ", "y", "n");
        }
        println("See you later!");
    }

    private void playOneGame() {
        master.startNewGame();
        player.startNewGame();
        println();
        println("The game master is thinking of a number between 0 and 99.");
        
        while(true) {
            int guess = player.nextGuess();
            println("The player guesses " + guess);
            
            int result = master.submitGuess(guess);
            if(result == GameMaster.LOW) {
                println("The game master says: too low.");
                player.guessWasLow();
            } else if(result == GameMaster.HIGH) {
                println("The game master says: too high.");
                player.guessWasHigh();
            } else {
                println("The game master says: CORRECT!");
                println("The player got it in " + master.getGuessCount() + " guesses.");
                break;
            }
        }
    }
}
