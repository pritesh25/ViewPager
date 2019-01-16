package com.herba.sdk.myapplication.viewpager.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.herba.sdk.myapplication.R;

import java.util.List;

public class CameraAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> list;
    private Context  context;

    public CameraAdapter(Context context,List<String> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_camera,viewGroup,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder instanceof  CustomViewHolder)
        {
            CustomViewHolder holder = (CustomViewHolder)viewHolder;
            holder.name.setText(list.get(i));
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        public CustomViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name);
        }
    }
}
