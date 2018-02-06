package com.click_labs.click_labsworkflow.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.click_labs.click_labsworkflow.R;
import com.click_labs.click_labsworkflow.model.dashboard.Release;
import com.click_labs.click_labsworkflow.util.DateUtil;

/**
 * Created by Amanjot Singh on 1/22/18.
 */

public class MilestoneDetailsActivity extends AppCompatActivity {

    private TextView tvReleaseTitle, tvReleaseDate, tvReleaseStatus, tvMilestoneDate, tvMilestoneStatus, tvAmount, tvProjected, tvAchievable,
            tvRisk, tvRaised, tvReceived, tvNotes;
    private Release mMilestoneData;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milestones_detail);
        init();
        if (getIntent().hasExtra("MILESTONE_DETAILS")) {
            mMilestoneData = getIntent().getParcelableExtra("MILESTONE_DETAILS");
            setDataonView(mMilestoneData);
        }
    }

    private void setDataonView(Release milestoneDetails) {
        tvReleaseTitle.setText(milestoneDetails.getReleaseTitle() != null ? milestoneDetails.getReleaseTitle() : "N/A");
        tvReleaseDate.setText(milestoneDetails.getReleaseDate() != null ? DateUtil.displayDateTimeFromHit(milestoneDetails.getReleaseDate(), "MM/dd/yyyy") : "N/A");
        tvReleaseStatus.setText(milestoneDetails.getReleaseStatus() != null ? milestoneDetails.getReleaseStatus() : "N/A");
        tvMilestoneDate.setText(milestoneDetails.getMilestoneDate() != null ? DateUtil.displayDateTimeFromHit(milestoneDetails.getMilestoneDate(), "MM/dd/yyyy") : "N/A");
        tvMilestoneStatus.setText(milestoneDetails.getMilestoneStatus() != null ? milestoneDetails.getMilestoneStatus() : "N/A");
        tvAmount.setText("USD " + milestoneDetails.getAmount());
        tvProjected.setText("USD " + milestoneDetails.getFinancialStatus().getProjected());
        tvAchievable.setText("USD " + milestoneDetails.getFinancialStatus().getAchievable());
        tvRisk.setText("USD " + milestoneDetails.getFinancialStatus().getRisk());
        tvRaised.setText("USD " + milestoneDetails.getRaised());
        tvReceived.setText("USD " + milestoneDetails.getReceived());
        tvNotes.setText("N/A");

    }


    private void init() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Milestone Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        tvReleaseTitle = findViewById(R.id.tv_release_title);
        tvReleaseDate = findViewById(R.id.tv_release_date);
        tvReleaseStatus = findViewById(R.id.tv_release_status);
        tvMilestoneDate = findViewById(R.id.tv_milestone_date);
        tvMilestoneStatus = findViewById(R.id.tv_milestone_status);
        tvAmount = findViewById(R.id.tv_amount);
        tvProjected = findViewById(R.id.tv_projected);
        tvAchievable = findViewById(R.id.tv_achievable);
        tvRisk = findViewById(R.id.tv_risk);
        tvRaised = findViewById(R.id.tv_raised);
        tvReceived = findViewById(R.id.tv_received);
        tvNotes = findViewById(R.id.tv_notes);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
