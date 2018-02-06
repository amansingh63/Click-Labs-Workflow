package com.click_labs.click_labsworkflow.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.click_labs.click_labsworkflow.R;
import com.click_labs.click_labsworkflow.model.dashboard.Datum;
import com.click_labs.click_labsworkflow.util.DateUtil;


public class ProjectDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private Datum projectData;
    private Toolbar toolbar;

    private TextView tvProjectName, tvKickOffDate, tvStage, tvBookValue, tvPlannedCost, tvActualCost, tvClientNAme, tvProjectManager, tvTeam, tvBusinessCategory,
            tvPlannedCompletionDate, tvRaisedAmount, tvOutstanding, tvEntryDate, tvProductionReady, tvSalesOrderId;
    private AppCompatButton btnMilestones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_details);
        init();
        if (getIntent().hasExtra("DETAILS")) {
            projectData = getIntent().getParcelableExtra("DETAILS");
            setDataOnView(projectData);
        }

    }

    private void setDataOnView(Datum projectData) {

        tvProjectName.setText(projectData.getProjectName() != null ? projectData.getProjectName() : "N/A");
        tvKickOffDate.setText(projectData.getKickOffDate() != null ? DateUtil.displayDateTimeFromHit(projectData.getKickOffDate(), "MM/dd/yyyy") : "N/A");
        tvStage.setText(projectData.getCurrentStage() != null ? projectData.getCurrentStage() : "N/A");
        tvBookValue.setText("USD " + projectData.getAmount());
        tvPlannedCost.setText("USD " + projectData.getPlannedAmount());
        tvActualCost.setText("USD " + projectData.getActualCost());
        tvClientNAme.setText(projectData.getClientName() != null ? projectData.getClientName() : "N/A");
        tvTeam.setText(projectData.getTeamName() != null ? projectData.getTeamName() : "N/A");
        tvBusinessCategory.setText(projectData.getVertical() != null ? projectData.getVertical() : "N/A");
        tvProjectManager.setText(projectData.getPmName() != null ? projectData.getPmName() : "N/A");
        tvPlannedCompletionDate.setText(projectData.getPlannedDate() != null && !("").equals(projectData.getPlannedDate()) ? DateUtil.displayDateTimeFromHit(projectData.getPlannedDate(), "MM/dd/yyyy") : "N/A");
        tvRaisedAmount.setText("USD " + projectData.getAmount());
        tvEntryDate.setText(projectData.getEnteryDate() != null ? DateUtil.displayDateTimeFromHit(projectData.getEnteryDate(), "MM/dd/yyyy") : "N/A");
        tvProductionReady.setText(projectData.getProductionRedy() != null && !("").equals(projectData.getProductionRedy()) ? projectData.getProductionRedy() : "N/A");
        tvSalesOrderId.setText(projectData.getSaleOrderTitle() != null ? projectData.getSaleOrderTitle() : "N/A");
        setOutStandingBalance(tvOutstanding);
        btnMilestones = findViewById(R.id.btn_view_milestones);

    }

    private void setOutStandingBalance(TextView tvOutstanding) {
        int totalAmount = 0, raisedAmount = 0, outStandingAmount;
        for (int i = 0; i < projectData.getReleases().size(); i++) {
            totalAmount = totalAmount + projectData.getReleases().get(i).getAmount();
            raisedAmount = raisedAmount + projectData.getReleases().get(i).getRaised();
        }
        outStandingAmount = totalAmount - raisedAmount;
        tvOutstanding.setText("USD " + outStandingAmount);
    }

    private void init() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Project Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        tvProjectName = findViewById(R.id.tv_project_name);
        tvKickOffDate = findViewById(R.id.tv_kick_off);
        tvStage = findViewById(R.id.tv_stage);
        tvBookValue = findViewById(R.id.tv_book_value);
        tvPlannedCost = findViewById(R.id.tv_planned_cost);
        tvActualCost = findViewById(R.id.tv_actual_cost);
        tvClientNAme = findViewById(R.id.tv_client_name);
        tvProjectManager = findViewById(R.id.tv_pm_name);
        tvPlannedCompletionDate = findViewById(R.id.tv_planned_completion_date);
        tvRaisedAmount = findViewById(R.id.tv_raised_amount);
        tvOutstanding = findViewById(R.id.tv_outstanding);
        tvEntryDate = findViewById(R.id.tv_entry_date);
        tvProductionReady = findViewById(R.id.tv_productionready);
        tvSalesOrderId = findViewById(R.id.tv_sales_order_id);
        tvTeam = findViewById(R.id.tv_team);
        tvBusinessCategory = findViewById(R.id.tv_buisness_category);

        btnMilestones = findViewById(R.id.btn_view_milestones);
        btnMilestones.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_view_milestones:
                openMilestonesActivity();
                break;
            default:
                break;
        }
    }

    private void openMilestonesActivity() {
        if (projectData.getReleases().size() >= 0) {
            Intent intent = new Intent(this, MilestonesActivity.class);
            intent.putParcelableArrayListExtra("RELEASE_LIST", projectData.getReleases());
            startActivity(intent);
        } else {
            Toast.makeText(this, "No Releases Found", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
