package com.example.suhitkoyani.cspitexampaper;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SuhitKoyani on 11/5/2017.
 */

public class SemesterSevenMechanical extends Activity {

    private List<Branch> SemesterList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BranchAdapter branchAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        branchAdapter = new BranchAdapter(SemesterList);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(SemesterSevenMechanical.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(branchAdapter);
        addSubjectData();
    }
    public void addSubjectData(){
        Branch branch_obj = new Branch("Numerical Methods");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Mechanical Measure.&Metro.");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Engineering Thrermodynamics");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Machining Process");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Kinemetics of Machine");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Economics & Management");
        SemesterList.add(branch_obj);
    }
}
