package com.click_labs.click_labsworkflow.adapter;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.click_labs.click_labsworkflow.R;
import com.click_labs.click_labsworkflow.activity.HomeActivity;
import com.click_labs.click_labsworkflow.fragment.AddTimesheetFragment;
import com.click_labs.click_labsworkflow.fragment.TimesheetDetailsFragment;
import com.click_labs.click_labsworkflow.model.timesheetresponse.Datum;

import java.util.List;

/**
 * Created by Aman Singh on 13-07-2017.
 */

public class TimeSheetAdapter extends RecyclerView.Adapter<TimeSheetAdapter.MyViewHolder> {


    Activity activity;
    List<Datum> timeSheetList;
    AddTimesheetFragment.OnEditListner onEditListner;
    TimesheetDetailsFragment.OnDeleteListner onDeleteListner;

    public TimeSheetAdapter(Activity activity, List<Datum> timeSheetList, AddTimesheetFragment.OnEditListner onEditListner, TimesheetDetailsFragment.OnDeleteListner onDeleteListner) {
        this.onEditListner = onEditListner;
        this.onDeleteListner = onDeleteListner;
        this.activity = activity;
        this.timeSheetList = timeSheetList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(activity).inflate(R.layout.layout_item_timesheet, parent, false));

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.tvProjectName.setText(timeSheetList.get(holder.getAdapterPosition()).getProjectName());
        holder.tvProjectId.setText(timeSheetList.get(holder.getAdapterPosition()).getSalesOrderTitle());
        holder.tvDate.setText(timeSheetList.get(holder.getAdapterPosition()).getDate());
        holder.tvHoursSpent.setText(timeSheetList.get(holder.getAdapterPosition()).getNoOfHours() + " : " +
                timeSheetList.get(holder.getAdapterPosition()).getMinutes() + " hrs");
        holder.tvWorkDescription.setText(timeSheetList.get(holder.getAdapterPosition()).getComments());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDetails(timeSheetList.get(holder.getAdapterPosition()));
            }
        });

    }

    private void showDetails(Datum timeSheetDetails) {
        FragmentManager fm = ((HomeActivity) activity).getSupportFragmentManager();
        TimesheetDetailsFragment fragment = TimesheetDetailsFragment.newInstance(timeSheetDetails);
        fragment.setOnEditListner(onEditListner);
        fragment.setOnDeleteListner(onDeleteListner);
        fragment.setActivity(activity);
        fragment.show(fm, "timesheet_details");
    }

    @Override
    public int getItemCount() {
        return timeSheetList.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvProjectName, tvProjectId, tvDate, tvHoursSpent, tvWorkDescription;

        public MyViewHolder(View itemView) {
            super(itemView);
            tvProjectName = (TextView) itemView.findViewById(R.id.tv_project_name);
            tvProjectId = (TextView) itemView.findViewById(R.id.tv_project_id);
            tvDate = (TextView) itemView.findViewById(R.id.tv_date);
            tvHoursSpent = (TextView) itemView.findViewById(R.id.tv_hours_spent);
            tvWorkDescription = (TextView) itemView.findViewById(R.id.tv_work_description);
        }
    }
}
