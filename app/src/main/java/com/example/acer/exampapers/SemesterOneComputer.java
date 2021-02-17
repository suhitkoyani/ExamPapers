package com.example.acer.exampapers;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 7/9/2017.
 */

public class SemesterOneComputer extends AppCompatActivity {

    private List<Branch> SemesterList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BranchAdapter branchAdapter;
    private String sub1_url="https://firebasestorage.googleapis.com/v0/b/examplestorage-feb74.appspot.com/o/Computer-Science-and-Information-Technology.pdf?alt=media&token=de98c261-4da8-49ec-b84b-71588f6734bb";
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
        final ProgressDialog progressDialog = new ProgressDialog(this);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new MainActivity.ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                switch (position) {
                    case 0: {
                        try{
                            Intent inte = new Intent(getApplicationContext(),webview.class);
                            inte.putExtra("URL",sub1_url);
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
                            startActivity(inte);
                        }catch(ActivityNotFoundException e){
                            Log.e("Viewer not installed.", e.getMessage());
                        }
                        break;
                    }
                    case 2:{
                        FirebaseStorage storage = FirebaseStorage.getInstance();
                        final StorageReference storageRef = storage.getReferenceFromUrl("https://firebasestorage.googleapis.com/v0/b/examplestorage-feb74.appspot.com/o/CS-2014-solved.pdf?alt=media&token=198e884d-9c16-49c8-8823-ad802d30fb12");
                        try{
                            progressDialog.setTitle("Downloading");
                            progressDialog.show();
                            final File localfile = File.createTempFile("pdf","pdf");
                            storageRef.getFile(localfile)
                                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                                        @Override
                                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                                            progressDialog.dismiss();
                                            Toast.makeText(getApplicationContext(),"added Sucessfully",Toast.LENGTH_LONG).show();
                                        }
                                    }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception exception) {
                                progressDialog.dismiss();
                                Toast.makeText(getApplicationContext(),"Download Failed",Toast.LENGTH_LONG).show();
                            }
                        }).addOnProgressListener(new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
                            @Override
                            public void onProgress(FileDownloadTask.TaskSnapshot taskSnapshot) {
                                // double progress = (100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount()
                                progressDialog.setMessage("In Progress");
                            }
                        });
                        }catch(Exception e){

                        }

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



