package com.stash.times.projectstash;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

/**
 * Created by Ashish on 29-09-2016.
 */

class Model {
    private String text;
    private Drawable image;
    private Context context;
    Model(Context context){
        this.context = context;
    }

    String getText() {
        return text;
    }

    void setText(String text) {
        this.text = text;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    ArrayList<Model> getData(){
        ArrayList<Model> models=new ArrayList<>();
        String[] subNames = { "Item 1" , "Item 2","Item 3","Item 4","Item 5"};
        for (String subName : subNames) {
            Model model = new Model(context);
            model.setText(subName);

            Drawable d = context.getResources().getDrawable(R.mipmap.ic_launcher);
            model.setImage(d);
            models.add(model);
        }
        return models;

    }


}
