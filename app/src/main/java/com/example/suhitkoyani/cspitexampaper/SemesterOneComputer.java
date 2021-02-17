package com.example.suhitkoyani.cspitexampaper;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by suhitkoyani on 7/9/2017.
 */

public class SemesterOneComputer extends AppCompatActivity {

    private List<Branch> SemesterList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BranchAdapter branchAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        //final PDFView pdfView = (PDFView) findViewById(R.id.pdfView);
        branchAdapter = new BranchAdapter(SemesterList);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(SemesterOneComputer.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(branchAdapter);
        addSubjectData();
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new MainActivity.ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                switch (position) {
                    case 0: {
                        try{
                            Toast.makeText(getBaseContext(), "Opening PDF... ", Toast.LENGTH_SHORT).show();
                            Intent inte = new Intent(Intent.ACTION_VIEW,Uri.parse("https://firebasestorage.googleapis.com/v0/b/examplestorage-feb74.appspot.com/o/Computer-Science-and-Information-Technology.pdf?alt=media&token=de98c261-4da8-49ec-b84b-71588f6734bb"));
                            /*inte.setDataAndType(
                                    Uri.parse("http://192.168.0.68/test/cirti.pdf"),
                                    "application/pdf");*/

                            startActivity(inte);
                        }catch(ActivityNotFoundException e){
                            Log.e("Viewer not installed.", e.getMessage());
                        }
                        break;
                    }
                    case 1:{
                        try{
                            Toast.makeText(getBaseContext(), "Opening PDF... ", Toast.LENGTH_SHORT).show();
                            Intent inte = new Intent(Intent.ACTION_VIEW,Uri.parse("https://firebasestorage.googleapis.com/v0/b/examplestorage-feb74.appspot.com/o/CS-2014-solved.pdf?alt=media&token=198e884d-9c16-49c8-8823-ad802d30fb12"));
                            /*inte.setDataAndType(
                                    Uri.parse("http://192.168.0.68/test/cirti.pdf"),
                                    "application/pdf");*/

                            startActivity(inte);
                        }catch(ActivityNotFoundException e){
                            Log.e("Viewer not installed.", e.getMessage());
                        }
                        break;
                    }
                }
            }
        }));
    }
    public void addSubjectData(){
        Branch branch_obj = new Branch("Calculus");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Fundamental of Electronics");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("EME");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Engineering Physics");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Communication Skills");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Computer Workshop");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("Electronics Workshop");
        SemesterList.add(branch_obj);
    }
}



