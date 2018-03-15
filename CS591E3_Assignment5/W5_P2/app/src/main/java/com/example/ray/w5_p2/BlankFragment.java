package com.example.ray.w5_p2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.lang.reflect.Field;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    ArrayList<Drawable> drawables;  //keeping track of our drawables
    private int currDrawableIndex;  //keeping track of which drawable is currently displayed.


    //Boiler Plate Stuff.
    private Button btnRight;
    private Button btnLeft;

    public interface ControlFragmentListener {
        void changePicture(int currDrawableIndex);
    }

    ControlFragmentListener CFL;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        CFL = (ControlFragmentListener) context;
    }


//    public DrawableFragment() {
//        // Required empty public constructor
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_drawable, container, false);  //comment this out, it would return the default view, without our setup/amendments.
        View v = inflater.inflate(R.layout.fragment_blank, container, false);   //MUST HAPPEN FIRST, otherwise components don't exist.
        getDrawables();


        btnLeft = (Button) v.findViewById(R.id.btnLeft);
        btnRight = (Button) v.findViewById(R.id.btnRight);


//setting up navigation call backs.  (Left Buttons)
        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currDrawableIndex == drawables.size() - 1)
                    currDrawableIndex = 0;
                else
                    currDrawableIndex++;
                CFL.changePicture(currDrawableIndex);
            }
        });


        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currDrawableIndex == drawables.size() - 1)
                    currDrawableIndex = 0;
                else
                    currDrawableIndex++;
                CFL.changePicture(currDrawableIndex);
            }
        });

        return v;   //returns the view, with our must happen last, Why? A: ____________
    }

    public void getDrawables() {
        Field[] drawablesFields = com.example.ray.w5_p2.R.drawable.class.getFields();  //getting array of ALL drawables.
        drawables = new ArrayList<>();  //we prefer an ArrayList, to store the drawables we are interested in.  Why ArrayList and not an Array here? A: _________

        String fieldName;
        for (Field field : drawablesFields) {   //1. Looping over the Array of All Drawables...
            try {
                fieldName = field.getName();    //2. Identifying the Drawables Name, eg, "animal_bewildered_monkey"
                Log.i("LOG_TAG", "com.your.project.R.drawable." + fieldName);
                if (fieldName.startsWith("animals_"))  //3. Adding drawable resources that have our prefix, specifically "animal_".
                    drawables.add(getResources().getDrawable(field.getInt(null)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
    //Routine to change the picture in the image view dynamically.


    //Quick and Dirty way to get drawable resources, we prefix with "animal_" to filter out just the ones we want to display.
//REF: http://stackoverflow.com/questions/31921927/how-to-get-all-drawable-resources



