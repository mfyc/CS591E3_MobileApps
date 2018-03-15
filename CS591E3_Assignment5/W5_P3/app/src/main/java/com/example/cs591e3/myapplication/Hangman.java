package com.example.cs591e3.myapplication;

import java.util.Random;

public class Hangman implements WordGame {
    public static int DEFAULT_GUESSES = 6;
    private String [] words = {"apple","orange","watermelon","banana","cherry"};
    private String word;
    private boolean [] indexesGuessed;
    private int guessesAllowed;
    private int guessesLeft;

    public Hangman (int guesses) {
        if (guesses > 0) {
            guessesAllowed = guesses;
        } else {
            guessesAllowed = DEFAULT_GUESSES;
        }
        guessesLeft = guessesAllowed;
        Random random = new Random();
        int index = random.nextInt(words.length);
        word = words[index];
        indexesGuessed = new boolean[word.length()];
    }

    public int getGuessesAllowed() {
        return guessesAllowed;
    }

    public int getGuessesLeft() {
        return guessesLeft;
    }

    public void guess (char c) {
        boolean goodGuess = false;
        for (int i=0; i < word.length();i++) {
            if (!indexesGuessed[i] && c == word.charAt(i)) {
                indexesGuessed[i] = true;
                goodGuess = true;
            }
        }
        if (!goodGuess)
            guessesLeft--;
    }

    public String currentIncompleteWord() {
        String guess = "";
        for (int i=0; i < word.length();i++) {
            if (indexesGuessed[i]) {
                guess += word.charAt(i) + " ";
            } else {
                guess += "_ ";
            }
        }
        return guess;
    }

    public int gameOver() {
        boolean won = true;
        for (int i=0; i < indexesGuessed.length; i++) {
            if (indexesGuessed[i] == false ) {
                won = false;
                break;
            }
        }
        if (won) { //won the game
            return 1;
        } else if (guessesLeft == 0) { //lost the game
            return -1;
        } else { //game not over yet
            return 0;
        }
    }
}
