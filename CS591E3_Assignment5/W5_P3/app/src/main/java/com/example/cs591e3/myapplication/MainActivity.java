package com.example.cs591e3.myapplication;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


//public class MainActivity extends AppCompatActivity {
public class MainActivity extends Activity implements GameStateFragment.GameStateFragmentListener {

    private Hangman game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (game == null)
            game = new Hangman ( Hangman.DEFAULT_GUESSES );
        setContentView(R.layout.activity_main);
//        TextView status = (TextView) findViewById(R.id.status);
//        status.setText(""+game.getGuessesLeft());

        FragmentManager fragmentManager = getFragmentManager();
        if ( fragmentManager.findFragmentById(R.id.choose_letters_id) == null) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            ChooseLetterFragment fragment = new ChooseLetterFragment();
            transaction.add(R.id.choose_letters_id, fragment);
            transaction.commit();
        }
        if ( fragmentManager.findFragmentById(R.id.hint_id) == null) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            HintFragment fragment = new HintFragment();
            transaction.add(R.id.hint_id, fragment);
            transaction.commit();
        }
    }

    public Hangman getGame() {
        return game;
    }

    public void play(View view){
        EditText input = (EditText) findViewById(R.id.choose_letters_id);
        Editable userText = input.getText();
        if (userText != null && userText.length() > 0) {
            //update number of guesses left
            char letter = userText.charAt(0);
            game.guess(letter);

            //update incomplete word
            FragmentManager fragmentManager = getFragmentManager();
            GameStateFragment gsFragment = (GameStateFragment) fragmentManager.findFragmentById(R.id.game_state_id);
            View gsFragmentView = gsFragment.getView();
            TextView gameStateTV = (TextView) gsFragmentView.findViewById(R.id.state_of_game);
            gameStateTV.setText(game.currentIncompleteWord());

            //clear EditText
            input.setText("");

            int result = game.gameOver();
            if(result != 0) { //game is over
                Context context = getApplicationContext();
                Toast.makeText(context, "You lost!", Toast.LENGTH_LONG).show();
            }

            //delete hint in EditText
            input.setHint("");

        }
    }

    //Honoring our promise to implement sendMessage from "implements ChooseLetterFragment.ControlFragmentListener" above.
    @Override
    public void sendMessage(String msg) {
        HintFragment receivingFragment = (HintFragment)getFragmentManager().findFragmentById(R.id.hint_id);
        receivingFragment.setFunnyMessage(msg);
    }

}

