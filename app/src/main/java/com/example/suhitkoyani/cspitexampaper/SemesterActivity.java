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

public class SemesterActivity extends AppCompatActivity {

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
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(SemesterActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(branchAdapter);
        addSemesterData();
}
 public void addSemesterData(){
     Branch branch_obj = new Branch("First Semester");
     SemesterList.add(branch_obj);

     branch_obj = new Branch("Second Semester");
     SemesterList.add(branch_obj);

     branch_obj = new Branch("Third Semester");
     SemesterList.add(branch_obj);

     branch_obj = new Branch("Fourth semester");
     SemesterList.add(branch_obj);

     branch_obj = new Branch("Fifth semester");
     SemesterList.add(branch_obj);

     branch_obj = new Branch("Sixth semester");
     SemesterList.add(branch_obj);

     branch_obj = new Branch("Seventh semester");
     SemesterList.add(branch_obj);
 }
}
