package com.example.donate.Model;

import android.widget.EditText;
public class DDonorfeedback {
    private String ddname;
    private String ddfeedback;


    public DDonorfeedback() {
    }

    public DDonorfeedback(String ddname, String ddfeedback) {
        this.ddname = ddname;
        this.ddfeedback = ddfeedback;

    }

    public String getDDName() {
        return ddname;
    }

    public void setDDName(String ddname) {
        this.ddname = ddname;
    }

    public String getFeedbackmail() {
        return ddfeedback;
    }

    public void setFeedback(String ddfeedback) {
        this.ddfeedback = ddfeedback;
    }


}




