package com.example.acer.exampapers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 7/9/2017.
 */

public class SemesterElectronics extends AppCompatActivity {

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
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(SemesterElectronics.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(branchAdapter);
        addSemesterData();
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new MainActivity.ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                switch (position) {
                    case 0: {
                        Intent i = new Intent(SemesterElectronics.this, SemesterOneElectronics.class);
                        startActivity(i);
                        break;
                    }
                    case 1:{
                        Intent i = new Intent(SemesterElectronics.this, SemesterTwoElectronics.class);
                        startActivity(i);
                        break;
                    }
                    case 2: {
                        Intent i = new Intent(SemesterElectronics.this, SemesterThreeElectronics.class);
                        startActivity(i);
                        break;
                    }
                    case 3: {
                        Intent i = new Intent(SemesterElectronics.this, SemesterFourElectronics.class);
                        startActivity(i);
                        break;
                    }
                }
            }
        }));
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
    }
}


