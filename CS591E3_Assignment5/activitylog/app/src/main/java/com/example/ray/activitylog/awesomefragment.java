package com.example.ray.activitylog;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class awesomefragment extends Fragment {


    public awesomefragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i(TAG, "fragment is onCreateView");
        return inflater.inflate(R.layout.fragment_awesomefragment2, container, false);
    }

    @Override
    public void onAttach(Context context) {

        Log.i(TAG, "fragment is onCreate");
        super.onAttach(context);
    }
    @Override
    public  void onCreate(Bundle savedInstantceState){
        Log.i(TAG, "fragment is onCreate");
        super.onCreate(savedInstantceState);
    }
    @Override
    public  void onActivityCreated(Bundle savedInstantceState){
        Log.i(TAG, "fragment activity Created");
        super.onActivityCreated(savedInstantceState);
    }
    @Override
    public  void onStart(){
        Log.i(TAG, "fragment is on start");
        super.onStart();
    }
    @Override
    public  void onResume(){
        Log.i(TAG, "fragment on Resume");
        super.onResume();
    }
}
