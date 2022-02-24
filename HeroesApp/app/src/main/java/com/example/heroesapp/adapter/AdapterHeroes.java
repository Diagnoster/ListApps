package com.example.heroesapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.heroesapp.R;
import com.example.heroesapp.model.Hero;

import java.util.List;

public class AdapterHeroes extends RecyclerView.Adapter<AdapterHeroes.MyViewHolder> {

    private List<Hero> listHeroes;

    public AdapterHeroes(List<Hero> list) {
        this.listHeroes = list;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, owner;
        ImageView img;

        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.textViewOwner);
            owner = view.findViewById(R.id.textViewName);
            img = view.findViewById(R.id.imageViewHero);

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list_heroes, parent, false);

        return new MyViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Hero obj =  listHeroes.get(position);
        holder.name.setText(obj.getName());
        holder.owner.setText(obj.getOwner());
        holder.img.setImageResource(obj.getImg());
    }

    @Override
    public int getItemCount() {
        return listHeroes.size();

    }


}
