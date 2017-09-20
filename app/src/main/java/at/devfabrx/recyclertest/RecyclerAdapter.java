package at.devfabrx.recyclertest;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Surface Book on 19.09.2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    ArrayList<String> data;

    public RecyclerAdapter(ArrayList data) {
        this.data = data;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View itemView = inflater.inflate(R.layout.recycler_item_layout, parent, false);

        return new RecyclerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.mLayoutTextView.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        Log.d("RecyclerAdapter","called getItemCount");
        return data.size();
    }
}
