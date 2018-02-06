package com.click_labs.click_labsworkflow.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.click_labs.click_labsworkflow.R;
import com.click_labs.click_labsworkflow.activity.ProjectDetailsActivity;
import com.click_labs.click_labsworkflow.model.dashboard.Datum;

import java.util.List;

/**
 * Created by Amanjot Singh on 1/19/18.
 */

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.MyViewHolder> {

    private List<Datum> mDmDashobardList;
    private Context mContext;


    public DashboardAdapter(List<Datum> pmDashobardList) {
        mDmDashobardList = pmDashobardList;
    }

    public void addData(List<Datum> pmDashobardList) {
        mDmDashobardList.addAll(pmDashobardList);
        notifyDataSetChanged();
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new DashboardAdapter.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_pm_project_details, parent, false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tvProjectName.setText(mDmDashobardList.get(holder.getAdapterPosition()).getProjectName());
        holder.tvStage.setText(mDmDashobardList.get(holder.getAdapterPosition()).getCurrentStage() != null ? mDmDashobardList.get(holder.getAdapterPosition()).getCurrentStage() : "NA");
        holder.tvPlannedCost.setText(String.valueOf(mDmDashobardList.get(holder.getAdapterPosition()).getPlannedAmount() != 0 ? mDmDashobardList.get(holder.getAdapterPosition()).getPlannedAmount() : "NA"));
        holder.tvActualCost.setText(String.valueOf(mDmDashobardList.get(holder.getAdapterPosition()).getActualCost() != 0 ? mDmDashobardList.get(holder.getAdapterPosition()).getActualCost() : "NA"));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("DETAILS", mDmDashobardList.get(holder.getAdapterPosition()));
                Intent projectDetails = new Intent(mContext, ProjectDetailsActivity.class);
                projectDetails.putExtras(bundle);
                mContext.startActivity(projectDetails);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDmDashobardList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvProjectName, tvStage, tvPlannedCost, tvActualCost;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvProjectName = itemView.findViewById(R.id.tv_project_name);
            tvStage = itemView.findViewById(R.id.tv_stage);
            tvPlannedCost = itemView.findViewById(R.id.tv_planned_cost);
            tvActualCost = itemView.findViewById(R.id.tv_actual_cost);


        }
    }
}
