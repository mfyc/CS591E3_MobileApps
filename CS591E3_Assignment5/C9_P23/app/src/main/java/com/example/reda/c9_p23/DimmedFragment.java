package com.example.reda.c9_p23;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.os.Bundle;
import android.widget.Toast;

public class DimmedFragment extends Fragment{
    public DimmedFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflator, ViewGroup container, Bundle saveInstanceState){
        View view = inflator.inflate(R.layout.fragment_dimmed, container,false);
        return view;
    }


    //Change the transparency of the view by altering the alpha value which runs between 0 and 1
    public void setTransparency(int trans_value){
        //Since 1s the opaquest values for alpha value, subtract 1 so that the more you slide,
        //the more transparent the view becomes
        double alpha_value = 1.0 - (trans_value/100.0);
        float value = (float) alpha_value;
        Log.e("alpha:", Float.toString(value));
        getView().setAlpha(value);
    }
}
