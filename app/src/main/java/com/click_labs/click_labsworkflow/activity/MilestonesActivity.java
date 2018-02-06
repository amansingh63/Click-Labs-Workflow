package com.click_labs.click_labsworkflow.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.click_labs.click_labsworkflow.R;
import com.click_labs.click_labsworkflow.adapter.MilestonesAdapter;
import com.click_labs.click_labsworkflow.model.dashboard.Release;

import java.util.ArrayList;

import retrofit2.Call;

public class MilestonesActivity extends AppCompatActivity {

    RecyclerView rvMilestones;
    private Call retrofitCall;
    private Toolbar toolbar;
    private ArrayList<Release> releaseDataList;
    private MilestonesAdapter milestonesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_milestones);
        init();
        releaseDataList = getIntent().getParcelableArrayListExtra("RELEASE_LIST");
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        milestonesAdapter = new MilestonesAdapter(releaseDataList);
        rvMilestones.setLayoutManager(new LinearLayoutManager(MilestonesActivity.this));
        rvMilestones.setAdapter(milestonesAdapter);
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Milestones");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        rvMilestones = findViewById(R.id.rvMileStone);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
