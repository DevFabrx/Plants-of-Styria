package at.devfabrx.recyclertest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Surface Book on 19.09.2017.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView mLayoutTextView;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        mLayoutTextView = (TextView) itemView.findViewById(R.id.item_layout_textview);

    }
}
