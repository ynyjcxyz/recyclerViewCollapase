package com.codixlab.collapsingrecyclerview.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.codixlab.collapsingrecyclerview.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    protected final TextView name;
    protected final ImageView image;
    protected final LinearLayout layoutExpand;
    protected final LinearLayout parent;
    protected final TextView expendable_textView;

    public ViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        image = itemView.findViewById(R.id.image);
        layoutExpand = itemView.findViewById(R.id.layoutExpand);
        parent = itemView.findViewById(R.id.parent);
        expendable_textView = itemView.findViewById(R.id.expendable_textView);
    }
}
