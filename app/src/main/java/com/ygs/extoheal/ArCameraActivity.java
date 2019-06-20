package com.ygs.extoheal;

import android.app.Activity;
import android.content.Intent;
import android.opengl.GLES20;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class ArCameraActivity extends Activity implements View.OnClickListener,GLSurfaceView.Renderer {
    private GLSurfaceView surfaceView;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ar_layout);
        surfaceView = findViewById(R.id.glSurfaceView);

        // Configure the basic properties of GLSurfaceView and set renderer.
        surfaceView.setPreserveEGLContextOnPause(true);
        surfaceView.setEGLContextClientVersion(2);
        surfaceView.setEGLConfigChooser(8, 8, 8, 8, 16, 0); // Alpha used for plane blending.
        surfaceView.setRenderer(this);
        surfaceView.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
    }
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES20.glClearColor(1f, 0f, 0f, 1.0f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);
    }
    @Override
    public void onClick(View v) {
        int id  = v.getId();
        switch (id){

        }

    }
}

