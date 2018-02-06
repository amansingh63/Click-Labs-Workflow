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
import com.click_labs.click_labsworkflow.activity.MilestoneDetailsActivity;
import com.click_labs.click_labsworkflow.model.dashboard.Release;

import java.util.List;

/**
 * Created by Amanjot Singh on 1/19/18.
 */

public class MilestonesAdapter extends RecyclerView.Adapter<MilestonesAdapter.MyViewHolder> {

    private List<Release> mMilestonesDataList;
    private Context mContext;


    public MilestonesAdapter(List<Release> milesatoneDataList) {
        mMilestonesDataList = milesatoneDataList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new MilestonesAdapter.MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_milestones, parent, false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tvReleaseTitle.setText(mMilestonesDataList.get(holder.getAdapterPosition()).getReleaseTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("MILESTONE_DETAILS", mMilestonesDataList.get(holder.getAdapterPosition()));
                Intent milestoneDetails = new Intent(mContext, MilestoneDetailsActivity.class);
                milestoneDetails.putExtras(bundle);
                mContext.startActivity(milestoneDetails);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mMilestonesDataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvReleaseTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvReleaseTitle = itemView.findViewById(R.id.tv_release_title);

        }
    }
}
