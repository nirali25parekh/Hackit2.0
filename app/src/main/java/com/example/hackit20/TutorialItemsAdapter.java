package com.example.hackit20;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TutorialItemsAdapter extends RecyclerView.Adapter<TutorialItemsAdapter.NotesViewHolder> {

    private List<com.example.hackit20.TutorialItemsModel> tutsModelList;
    private Context context;
    private OnRecyclerItemClick onRecyclerItemClick;

    public TutorialItemsAdapter(List<com.example.hackit20.TutorialItemsModel> tutsModelList, Context context) {
        this.tutsModelList = tutsModelList;
        this.context = context;
    }

    interface OnRecyclerItemClick {
        void onClick(int pos);
    }

    public void setOnRecyclerItemClick(OnRecyclerItemClick onRecyclerItemClick) {
        this.onRecyclerItemClick = onRecyclerItemClick;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotesViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.tutorial_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        holder.headText.setText(tutsModelList.get(position).getHead());
        holder.descText.setText(tutsModelList.get(position).getDesc());
        holder.timeText.setText(tutsModelList.get(position).getTime());

        switch (position) {
            case 1:
                holder.view.setBackgroundColor(context.getResources().getColor(R.color.color2));
                break;
            case 2:
                holder.view.setBackgroundColor(context.getResources().getColor(R.color.color3));
                break;
            case 3:
                holder.view.setBackgroundColor(context.getResources().getColor(R.color.color4));
                break;

            case 4:
                holder.view.setBackgroundColor(context.getResources().getColor(R.color.color5));
                break;

            case 0:

            default:
                holder.view.setBackgroundColor(context.getResources().getColor(R.color.color1));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return tutsModelList.size();
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder {

        private TextView headText, descText, timeText;
        private View view;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            headText = itemView.findViewById(R.id.head1);
            descText = itemView.findViewById(R.id.desc1);
            timeText = itemView.findViewById(R.id.time1);
            view = itemView.findViewById(R.id.view1);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onRecyclerItemClick != null) {
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION) {
                            onRecyclerItemClick.onClick(pos);
                        }
                    }
                }
            });
        }
    }
}