package com.example.jt1300.hw6_p2;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag extends Fragment {

    public Frag() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {   //The onAttach method, binds the fragment to the owner.  Fragments are hosted by Activities, therefore, context refers to: ____________?
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //initializes the fragment

        final View view = inflater.inflate(R.layout.fragment_, container, false);
        // Inflate the layout for this fragment
        TextView TV = (TextView)view.findViewById(R.id.tv);
        EditText ET = (EditText)view.findViewById(R.id.et);
        final CheckBox cb1 = (CheckBox)view.findViewById(R.id.checkBox);
        final CheckBox cb2 = (CheckBox)view.findViewById(R.id.checkBox2);
        final CheckBox cb3 = (CheckBox)view.findViewById(R.id.checkBox3);
        return view;
    }

}
