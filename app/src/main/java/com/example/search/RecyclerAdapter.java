package com.example.search;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    //待補充
    private static final String TAG = "RecyclerAdapter";
    int count = 0;
    List<String> stockList;

    public RecyclerAdapter(List<String> stockList) {
        this.stockList = stockList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //待補充
        Log.i(TAG, "onCreateViewHolder" + count++);

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rowCountTextView.setText(String.valueOf(position));
        holder.textView.setText(stockList.get(position));


    }

    @Override
    public int getItemCount() {
        return stockList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView textView, rowCountTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            rowCountTextView = itemView.findViewById(R.id.rowCountTextView);

            itemView.setOnClickListener(this);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    stockList.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    return true;
                }
            });


        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), stockList.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();

        }
    }
}
