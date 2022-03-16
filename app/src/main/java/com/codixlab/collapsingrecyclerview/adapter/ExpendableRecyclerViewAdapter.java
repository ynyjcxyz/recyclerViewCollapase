package com.codixlab.collapsingrecyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.codixlab.collapsingrecyclerview.R;
import com.codixlab.collapsingrecyclerview.model.PersonModel;

import java.util.List;

public class ExpendableRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final Context context;
    private final List<PersonModel> itemList;

    public ExpendableRecyclerViewAdapter(Context context, List<PersonModel> list) {
        this.context = context;
        this.itemList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new ViewHolder
                (LayoutInflater
                        .from(context)
                        .inflate(R.layout.item_expand, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(itemList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

}
