package com.example.orizilka.app_ex1;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;





public class ListAdapter extends RecyclerView.Adapter {

    public String[] myDataSet;
    public Drawable[] myImageSet;

    public ListAdapter(String[] data, Drawable[] charImages) {
        myDataSet = data;
        myImageSet = charImages;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private View myView;

        public MyViewHolder(View view) {
            super(view);
            myView = view;
        }
    }
//    layoutmanager
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_new_view_holder, parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        String textForDisplay = myDataSet[position];
        Drawable imageForDisplay = myImageSet[position];
        TextView text = ((MyViewHolder)holder).myView.findViewById(R.id.characterName);
        text.setText(textForDisplay);
        ImageView image = ((MyViewHolder)holder).myView.findViewById(R.id.characterImage);
        image.setImageDrawable(imageForDisplay);
    }

    @Override
    public int getItemCount() {
        return myDataSet.length;
    }
}
