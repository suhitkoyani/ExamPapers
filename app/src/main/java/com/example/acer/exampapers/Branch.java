package com.example.acer.exampapers;

/**
 * Created by acer on 7/9/2017.
 */

public class Branch {
    private String branch_name;
    Branch(){}
    Branch(String bname){
        this.branch_name =bname;
    }
    public void setBranch_name(String bname){
        this.branch_name = bname;
    }
    public String getBranch_name(){
        return branch_name;
    }
}
