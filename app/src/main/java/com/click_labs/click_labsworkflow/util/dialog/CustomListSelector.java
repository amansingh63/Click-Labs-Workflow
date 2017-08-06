package com.click_labs.click_labsworkflow.util.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.click_labs.click_labsworkflow.R;
import com.click_labs.click_labsworkflow.util.EditTextUtil;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Aman Singh on 08-07-2017.
 */

public class CustomListSelector {
    private Activity activity;
    private Dialog dialog;
    private MaterialEditText etSearch;
    private ArrayList<String> list;
    private RecyclerView rvList;
    private TextView tvTitle;
    private View vDivider;
    private String value;
    private CustomListAdapter.OnListItemSelectedListener mOnListItemSelectedListener;


    /**
     * Constructor to Call
     *
     * @param activity for passing activity where to show
     */

    public CustomListSelector(Activity activity, ArrayList<String> list) {
        this.activity = activity;
        this.list = list;
        dialog = new Dialog(activity, android.R.style.Theme_Dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.layout_custom_list_selector);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(true);
    }


    public static CustomListSelector showCustomListSelector(Activity activity, ArrayList<String> list) {
        return new CustomListSelector(activity, list);
    }

    public CustomListSelector setListTitle(String title) {
        if (dialog != null) {
            tvTitle = (TextView) dialog.findViewById(R.id.tv_list_title);
            vDivider = (View) dialog.findViewById(R.id.v_divider);
            vDivider.setVisibility(View.VISIBLE);
            tvTitle.setText(title);
            tvTitle.setVisibility(View.VISIBLE);
            tvTitle.setAllCaps(true);
        }
        return this;
    }

    public CustomListSelector sortList() {
        if (dialog != null) {
            Collections.sort(list);
        }
        return this;
    }

    public CustomListSelector addSearch() {
        etSearch = (MaterialEditText) dialog.findViewById(R.id.et_search);
        EditTextUtil.setIgnoreFirstWhiteSpace(etSearch);
        etSearch.setVisibility(View.VISIBLE);
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                charSequence = charSequence.toString().trim().toLowerCase();

                final ArrayList<String> filteredProjectNameList = new ArrayList<>();

                for (int j = 0; j < list.size(); j++) {

                    final String text = list.get(j).toLowerCase();

                    if (text.contains(charSequence)) {
                        filteredProjectNameList.add(list.get(j));
                    }
                }

                setRecyclerView(mOnListItemSelectedListener, filteredProjectNameList);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return this;
    }


    public void show(CustomListAdapter.OnListItemSelectedListener onListItemSelectedListener) {
        if (dialog != null) {
            dialog.show();
            rvList = (RecyclerView) dialog.findViewById(R.id.rv_list);
            rvList.setHasFixedSize(true);
            mOnListItemSelectedListener = onListItemSelectedListener;
            rvList.setLayoutManager(new LinearLayoutManager(activity));
            rvList.addItemDecoration(new HorizontalDividerItemDecoration.Builder(activity).build());
            setRecyclerView(mOnListItemSelectedListener, list);
        }

    }

    private void setRecyclerView(CustomListAdapter.OnListItemSelectedListener onListItemSelectedListener, ArrayList<String> projectNameList) {
        CustomListAdapter customListAdapter = new CustomListAdapter(activity, onListItemSelectedListener, dialog);
        customListAdapter.add(projectNameList);
        rvList.setAdapter(customListAdapter);
    }
}
