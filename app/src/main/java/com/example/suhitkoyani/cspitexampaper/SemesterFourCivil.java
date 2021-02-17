package com.example.suhitkoyani.cspitexampaper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suhitkoyani on 7/9/2017.
 */

public class SemesterFourCivil extends AppCompatActivity {

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
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(SemesterFourCivil.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(branchAdapter);
        addSubjectData();
    }
    public void addSubjectData(){
        Branch branch_obj = new Branch("Advanced Engineering Maths");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Professional Skills");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Fuild Mechanics");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Building Construction & Planning");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Basic Geotechnical Engineering");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Indeterminate Structures");
        SemesterList.add(branch_obj);
    }
}


