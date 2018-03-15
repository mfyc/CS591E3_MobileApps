package com.example.cs591e3.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HintFragment extends Fragment {

    private TextView txtFunnyMessage;

    public HintFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_hint, container, false);  //separate me from return statement.
        txtFunnyMessage = (TextView)view.findViewById(R.id.txtFunnyMessage);      //need a chance to do this other stuff,
        return view;

    }

    //Receiving Team
    //It is best practice that this should be accessed via the main activity, not other fragments.
    public void setFunnyMessage(String msg){
        txtFunnyMessage.setText(msg);
    }

}
