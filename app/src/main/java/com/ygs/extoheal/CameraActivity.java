package com.ygs.extoheal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class CameraActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_research_layout);
        CardView researchCard = findViewById(R.id.base_res_card);
        researchCard.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int id  = v.getId();
        switch (id){

        }

    }
}

