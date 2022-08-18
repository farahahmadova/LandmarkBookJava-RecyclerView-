package com.farahahmadova.landmarkbookjava;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.farahahmadova.landmarkbookjava.databinding.RecyclerviewRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder> {
    ArrayList<Landmark> landmarkList;

    public LandmarkAdapter(ArrayList<Landmark> landmarkList) {
        this.landmarkList = landmarkList;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerviewRowBinding recyclerviewRowBinding=RecyclerviewRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandmarkHolder(recyclerviewRowBinding);
    }

    @SuppressWarnings("Convert2Lambda")
    @Override
    public void onBindViewHolder(@NonNull LandmarkHolder holder, int position) {
        holder.binding.recyclerViewTextView.setText(landmarkList.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(holder.itemView.getContext(),DetailsActivity.class);
                //intent.putExtra("landmark",landmarkList.get(position));
                Singleton singleton=Singleton.getInstance();
                singleton.setSentLandmark(landmarkList.get(position));
                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return landmarkList.size();
    }

    public class LandmarkHolder extends RecyclerView.ViewHolder{
        private RecyclerviewRowBinding binding;


        public LandmarkHolder(RecyclerviewRowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
