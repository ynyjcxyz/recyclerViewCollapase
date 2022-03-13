package com.codixlab.collapsingrecyclerview.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.codixlab.collapsingrecyclerview.R;
import com.codixlab.collapsingrecyclerview.model.Person;
import com.codixlab.collapsingrecyclerview.util.animation.Animations;
import com.squareup.picasso.Picasso;
import java.util.List;

public class ExpendableRecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    Context context;
    List<Person> itemList;
    List<Boolean> statusList;

    public ExpendableRecyclerViewAdapter(Context context, List<Person> list) {
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

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.name.setText(itemList.get(position).getName());

        Picasso.get().load(itemList.get(position).getImage()).into(holder.image);

        holder.expendable_textView.setText("This is " + position + " position!");

        holder.parent.setOnClickListener(view -> {
            boolean show = toggleLayout(!itemList.get(position).isExpanded(), view, holder.layoutExpand);
            itemList.get(position).setExpanded(show);
        });
    }

    private boolean toggleLayout(boolean isExpanded, View v, LinearLayout layoutExpand) {
        Animations.switchBackgroundColor(v, isExpanded);
        if (isExpanded) {
            Animations.expand(layoutExpand);
        } else {
            Animations.collapse(layoutExpand);
        }
        return isExpanded;
    }

    @Override
    public int getItemCount() {
        if (itemList != null) {
            return itemList.size();
        }
        return 0;
    }

}
