package com.example.cs591e3.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameStateFragment extends Fragment {
    private Button btnSendMessage;

    public GameStateFragment() { // Required empty public constructor
    }

    //Need to create an interface to ensure message passing works between fragments.
    public interface GameStateFragmentListener {            //this is just an interface definition.
        public void sendMessage(String msg); //it could live in its own file.  placed here for convenience.
    }

    GameStateFragmentListener GSFL;  //Future reference to an object that implements ControlFragmentListener

    //onAttach gets called when fragment attaches to Main Activity.  This is the right time to instantiate
    //our ControlFragmentListener because we know the Main Activity was successfully created and hooked.
    @Override
    public void onAttach(Context context) {   //The onAttach method, binds the fragment to the owner.  Fragments are hosted by Activities, therefore, context refers to: ____________?
        super.onAttach(context);
        GSFL = (GameStateFragmentListener) context;  //context is a handle to the main activity, let's bind it to our interface.
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_game_state, container, false);

        btnSendMessage = (Button) view.findViewById(R.id.btnSendMessage);

        btnSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                GSFL.sendMessage("HINT: a fruit");
            }
        });

        return view;
    }


    public void onStart() {
        super.onStart();
        View fragmentView = getView();
        TextView gameStateTV = (TextView) fragmentView.findViewById(R.id.state_of_game);
        MainActivity fragmentActivity = (MainActivity) getActivity();
        gameStateTV.setText(fragmentActivity.getGame().currentIncompleteWord());
    }


}
