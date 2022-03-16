package com.codixlab.collapsingrecyclerview.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.codixlab.collapsingrecyclerview.R;
import com.codixlab.collapsingrecyclerview.model.Person;
import com.codixlab.collapsingrecyclerview.model.PersonModel;
import com.codixlab.collapsingrecyclerview.util.animation.Animations;
import com.squareup.picasso.Picasso;

public class ExpendableRecyclerViewViewHolder extends RecyclerView.ViewHolder {
    protected final TextView name;
    protected final ImageView image;
    protected final LinearLayout layoutExpand;
    protected final LinearLayout parent;
    protected final TextView expendable_textView;

    public ExpendableRecyclerViewViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        image = itemView.findViewById(R.id.image);
        layoutExpand = itemView.findViewById(R.id.layoutExpand);
        parent = itemView.findViewById(R.id.parent);
        expendable_textView = itemView.findViewById(R.id.expendable_textView);
    }

    public void bind(PersonModel personModel, int position) {
        Person person = personModel.getPerson();
        name.setText(person.getName());
        Picasso.get().load(person.getImage()).into(image);
        expendable_textView.setText("This is " + position + " position!");
        bindExpandAction(personModel);
    }

    private void bindExpandAction(PersonModel personModel) {
        parent.setOnClickListener(view -> onItemToggled(personModel,view));
    }

    private void onItemToggled(PersonModel personModel,View view) {
        boolean isExpanded = !personModel.isExpanded();
        Animations.switchBackgroundColor(view, isExpanded);
        if (isExpanded) {
            Animations.expand(layoutExpand);
        } else {
            Animations.collapse(layoutExpand);
        }
        personModel.setExpanded(isExpanded);
    }
}
