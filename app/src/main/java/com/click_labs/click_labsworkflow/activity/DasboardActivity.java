package com.click_labs.click_labsworkflow.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.click_labs.click_labsworkflow.R;
import com.click_labs.click_labsworkflow.adapter.DashboardAdapter;
import com.click_labs.click_labsworkflow.adapter.TimeSheetAdapter;
import com.click_labs.click_labsworkflow.constants.AppConstant;
import com.click_labs.click_labsworkflow.database.CommonData;
import com.click_labs.click_labsworkflow.fragment.AddTimesheetFragment;
import com.click_labs.click_labsworkflow.fragment.TimesheetDetailsFragment;
import com.click_labs.click_labsworkflow.model.dashboard.DashboardResponse;
import com.click_labs.click_labsworkflow.model.timesheetresponse.TimesheetResponseData;
import com.click_labs.click_labsworkflow.retrofit.APIError;
import com.click_labs.click_labsworkflow.retrofit.ResponseResolver;
import com.click_labs.click_labsworkflow.retrofit.RestClient;
import com.click_labs.click_labsworkflow.util.EndlessRecyclerOnScrollListener;
import com.click_labs.click_labsworkflow.util.Util;
import com.click_labs.click_labsworkflow.util.dialog.CustomAlertDialog;

import io.paperdb.Paper;
import retrofit2.Call;

public class DasboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AppConstant {

