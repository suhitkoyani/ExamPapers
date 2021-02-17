package com.example.suhitkoyani.cspitexampaper;

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
 * Created by suhitkoyani on 7/9/2017.
 */

public class SemesterCivil extends AppCompatActivity {

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
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(SemesterCivil.this);
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
                        Intent i = new Intent(SemesterCivil.this, SemesterOneCivil.class);
                        startActivity(i);
                        break;
                    }
                    case 1:{
                        Intent i = new Intent(SemesterCivil.this, SemesterTwoCivil.class);
                        startActivity(i);
                        break;
                    }
                    case 2: {
                        Intent i = new Intent(SemesterCivil.this, SemesterThreeCivil.class);
                        startActivity(i);
                        break;
                    }
                    case 3: {
                        Intent i = new Intent(SemesterCivil.this, SemesterFourCivil.class);
                        startActivity(i);
                        break;
                    }
                    case 4: {
                        Intent i = new Intent(SemesterCivil.this, SemesterFiveCivil.class);
                        startActivity(i);
                        break;
                    }
                    case 5:{
                        Intent i = new Intent(SemesterCivil.this, SemesterSixCivil.class);
                        startActivity(i);
                        break;
                    }
                    case 6: {
                        Intent i = new Intent(SemesterCivil.this, SemesterSevenCivil.class);
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

        branch_obj = new Branch("Fifth semester");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Sixth semester");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Seventh semester");
        SemesterList.add(branch_obj);
    }
}

