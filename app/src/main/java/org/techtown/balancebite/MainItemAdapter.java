package org.techtown.balancebite;

import android.content.Context;
import android.service.autofill.UserData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainItemAdapter extends RecyclerView.Adapter<MainItemAdapter.ViewHolder> {
    ArrayList<String> titles = new ArrayList<String>();
    OnMainItemClickListener listener;
    Context context;
    public void addItem(String item){
        titles.add(item);
    }
    public void setItems(ArrayList<String> items){
        this.titles = items;
    }
    public String getItem(int position){
        return titles.get(position);
    }
    public void setItem(int position, String item){ titles.set(position, item); }
    public void setOnItemClickListener(OnMainItemClickListener listener){ this.listener = listener; }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.main_fragment_item, parent, false);
        context = parent.getContext();
        return new ViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = titles.get(position);
        holder.setItem(title);
    }

    @Override
    public int getItemCount() { return titles.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView tvTitle;

        public ViewHolder(@NonNull View itemView, final OnMainItemClickListener listener) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.itemTitle);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(listener != null){
                        listener.onItemClick(ViewHolder.this, view, position);

                    }
                }
            });
        }
        public void setItem(String str){
            tvTitle.setText(str);
        }
    }
}