    private static int TIMESHEET_ADDED = 100;
    private RecyclerView rvDashboard;
    private Call retrofitCall;
    private TimeSheetAdapter timeSheetAdapter;
    private DashboardAdapter dashboardAdapter;
    private LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    private Dialog mDialog;
    private FloatingActionButton fabAddNewTimesheet;
    private NavigationView navigationView;
    private int skip = 0, limit = 10;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Paper.init(this);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        rvDashboard = (RecyclerView) findViewById(R.id.rv_timesheet);
        rvDashboard.setLayoutManager(linearLayoutManager);
        fabAddNewTimesheet = (FloatingActionButton) findViewById(R.id.fab_add_timeshhet);
        fabAddNewTimesheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent addNewTimesheetintent = new Intent(DasboardActivity.this, AddTimesheetActivity.class);
                if (Util.isNetworkAvailable(DasboardActivity.this)) {
                    startActivityForResult(addNewTimesheetintent, TIMESHEET_ADDED);
                } else {
                    if (mDialog != null && mDialog.isShowing()) {
                        mDialog.dismiss();
                    }
                    mDialog = new CustomAlertDialog.Builder(DasboardActivity.this)
                            .setMessage(R.string.error_internet_not_connected)
                            .setPositiveButton(R.string.text_retry, new CustomAlertDialog.CustomDialogInterface.OnClickListener() {
                                @Override
                                public void onClick() {
                                    if (Util.isNetworkAvailable(DasboardActivity.this)) {
                                        startActivity(addNewTimesheetintent);
                                    } else {
                                        mDialog.show();
                                    }

                                }
                            })
                            .setNegativeButton(getString(R.string.text_exit), new CustomAlertDialog.CustomDialogInterface.OnClickListener() {
                                @Override
                                public void onClick() {
                                    finish();
                                }
                            })
                            .show();
                }

            }
        });

        if (Util.isNetworkAvailable(this)) {
            setData();
        } else {
            if (mDialog != null && mDialog.isShowing()) {
                mDialog.dismiss();
            }
            mDialog = new CustomAlertDialog.Builder(this)
                    .setMessage(R.string.error_internet_not_connected)
                    .setPositiveButton(R.string.text_retry, new CustomAlertDialog.CustomDialogInterface.OnClickListener() {
                        @Override
                        public void onClick() {
                            if (Util.isNetworkAvailable(DasboardActivity.this)) {
                                setData();
                            } else {
                                mDialog.show();
                            }

                        }
                    })
                    .setNegativeButton(getString(R.string.text_exit), new CustomAlertDialog.CustomDialogInterface.OnClickListener() {
                        @Override
                        public void onClick() {
                            finish();
                        }
                    })
                    .show();
        }


    }

    private void setData() {
        if (CommonData.getUserDesignation().equals(EMPLOYEE)) {
            apiHitToGetTimeSheet();
            swipeRefreshLayout.setEnabled(false);
        } else {
            navigationView.getMenu().findItem(R.id.nav_home).setTitle("My Dashboard");
            fabAddNewTimesheet.setVisibility(View.GONE);
            apiHitToGetDashboardData(skip);
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    skip = 0;
                    if (Util.isNetworkAvailable(DasboardActivity.this)) {
                        apiHitToGetDashboardData(skip);
                    } else {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }
            });
        }
    }

    private void apiHitToGetDashboardData(int start) {
        Log.e("SKIP - LIMIT", start + " " + limit);
        retrofitCall = RestClient.getApiInterface().getDashboardDetails(CommonData.getAccessToken(), limit, start);
        swipeRefreshLayout.setRefreshing(true);
        retrofitCall.enqueue(new ResponseResolver<DashboardResponse>(this, false, true) {

            @Override
            public void success(DashboardResponse timesheetResponseData) {
                swipeRefreshLayout.setRefreshing(false);
                if (skip == 0) {

                    dashboardAdapter = new DashboardAdapter(timesheetResponseData.getData());
                    rvDashboard.setAdapter(dashboardAdapter);
                    setScrollListener();
                } else if (timesheetResponseData.getData().size() >= 0) {
                    dashboardAdapter.addData(timesheetResponseData.getData());
                }
                skip = skip + limit;
            }

            @Override
            public void failure(APIError error) {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }


    private void apiHitToGetTimeSheet() {

        retrofitCall = RestClient.getApiInterface().getTimesheet(CommonData.getAccessToken());
        retrofitCall.enqueue(new ResponseResolver<TimesheetResponseData>(this, true, true) {

            @Override
            public void success(TimesheetResponseData timesheetResponseData) {
                timeSheetAdapter = new TimeSheetAdapter(DasboardActivity.this, timesheetResponseData.getData(), new AddTimesheetFragment.OnEditListener() {
                    @Override
                    public void onEdit() {
                        apiHitToGetTimeSheet();
                    }
                }, new TimesheetDetailsFragment.OnDeleteListner() {
                    @Override
                    public void onDelete() {
                        apiHitToGetTimeSheet();
                    }
                });
                rvDashboard.setLayoutManager(linearLayoutManager);
                rvDashboard.setAdapter(timeSheetAdapter);
            }

            @Override
            public void failure(APIError error) {
            }
        });


    }


    /**
     * set scroll listeners
     */
    private void setScrollListener() {

        rvDashboard.addOnScrollListener(new EndlessRecyclerOnScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {

                if (!swipeRefreshLayout.isRefreshing()) {
                    if (Util.isNetworkAvailable(DasboardActivity.this)) {
                        apiHitToGetDashboardData(skip);
                    }
                } else {
                    Toast.makeText(DasboardActivity.this, "No Internet Connection", Toast.LENGTH_LONG).show();
                }
            }

        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {

            new CustomAlertDialog.Builder(this).setTitle("About")
                    .setMessage(R.string.text_about).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_logout) {

            new CustomAlertDialog.Builder(this).setMessage(R.string.text_are_you_sure_to_logout)
                    .setCancelable(true)
                    .setNegativeButton("Yes", new CustomAlertDialog.CustomDialogInterface.OnClickListener() {
                        @Override
                        public void onClick() {

                            Intent intent = new Intent(DasboardActivity.this, SplashActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                                    | Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    | Intent.FLAG_ACTIVITY_NEW_TASK);
                            CommonData.clearData();
                            startActivity(intent);
                        }
                    })
                    .setPositiveButton("No", new CustomAlertDialog.CustomDialogInterface.OnClickListener() {
                        @Override
                        public void onClick() {
                            navigationView.setCheckedItem(R.id.nav_home);

                        }
                    }).show();
        } else if (id == R.id.nav_reset_password) {
            Intent changePasswordIntent = new Intent(this, ChangePasswordActivity.class);
            startActivity(changePasswordIntent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TIMESHEET_ADDED && resultCode == RESULT_OK) {
            apiHitToGetTimeSheet();
        }


    }

    @Override
    protected void onResume() {
        navigationView.setCheckedItem(R.id.nav_home);
        super.onResume();
    }
}
