package com.ygs.extoheal;

import android.app.Activity;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.view.MotionEvent;

import android.view.View;

import com.ygs.extoheal.utils.CameraPermissionHelper;
import com.ygs.extoheal.utils.TapHelper;
import org.rajawali3d.view.SurfaceView;
import org.rajawali3d.view.ISurface;

public class ArCameraActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ar_layout);
        SurfaceView surfaceView =(SurfaceView)findViewById(R.id.surfaceView);
        RenderEarth renderer = new RenderEarth(this);
        surfaceView.setFrameRate(60.0);
        surfaceView.setRenderMode(ISurface.RENDERMODE_WHEN_DIRTY);
        surfaceView.setSurfaceRenderer(renderer);



    }
    @Override
    public void onClick(View v) {
        int id  = v.getId();
        switch (id){

        }

    }

}

