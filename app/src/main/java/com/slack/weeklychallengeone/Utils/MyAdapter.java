package com.slack.weeklychallengeone.Utils;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.slack.weeklychallengeone.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<Model> mArrayList;
    private OnItemClickListener mListner;

    public interface OnItemClickListener {
        void onItemClick(int position);

    }

    public void setOnItemClickListner(OnItemClickListener listner) {
        mListner = listner;
    }

    public MyAdapter(ArrayList<Model> mArrayList) {
        this.mArrayList = mArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new MyViewHolder(view, mListner);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_name.setText(mArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_name;

        MyViewHolder(View view, final OnItemClickListener listener) {
            super(view);

            tv_name = view.findViewById(R.id.tv_name);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (listener != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }

                }
            });
        }

    }


}
