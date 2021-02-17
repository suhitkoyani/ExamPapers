package com.example.suhitkoyani.cspitexampaper;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by suhitkoyani on 7/9/2017.
 */

public class BranchAdapter extends RecyclerView.Adapter<BranchAdapter.MyViewHolder> {
  private List<Branch>  BranchList;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
       public TextView bname;
      public MyViewHolder(View view){
        super(view);
        bname = (TextView) view.findViewById(R.id.bname);

      }
    }
  public BranchAdapter(List<Branch> BranchList){
    this.BranchList = BranchList;
  }
  public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.branch_show, parent, false);

    return new MyViewHolder(itemView);
  }
  public void onBindViewHolder(MyViewHolder holder, int position) {
    Branch branch_obj = BranchList.get(position);
    holder.bname.setText(branch_obj.getBranch_name());
  }
  public int getItemCount() {
    return BranchList.size();
  }
}

