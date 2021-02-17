package com.example.suhitkoyani.cspitexampaper;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SuhitKoyani on 11/5/2017.
 */

public class SemesterSevenIT extends Activity {

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
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(SemesterSevenIT.this);
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
                            Intent inte = new Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/cspitexampapers.appspot.com/o/171511-170702-Mobile%20Computing%20Dec%202015.pdf?alt=media&token=0d5fc4c4-b3af-4ebb-b1bf-6dd9c4e3dd40"));
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
                            Intent inte = new Intent(Intent.ACTION_VIEW,Uri.parse("https://firebasestorage.googleapis.com/v0/b/cspitexampapers.appspot.com/o/IMG_20120101_061557.jpg?alt=media&token=4046903a-d091-4820-8679-44458cbecbf2"));
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
        Branch branch_obj = new Branch("WCMC");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("ARP");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("DWDM");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("HCP");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("IPMS");
        SemesterList.add(branch_obj);

        branch_obj = new Branch("SGP");
        SemesterList.add(branch_obj);
    }
}
