package com.example.acer.exampapers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Branch> BranchList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BranchAdapter branchAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        branchAdapter = new BranchAdapter(BranchList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(branchAdapter);
        addBranchData();

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                switch (position){
                    case 0:{
                        Intent i = new Intent(MainActivity.this,SemesterCivil.class);
                        startActivity(i);
                        break;
                    }
                    case 1:{
                        Intent i = new Intent(MainActivity.this,SemesterComputer.class);
                        startActivity(i);
                        break;
                    }
                    case 2:{
                        Intent i = new Intent(MainActivity.this,SemesterElectrical.class);
                        startActivity(i);
                        break;
                    }
                    case 3:{
                        Intent i = new Intent(MainActivity.this,SemesterElectronics.class);
                        startActivity(i);
                        break;
                    }
                    case 4:{
                        Intent i = new Intent(MainActivity.this,SemesterEC.class);
                        startActivity(i);
                        break;
                    }
                    case 5:{
                        Intent i = new Intent(MainActivity.this,SemesterIT.class);
                        startActivity(i);
                        break;
                    }
                    case 6:{
                        Intent i = new Intent(MainActivity.this,SemesterMechanical.class);
                        startActivity(i);
                        break;
                    }
                    case 7:{
                        Intent i = new Intent(MainActivity.this,SemesterProduction.class);
                        startActivity(i);
                        break;
                    }
                }

            }
        }));
    }
    public boolean onCreateOptionsMenu(Menu menu){
     getMenuInflater().inflate(R.menu.about,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            Intent ab_intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(ab_intent);
            return super.onOptionsItemSelected(item);
        }

    public void addBranchData(){
       Branch branch_obj = new Branch("Civil Engineering");
       BranchList.add(branch_obj);

       branch_obj = new Branch("Computer Engineering");
       BranchList.add(branch_obj);

       branch_obj = new Branch("Electrical Engineering");
       BranchList.add(branch_obj);

       branch_obj = new Branch("Electronics Engineering");
       BranchList.add(branch_obj);

       branch_obj = new Branch("EC Engineering");
       BranchList.add(branch_obj);

       branch_obj = new Branch("IT Engineering");
       BranchList.add(branch_obj);

       branch_obj = new Branch("Mechanical Engineering");
       BranchList.add(branch_obj);

       branch_obj = new Branch("Production Engineering");
       BranchList.add(branch_obj);
   }
    public static interface ClickListener{
        public void onClick(View view,int position);
    }
}
