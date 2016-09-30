package com.stash.times.projectstash;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.ArrayList;

class CustomList extends BaseAdapter implements ListAdapter {

    private ArrayList<Model> models;
    private Context context;
    CustomList(ArrayList<Model> models, Context context){
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item, null);
        }
        TextView listItemText = (TextView)view.findViewById(R.id.text);
        listItemText.setText(models.get(position).getText());

        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        imageView.setImageDrawable(models.get(position).getImage());

        if(position == 0){
            Animation animation;
            animation = AnimationUtils.loadAnimation(context,
                    R.anim.righttoleft);
            view.startAnimation(animation);
        }
        if(position == 1){
            Animation animation;
            animation = AnimationUtils.loadAnimation(context,
                    R.anim.lefttoright);
            view.startAnimation(animation);
        }
        if(position == 2){
            Animation animation;
            animation = AnimationUtils.loadAnimation(context,
                    R.anim.top);
            view.startAnimation(animation);
        }

        if(position == 3){
            Animation animation;
            animation = AnimationUtils.loadAnimation(context,
                    R.anim.down);
            view.startAnimation(animation);
        }
        if(position == 4){
            Animation animBounce = AnimationUtils.loadAnimation(context, R.anim.bounce);
            view.startAnimation(animBounce);

        }

        //Handle buttons and add onClickListeners
        Button deleteBtn = (Button)view.findViewById(R.id.delete);
        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                models.remove(position); //or some other task
                notifyDataSetChanged();
            }
        });
        return view;

    }
}
