package com.click_labs.click_labsworkflow.util.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.click_labs.click_labsworkflow.R;

import java.util.ArrayList;

/**
 * Created by Aman Singh on 08-07-2017.
 */

public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.ViewHolder> {


    Activity activity;
    ArrayList<String> list;
    CustomListSelector getSelectedValue;
    OnListItemSelectedListener onListItemSelectedListener;
    Dialog dialog;

    public CustomListAdapter(Activity activity, OnListItemSelectedListener onListItemSelectedListener, Dialog dialog) {
        this.activity = activity;
        this.onListItemSelectedListener = onListItemSelectedListener;
        this.dialog = dialog;
    }

    public void add(ArrayList<String> list) {

        this.list = list;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = (LayoutInflater.from(parent.getContext())).inflate(R.layout.layout_item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvItemList.setText(list.get(holder.getAdapterPosition()));

        holder.tvItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(activity,list.get(holder.getAdapterPosition()),Toast.LENGTH_LONG).show();
                onListItemSelectedListener.onListItemSelected(holder.getAdapterPosition(), list.get(holder.getAdapterPosition()));
                dialog.dismiss();

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnListItemSelectedListener {
        void onListItemSelected(int position, String listItem);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvItemList;

        public ViewHolder(View itemView) {
            super(itemView);
            tvItemList = (TextView) itemView.findViewById(R.id.tv_list_item);
        }
    }

}
