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

public class SemesterFiveIT extends Activity {

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
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(SemesterFiveIT.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(branchAdapter);
        addSubjectData();
    }
    public void addSubjectData(){
        Branch branch_obj = new Branch("DBMS");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("OOP With C++");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Digital Logic Design");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Computer Networks");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Advanced Engineering Maths");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Professional Soft Skills");
        SemesterList.add(branch_obj);
    }
}
