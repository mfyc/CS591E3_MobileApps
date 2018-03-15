package com.example.ray.w5_p2;

import android.graphics.drawable.Drawable;
import android.media.Rating;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;

import java.lang.reflect.Field;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrawableFragment extends Fragment {

    ArrayList<Drawable> drawables;  //keeping track of our drawables

    //Boiler Plate Stuff.
    private ImageView imgRateMe;
    RatingBar rb;
    private int currDrawableIndex;

//    public DrawableFragment() {
//        // Required empty public constructor
//    }


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_drawable, container, false);  //comment this out, it would return the default view, without our setup/amendments.
        View v = inflater.inflate(R.layout.fragment_drawable, container, false);   //MUST HAPPEN FIRST, otherwise components don't exist.

        imgRateMe = (ImageView) v.findViewById(R.id.imgRateMe);
        rb = (RatingBar) v.findViewById(R.id.ratingBar);

        //ArrayList Index of Current Drawable.
        currDrawableIndex=0;
        getDrawables();         //Retrieves the drawables we want, ie, prefixed with "animal_"
        imgRateMe.setImageDrawable(null);  //Clearing out the default image from design time.
        changePicture(currDrawableIndex);
        return v;
    }
//setting up navigation call backs.  (Right Buttons)




    //Routine to change the picture in the image view dynamically.
    public void changePicture(int currDrawableIndex){
        imgRateMe.setImageDrawable(drawables.get(currDrawableIndex));
      //  rb.setRating(ratinglist[currDrawableIndex]);
        //note, this is the preferred way of changing images, don't worry about parent viewgroup size changes.
    }

    //Quick and Dirty way to get drawable resources, we prefix with "animal_" to filter out just the ones we want to display.
//REF: http://stackoverflow.com/questions/31921927/how-to-get-all-drawable-resources
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
