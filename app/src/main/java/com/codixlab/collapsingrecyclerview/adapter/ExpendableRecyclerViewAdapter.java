package com.codixlab.collapsingrecyclerview.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codixlab.collapsingrecyclerview.R;
import com.codixlab.collapsingrecyclerview.model.Person;
import com.codixlab.collapsingrecyclerview.util.animation.Animations;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ExpendableRecyclerViewAdapter extends RecyclerView.Adapter<ExpendableRecyclerViewAdapter.ViewHolder> {

    Context context;
    List<Person> personList;

    public ExpendableRecyclerViewAdapter(Context context, List<Person> list) {

        this.context = context;
        this.personList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_expand, viewGroup,false));

    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, @SuppressLint("RecyclerView")  int position) {

        holder.name.setText(personList.get(position).getName());

        Picasso.get().load(personList.get(position).getImage()).into(holder.image);

        holder.viewMoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean show = toggleLayout(!personList.get(position).isExpanded(), v, holder.layoutExpand);
                personList.get(position).setExpanded(show);
            }
        });

    }

    private boolean toggleLayout(boolean isExpanded, View v, LinearLayout layoutExpand) {
        Animations.toggleArrow(v, isExpanded);
        if (isExpanded) {
            Animations.expand(layoutExpand);
        } else {
            Animations.collapse(layoutExpand);
        }
        return isExpanded;

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView name;
        private final ImageButton viewMoreBtn;
        private final ImageView image;
        private final LinearLayout layoutExpand;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            viewMoreBtn = itemView.findViewById(R.id.viewMoreBtn);
            image = itemView.findViewById(R.id.image);
            layoutExpand = itemView.findViewById(R.id.layoutExpand);
        }
    }
}
