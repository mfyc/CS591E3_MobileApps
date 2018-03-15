package com.example.reda.c9_p23;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.SeekBar;
import android.widget.Toast;

public class SliderControlFragment extends Fragment{
    private SeekBar seek_bar;
    private int value_slide;

    public SliderControlFragment(){
    }

    public interface ControlFragmentListener {
        public void sendTransparency(int trans_value);
    }

    ControlFragmentListener CFL;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        CFL = (ControlFragmentListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflator, ViewGroup container, Bundle saveInstanceState){
        View view = inflator.inflate(R.layout.fragment_control, container,false);

        seek_bar = (SeekBar) view.findViewById(R.id.seekBar);

        seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Keep track of the progress of the seek bar so that it can set your transparency value
                value_slide = i;
                int maximum = seek_bar.getMax();
                Log.e("prog:", Integer.toString(value_slide));
                getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
                CFL.sendTransparency(value_slide);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }



        });

        return view;
    }

}